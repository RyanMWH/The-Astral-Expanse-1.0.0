package com.eclipsense.voidexpanse.item;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.block.ModBlocks;
import com.eclipsense.voidexpanse.util.ModTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.eclipsense.voidexpanse.block.ModBlocks.END_STONE_VOIDINIUM_ORE;
import static com.eclipsense.voidexpanse.block.ModBlocks.VOIDINIUM_BLOCK;

public class ModItems {
    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, VoidExpanse.MODID);

    //public static final DeferredHolder<Item, Item> OUTPOST_MAP = ITEMS.register("outpost_map", () -> new Item(new Item.Properties()));


    // Items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoidExpanse.MODID);

    // Items for/from End
    public static final DeferredItem<Item> VOIDINIUM_SHARD = ITEMS.registerItem("voidinium_shard",
            properties -> new Item(properties));
    public static final DeferredItem<Item> CONCENTRATED_VOIDINIUM = ITEMS.registerItem("concentrated_voidinium",
            properties -> new GlintItem(properties));
    public static final DeferredItem<Item> VOIDINIUM_INGOT = ITEMS.registerItem("voidinium_ingot",
            properties -> new Item(properties));
    public static final DeferredItem<Item> VOID_INFUSED_HEART = ITEMS.registerItem("void_infused_heart",
            properties -> new GlintItem(properties.fireResistant().stacksTo(16)));
    public static final DeferredItem<Item> VOID_FRAGMENT = ITEMS.registerItem("void_fragment",
            properties -> new GlintItem(properties.fireResistant().stacksTo(16)));

    // Voidinium Tools
    public static final DeferredItem<SwordItem> VOIDINIUM_SWORD = ITEMS.registerItem("voidinum_sword",
            properties -> new SwordItem(VoidToolTiers.VOIDINIUM, 3.5F, -2.2F, properties),
            new Item.Properties());
    public static final DeferredItem<ShovelItem> VOIDINIUM_SHOVEL = ITEMS.registerItem("voidinium_shovel",
            properties -> new ShovelItem(VoidToolTiers.VOIDINIUM, 2.0F, -3.5F, properties),
            new Item.Properties());
    public static final DeferredItem<PickaxeItem> VOIDINIUM_PICKAXE = ITEMS.registerItem("voidinium_pickaxe",
            properties -> new PickaxeItem(VoidToolTiers.VOIDINIUM, 1.0F, -3.0F, properties),
            new Item.Properties());
    public static final DeferredItem<AxeItem> VOIDINIUM_AXE = ITEMS.registerItem("voidinium_axe",
            properties -> new AxeItem(VoidToolTiers.VOIDINIUM, 5.0F, -3.2F, properties),
            new Item.Properties());
    public static final DeferredItem<HoeItem> VOIDINIUM_HOE = ITEMS.registerItem("voidinium_hoe",
            properties -> new HoeItem(VoidToolTiers.VOIDINIUM, -4.0F, 0.0F, properties),
            new Item.Properties());

    // Block items
    public static final DeferredItem<BlockItem> END_STONE_VOIDINIUM_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "end_stone_voidinium_ore",
            END_STONE_VOIDINIUM_ORE);
    public static final DeferredItem<BlockItem> VOIDINIUM_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "voidinium_block",
            VOIDINIUM_BLOCK);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
