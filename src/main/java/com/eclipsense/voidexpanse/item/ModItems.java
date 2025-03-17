package com.eclipsense.voidexpanse.item;

import com.eclipsense.voidexpanse.VoidExpanse;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, VoidExpanse.MODID);

    //public static final DeferredHolder<Item, Item> OUTPOST_MAP = ITEMS.register("outpost_map", () -> new Item(new Item.Properties()));

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoidExpanse.MODID);

    public static final DeferredItem<Item> VOIDINIUM_SHARD = ITEMS.registerItem("voidinium_shard", properties -> new Item(properties));
    public static final DeferredItem<Item> CONCENTRATED_VOIDINIUM = ITEMS.registerItem("concentrated_voidinium", properties -> new Item(properties));
    public static final DeferredItem<Item> VOIDINIUM_INGOT = ITEMS.registerItem("voidinium_ingot", properties -> new Item(properties));
    public static final DeferredItem<Item> VOID_INFUSED_HEART = ITEMS.registerItem("void_infused_heart", properties -> new GlintItem(properties.fireResistant().stacksTo(16)));
    public static final DeferredItem<Item> VOID_FRAGMENT = ITEMS.registerItem("void_fragment", properties -> new GlintItem(properties.fireResistant().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
