
package com.eclipsense.astralexpanse.entity.client.voidprowler;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class VoidProwlerModel extends EntityModel<VoidProwlerRenderState> {
    private final ModelPart root;

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("voidexpanse", "void_prowler"), "main");

    public VoidProwlerModel(ModelPart root) {
        super(root, RenderType::entityCutoutNoCull); // Standard cutout render
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // Body
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 16.0F), PartPose.offset(0.0F, 12.0F, 0.0F));

        // Head
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 24).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 10.0F, -8.0F));

        // Tail
        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create()
                .texOffs(0, 36).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 10.0F, 8.0F));

        // Legs
        partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create()
                .texOffs(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(3.0F, 18.0F, -5.0F));
        partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create()
                .texOffs(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-3.0F, 18.0F, -5.0F));
        partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create()
                .texOffs(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(3.0F, 18.0F, 5.0F));
        partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create()
                .texOffs(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-3.0F, 18.0F, 5.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(VoidProwlerRenderState renderState) {
        super.setupAnim(renderState);

        // Future animation support can go here
        // Example: this.animate(renderState.idleAnimationState, VoidProwlerAnimations.IDLE, renderState.ageInTicks, 1.0f);
    }
}
