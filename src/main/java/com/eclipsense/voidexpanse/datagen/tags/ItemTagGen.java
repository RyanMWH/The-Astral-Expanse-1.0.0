package com.eclipsense.voidexpanse.datagen.tags;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.init.VoidItems;
import com.eclipsense.voidexpanse.init.VoidTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

// Don't think I have a need for this one
public class ItemTagGen extends ItemTagsProvider {


    public ItemTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, VoidExpanse.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(VoidTags.Items.VOIDINIUM_TOOL_MATERIALS)
                .add(VoidItems.VOIDINIUM_INGOT.get());

        tag(VoidTags.Items.VOIDINIUM_ARMOR)
                .add(VoidItems.VOIDINIUM_HELMET.get())
                .add(VoidItems.VOIDINIUM_CHESTPLATE.get())
                .add(VoidItems.VOIDINIUM_LEGGINGS.get())
                .add(VoidItems.VOIDINIUM_BOOTS.get());

        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(VoidItems.VOIDINIUM_SWORD.get());
        tag(ItemTags.SWORDS)
                .add(VoidItems.VOIDINIUM_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(VoidItems.VOIDINIUM_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(VoidItems.VOIDINIUM_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(VoidItems.VOIDINIUM_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(VoidItems.VOIDINIUM_HOE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(VoidItems.VOIDINIUM_HELMET.get())
                .add(VoidItems.VOIDINIUM_CHESTPLATE.get())
                .add(VoidItems.VOIDINIUM_LEGGINGS.get())
                .add(VoidItems.VOIDINIUM_BOOTS.get());

        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(VoidItems.VOIDINIUM_HELMET.get())
                .add(VoidItems.VOIDINIUM_CHESTPLATE.get())
                .add(VoidItems.VOIDINIUM_LEGGINGS.get())
                .add(VoidItems.VOIDINIUM_BOOTS.get());



    }
}
