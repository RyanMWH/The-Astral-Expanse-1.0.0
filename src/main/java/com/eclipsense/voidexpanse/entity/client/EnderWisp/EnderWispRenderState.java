package com.eclipsense.voidexpanse.entity.client.EnderWisp;

import com.eclipsense.voidexpanse.entity.custom.EnderWispEntity;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class EnderWispRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public float ageInTicks;

    public EnderWispRenderState() {
    }
}
