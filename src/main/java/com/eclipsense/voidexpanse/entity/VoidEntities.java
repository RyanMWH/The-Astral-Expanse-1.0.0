package com.eclipsense.voidexpanse.entity;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.entity.custom.EnderWispEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class VoidEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, VoidExpanse.MODID);

    public static final Supplier<EntityType<EnderWispEntity>> EnderWisp =
            ENTITY_TYPES.register("ender_wisp",
                    () -> EntityType.Builder.of(EnderWispEntity::new, MobCategory.CREATURE)
                            .sized(0.25f, 0.25f).build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("voidexpanse","ender_wisp"))));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
