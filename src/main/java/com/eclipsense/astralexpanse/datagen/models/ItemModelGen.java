package com.eclipsense.astralexpanse.datagen.models;

import com.eclipsense.astralexpanse.init.AstralItems;
import com.eclipsense.astralexpanse.item.equipment.AstralEquipmentAssets;
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
        this.generateFlatItem(AstralItems.VOID_INFUSED_HEART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AstralItems.VOID_FRAGMENT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AstralItems.VOIDINIUM_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AstralItems.CONCENTRATED_VOIDINIUM.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AstralItems.ENDER_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AstralItems.VOIDINIUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AstralItems.VOIDINIUM_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(AstralItems.VOIDINIUM_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(AstralItems.VOIDINIUM_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(AstralItems.VOIDINIUM_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(AstralItems.VOIDINIUM_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateTrimmableItem(AstralItems.VOIDINIUM_HELMET.get(), AstralEquipmentAssets.VOIDINIUM, "helment", false);
        this.generateTrimmableItem(AstralItems.VOIDINIUM_CHESTPLATE.get(), AstralEquipmentAssets.VOIDINIUM, "chestplate", false);
        this.generateTrimmableItem(AstralItems.VOIDINIUM_LEGGINGS.get(), AstralEquipmentAssets.VOIDINIUM, "leggings", false);
        this.generateTrimmableItem(AstralItems.VOIDINIUM_BOOTS.get(), AstralEquipmentAssets.VOIDINIUM, "boots", false);
        this.generateSpawnEgg(AstralItems.ENDER_WISP_SPAWN_EGG.get(), 1447446, 14711290);
        this.generateSpawnEgg(AstralItems.VOID_PROWLER_SPAWN_EGG.get(), 1447446, 14711290);
    }
}
