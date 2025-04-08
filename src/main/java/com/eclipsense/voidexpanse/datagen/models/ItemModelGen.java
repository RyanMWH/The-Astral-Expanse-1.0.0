package com.eclipsense.voidexpanse.datagen.models;

import com.eclipsense.voidexpanse.init.VoidItems;
import com.eclipsense.voidexpanse.item.equipment.VoidEquipmentAssets;
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
        this.generateFlatItem(VoidItems.VOID_INFUSED_HEART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(VoidItems.VOID_FRAGMENT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(VoidItems.VOIDINIUM_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(VoidItems.CONCENTRATED_VOIDINIUM.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(VoidItems.ENDER_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(VoidItems.VOIDINIUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(VoidItems.VOIDINIUM_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(VoidItems.VOIDINIUM_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(VoidItems.VOIDINIUM_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(VoidItems.VOIDINIUM_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(VoidItems.VOIDINIUM_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateTrimmableItem(VoidItems.VOIDINIUM_HELMET.get(), VoidEquipmentAssets.VOIDINIUM, "helment", false);
        this.generateTrimmableItem(VoidItems.VOIDINIUM_CHESTPLATE.get(), VoidEquipmentAssets.VOIDINIUM, "chestplate", false);
        this.generateTrimmableItem(VoidItems.VOIDINIUM_LEGGINGS.get(), VoidEquipmentAssets.VOIDINIUM, "leggings", false);
        this.generateTrimmableItem(VoidItems.VOIDINIUM_BOOTS.get(), VoidEquipmentAssets.VOIDINIUM, "boots", false);
        this.generateSpawnEgg(VoidItems.ENDER_WISP_SPAWN_EGG.get(), 1447446, 14711290);
        this.generateSpawnEgg(VoidItems.VOID_PROWLER_SPAWN_EGG.get(), 1447446, 14711290);
    }
}
