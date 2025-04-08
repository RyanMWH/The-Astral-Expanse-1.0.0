package com.eclipsense.voidexpanse.init;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.effect.VoidHungerEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VoidEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, VoidExpanse.MODID);

    public static final Holder<MobEffect> VOID_HUNGER_EFFECT = MOB_EFFECTS.register("void_hunger",
            () -> new VoidHungerEffect(MobEffectCategory.BENEFICIAL, 0x5A0480));

    public static void register (IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
