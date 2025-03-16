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

    public static final DeferredItem<Item> OUTPOST_MAP = ITEMS.registerItem("outpost_map", properties -> new Item(properties));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
