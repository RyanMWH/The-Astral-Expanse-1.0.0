package com.eclipsense.astralexpanse.datagen.models;

import com.eclipsense.astralexpanse.init.AstralBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockStateGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BlockModelGen extends BlockModelGenerators {


    public BlockModelGen(Consumer<BlockStateGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
        System.out.println("BlockModelGen constructor called!");
    }

    @Override
    public void run() {
        // Block Item Models
        this.createTrivialCube(AstralBlocks.VOIDINIUM_BLOCK.get());
        this.createTrivialCube(AstralBlocks.END_STONE_VOIDINIUM_ORE.get());
    }

}
