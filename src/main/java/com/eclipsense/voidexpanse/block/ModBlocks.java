package com.eclipsense.voidexpanse.block;

import com.eclipsense.voidexpanse.VoidExpanse;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VoidExpanse.MODID);

    // Blocks for/from End
    public static final DeferredBlock<Block> END_STONE_VOIDINIUM_ORE = BLOCKS.registerBlock(
            "end_stone_voidinium_ore",
                    VoidiniumOreBlock::new, BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_PURPLE)
                            .lightLevel((p_50876_) -> {return 7; })
                    .sound(SoundType.STONE));

    public static final DeferredBlock<Block> VOIDINIUM_BLOCK = BLOCKS.registerSimpleBlock(
            "voidinium_block",
            BlockBehaviour.Properties.of()
                    .sound(SoundType.METAL));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
