package com.eclipsense.voidexpanse.datagen.models;

import com.eclipsense.voidexpanse.VoidExpanse;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

public class ModelGen extends ModelProvider {
    public ModelGen(PackOutput output) {
        super(output, VoidExpanse.MODID);
        System.out.println("ModelGen constructor called!");

    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels = new ItemModelGen(itemModels.itemModelOutput, itemModels.modelOutput);
        blockModels = new BlockModelGen(blockModels.blockStateOutput, blockModels.itemModelOutput, itemModels.modelOutput);
        super.registerModels(blockModels, itemModels);
    }
}
