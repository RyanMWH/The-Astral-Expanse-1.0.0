package com.eclipsense.voidexpanse.datagen.models;

import com.eclipsense.voidexpanse.item.ModItems;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;

public class ItemModelGen extends ItemModelGenerators {


    public ItemModelGen(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
        System.out.println("ItemModelGen constructor called!");
    }

    @Override
    public void run() {
        // Item Item Models
        this.generateFlatItem(ModItems.VOID_INFUSED_HEART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.VOID_FRAGMENT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.VOIDINIUM_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CONCENTRATED_VOIDINIUM.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.VOIDINIUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
    }
}
