package com.eclipsense.voidexpanse.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Random;

public class VoidiniumOreBlock extends Block {
    // Codec are serialization and deserialization
    // This is allowing the block to be saved and loaded by the client/server
    public static final MapCodec<VoidiniumOreBlock> CODEC = simpleCodec(VoidiniumOreBlock::new);
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public VoidiniumOreBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, true));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource randomSource) {
        spawnParticles(level, pos);
        if (!state.getValue(LIT)){
            level.setBlock(pos, state.setValue(LIT, true), 3);
        }
    }

    @Override
    protected void attack(BlockState state, Level level, BlockPos pos, Player player) {
        interact(state, level, pos);
        if(!level.isClientSide()) {
            ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);
            if (!itemInHand.is(Items.NETHERITE_PICKAXE)) {
                double x = player.getX();
                double y = player.getY();
                double z = player.getZ();
                // We now have three positional arguments
                Random random = new Random();
                double randomx = random.nextDouble(11) - 5;
                double randomy = random.nextDouble(11) - 5;
                double randomz = random.nextDouble(11) - 5;
                // Now we have the random variation between -10,10
                double newx = x + randomx;
                double newy = y + randomy;
                double newz = z + randomz;
                // Now we teleport the player.
                player.teleportTo(newx, newy, newz);
            }
        }
    }

    protected void attack(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {

    }

    public void stepOn(Level level, BlockPos pos, BlockState state, Entity ent) {
        if (!ent.isSteppingCarefully()) {
            interact(state, level, pos);
        }

        super.stepOn(level, pos, state, ent);
    }
    private static void interact(BlockState state, Level level, BlockPos pos) {
        spawnParticles(level, pos);
        if (!(Boolean)state.getValue(LIT)) {
            level.setBlock(pos, (BlockState)state.setValue(LIT, true), 3);
        }

    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(LIT) ? 7 : 0; // Set light emission based on LIT state
    }

    private static void spawnParticles(Level level, BlockPos pos) {
        double d0 = 0.5625;
        RandomSource randomsource = level.random;
        Direction[] directions = Direction.values();

        for(Direction direction : directions) {
            BlockPos blockpos = pos.relative(direction);
            if (!level.getBlockState(blockpos).isSolidRender()) {
                Direction.Axis axis = direction.getAxis();
                double d1 = axis == Direction.Axis.X ? 0.5 + 0.5625 * (double)direction.getStepX() : (double)randomsource.nextFloat();
                double d2 = axis == Direction.Axis.Y ? 0.5 + 0.5625 * (double)direction.getStepY() : (double)randomsource.nextFloat();
                double d3 = axis == Direction.Axis.Z ? 0.5 + 0.5625 * (double)direction.getStepZ() : (double)randomsource.nextFloat();

                // Custom Color
                DustParticleOptions particle = new DustParticleOptions(16032240, 1.0f);

                level.addParticle(particle, (double)pos.getX() + d1, (double)pos.getY() + d2, (double)pos.getZ() + d3, 0.0, 0.0, 0.0);
            }
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
