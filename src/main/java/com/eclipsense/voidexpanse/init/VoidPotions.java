package com.eclipsense.voidexpanse.init;

import com.eclipsense.voidexpanse.VoidExpanse;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VoidPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, VoidExpanse.MODID);

    public static final Holder<Potion> VOID_HUNGER_POTION = POTIONS.register("void_hunger_potion",
            registryName -> new Potion(
                    registryName.getPath(),
                    new MobEffectInstance(VoidEffects.VOID_HUNGER_EFFECT, 900)));

    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
