package com.eclipsense.astralexpanse.entity.custom;

import net.minecraft.core.BlockPos;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class EnderWispEntity extends PathfinderMob implements FlyingAnimal {


    public final AnimationState idleAnimationState = new AnimationState();

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 7d)
                .add(Attributes.FLYING_SPEED, 0.1d)
                .add(Attributes.FOLLOW_RANGE, 0.1d);
    }
    @Nullable
    private BlockPos targetPosition;
    private static final int MAX_FLY_HEIGHT = 5;
    private static final int EDGE_SAFETY_DISTANCE = 3; // How far from edge to stay


    public EnderWispEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        setNoGravity(true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
    }

    private void setupAnimationState() {
        this.idleAnimationState.startIfStopped(this.tickCount);

    }

    @Override
    public void tick() {
        super.tick();

        this.setupAnimationState();

    }

    @Override
    public boolean isFlying() {
        return true;
    }

    // Check if a position is safe (has ground below and isn't too close to edge)
    private boolean isSafePosition(BlockPos pos) {
        // Check if there's ground directly below
        boolean hasGround = false;
        int groundY = -1;

        for (int i = 0; i < 20; i++) {
            BlockPos checkPos = pos.below(i);
            BlockState state = this.level().getBlockState(checkPos);
            if (state.isCollisionShapeFullBlock(this.level(), checkPos)) {
                hasGround = true;
                groundY = checkPos.getY();
                break;
            }
        }

        if (!hasGround) {
            return false; // No ground below
        }

        // Now check if we're too close to an edge by checking positions around us
        for (int dx = -EDGE_SAFETY_DISTANCE; dx <= EDGE_SAFETY_DISTANCE; dx++) {
            for (int dz = -EDGE_SAFETY_DISTANCE; dz <= EDGE_SAFETY_DISTANCE; dz++) {
                // Skip checking our own position
                if (dx == 0 && dz == 0) continue;

                // Check if this position has ground at similar Y level
                BlockPos edgePos = pos.offset(dx, 0, dz);
                boolean hasGroundNearby = false;

                // Look in a range around the ground level we found
                for (int dy = -2; dy <= 2; dy++) {
                    BlockPos checkPos = new BlockPos(edgePos.getX(), groundY + dy, edgePos.getZ());
                    BlockState state = this.level().getBlockState(checkPos);
                    if (state.isCollisionShapeFullBlock(this.level(), checkPos)) {
                        hasGroundNearby = true;
                        break;
                    }
                }

                // If we're at the safety distance and there's no ground, we're near an edge
                if (Math.abs(dx) == EDGE_SAFETY_DISTANCE || Math.abs(dz) == EDGE_SAFETY_DISTANCE) {
                    if (!hasGroundNearby) {
                        return false; // We're too close to an edge
                    }
                }
            }
        }

        return true; // Position is safe
    }

    // Helper to get ground level
    private int getGroundY() {
        BlockPos pos = this.blockPosition();

        // Look for solid blocks below
        for (int i = 0; i < 20; i++) {
            BlockPos checkPos = pos.below(i);
            BlockState state = this.level().getBlockState(checkPos);
            if (state.isCollisionShapeFullBlock(this.level(), checkPos)) {
                return checkPos.getY() + 1;
            }
        }
        return pos.getY() - 2; // Fallback
    }

    protected void customServerAiStep(ServerLevel level) {
        super.customServerAiStep(level);

        int groundY = getGroundY();
        int maxY = groundY + MAX_FLY_HEIGHT;

        // If we're in an unsafe position, move away from the edge
        if (!isSafePosition(this.blockPosition())) {
            // Find a direction toward the center of the island
            BlockPos center = BlockPos.containing(0, 70, 0);
            Vec3 direction = new Vec3(
                    center.getX() - this.getX(),
                    center.getY() - this.getY(),
                    center.getZ() - this.getZ()
            ).normalize();

            // Move in that direction
            this.setDeltaMovement(direction.scale(0.2));
            return;
        }

        if (this.targetPosition == null || this.random.nextInt(30) == 0 ||
                this.targetPosition.closerToCenterThan(this.position(), 2.0)) {

            // Keep trying until we find a valid position
            BlockPos newTarget = null;
            for (int attempt = 0; attempt < 10; attempt++) {
                int randomY = groundY + 1 + this.random.nextInt(MAX_FLY_HEIGHT);

                BlockPos potentialTarget = BlockPos.containing(
                        this.getX() + (this.random.nextInt(7) - this.random.nextInt(7)),
                        Math.min(randomY, maxY),
                        this.getZ() + (this.random.nextInt(7) - this.random.nextInt(7))
                );

                if (isSafePosition(potentialTarget)) {
                    newTarget = potentialTarget;
                    break;
                }
            }

            if (newTarget != null) {
                this.targetPosition = newTarget;
            } else {
                // If we can't find a valid target, move toward center
                this.targetPosition = new BlockPos(
                        (int)(this.getX() * 0.8),
                        groundY + MAX_FLY_HEIGHT / 2,
                        (int)(this.getZ() * 0.8)
                );
            }
        }

        // Move toward the target
        if (this.targetPosition != null) {
            double dx = this.targetPosition.getX() + 0.5 - this.getX();
            double dy = this.targetPosition.getY() + 0.5 - this.getY();
            double dz = this.targetPosition.getZ() + 0.5 - this.getZ();

            Vec3 motion = this.getDeltaMovement();
            Vec3 newMotion = motion.add(
                    (Math.signum(dx) * 0.5 - motion.x) * 0.1,
                    (Math.signum(dy) * 0.5 - motion.y) * 0.1,
                    (Math.signum(dz) * 0.5 - motion.z) * 0.1
            );

            this.setDeltaMovement(newMotion);

            // Update rotation
            float f = (float)(Mth.atan2(newMotion.z, newMotion.x) * 180.0F / Math.PI) - 90.0F;
            float f1 = Mth.wrapDegrees(f - this.getYRot());
            this.setYRot(this.getYRot() + f1);
        }
    }
}