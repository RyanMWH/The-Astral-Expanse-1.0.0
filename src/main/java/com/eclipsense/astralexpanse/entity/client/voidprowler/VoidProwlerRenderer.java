package com.eclipsense.astralexpanse.entity.client.voidprowler;

import com.eclipsense.astralexpanse.AstralExpanse;

import com.eclipsense.astralexpanse.entity.custom.VoidProwlerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.minecraft.resources.ResourceLocation;

public class VoidProwlerRenderer extends MobRenderer<VoidProwlerEntity, VoidProwlerRenderState, VoidProwlerModel> {
    public VoidProwlerRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidProwlerModel(context.bakeLayer(VoidProwlerModel.LAYER_LOCATION)), 0.25f);
    }



    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(AstralExpanse.MODID, "textures/entity/void_prowler/void_prowler.png");

    @Override
    public VoidProwlerRenderState createRenderState() {
        return new VoidProwlerRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(VoidProwlerRenderState voidProwlerRenderState) {
        return TEXTURE;
    }


    @Override
    public void extractRenderState(VoidProwlerEntity p_362733_, VoidProwlerRenderState p_360515_, float p_361157_) {
        super.extractRenderState(p_362733_, p_360515_, p_361157_);
    }
}
