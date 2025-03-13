package com.eclipsense.voidexpanse.item;

import com.eclipsense.voidexpanse.VoidExpanse;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoidExpanse.MODID);

    public static final ResourceKey<Item> OUTPOST_MAP_KEY = ResourceKey.create(
            Registries.ITEM,
            new ResourceLoc
    );

    public static final DeferredItem<Item> OUTPOST_MAP = ITEMS.registerItem("outpost_map",
    Item::new,
    new Item.Properties().stacksTo(1)
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
