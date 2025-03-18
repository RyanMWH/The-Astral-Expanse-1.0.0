package com.eclipsense.voidexpanse.item;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.eclipsense.voidexpanse.block.ModBlocks.END_STONE_VOIDINIUM_ORE;

public class ModItems {
    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, VoidExpanse.MODID);

    //public static final DeferredHolder<Item, Item> OUTPOST_MAP = ITEMS.register("outpost_map", () -> new Item(new Item.Properties()));


    // Items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoidExpanse.MODID);

    // Items for/from End
    public static final DeferredItem<Item> VOIDINIUM_SHARD = ITEMS.registerItem("voidinium_shard", properties -> new Item(properties));
    public static final DeferredItem<Item> CONCENTRATED_VOIDINIUM = ITEMS.registerItem("concentrated_voidinium", properties -> new Item(properties));
    public static final DeferredItem<Item> VOIDINIUM_INGOT = ITEMS.registerItem("voidinium_ingot", properties -> new Item(properties));
    public static final DeferredItem<Item> VOID_INFUSED_HEART = ITEMS.registerItem("void_infused_heart", properties -> new GlintItem(properties.fireResistant().stacksTo(16)));
    public static final DeferredItem<Item> VOID_FRAGMENT = ITEMS.registerItem("void_fragment", properties -> new GlintItem(properties.fireResistant().stacksTo(16)));

    // Block items
    public static final DeferredItem<BlockItem> END_STONE_VOIDINIUM_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "end_stone_voidinium_ore",
            END_STONE_VOIDINIUM_ORE);
    //public static final DeferredItem<BlockItem> VOIDINIUM_BLOCK = ITEMS.registerItem("voidinium_block", properties -> new Item(properties));


    // Blocks for/from End

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
