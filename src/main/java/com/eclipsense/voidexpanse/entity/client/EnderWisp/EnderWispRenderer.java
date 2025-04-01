package com.eclipsense.voidexpanse.entity.client.EnderWisp;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.entity.custom.EnderWispEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class EnderWispRenderer extends MobRenderer<EnderWispEntity, EnderWispRenderState, EnderWispModel> {
    public EnderWispRenderer(EntityRendererProvider.Context context) {
        super(context, new EnderWispModel(context.bakeLayer(EnderWispModel.LAYER_LOCATION)), 0.25f);
    }

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(VoidExpanse.MODID, "textures/entity/ender_wisp/ender_wisp.png");

    @Override
    public EnderWispRenderState createRenderState() {
        return new EnderWispRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(EnderWispRenderState enderWispRenderState) {
        return TEXTURE;
    }
}
