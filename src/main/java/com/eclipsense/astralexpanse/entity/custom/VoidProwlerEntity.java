package com.eclipsense.astralexpanse.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class VoidProwlerEntity extends Monster {

    public VoidProwlerEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, (double)40.0F)
                .add(Attributes.MOVEMENT_SPEED, (double)0.3F)
                .add(Attributes.ATTACK_DAMAGE, (double)7.0F)
                .add(Attributes.FOLLOW_RANGE, (double)64.0F)
                .add(Attributes.STEP_HEIGHT, (double)1.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0F, false));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 1.0F));
    }

    private void setupAnimationState() {

    }

    @Override
    public void tick() {
        super.tick();
        this.setupAnimationState();
    }
}
