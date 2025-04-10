package com.eclipsense.astralexpanse.datagen.tags;

import com.eclipsense.astralexpanse.AstralExpanse;
import com.eclipsense.astralexpanse.init.AstralItems;
import com.eclipsense.astralexpanse.init.AstralTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

// Don't think I have a need for this one
public class ItemTagGen extends ItemTagsProvider {


    public ItemTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, AstralExpanse.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(AstralTags.Items.VOIDINIUM_TOOL_MATERIALS)
                .add(AstralItems.VOIDINIUM_INGOT.get());

        tag(AstralTags.Items.VOIDINIUM_ARMOR)
                .add(AstralItems.VOIDINIUM_HELMET.get())
                .add(AstralItems.VOIDINIUM_CHESTPLATE.get())
                .add(AstralItems.VOIDINIUM_LEGGINGS.get())
                .add(AstralItems.VOIDINIUM_BOOTS.get());

        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(AstralItems.VOIDINIUM_SWORD.get());
        tag(ItemTags.SWORDS)
                .add(AstralItems.VOIDINIUM_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(AstralItems.VOIDINIUM_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(AstralItems.VOIDINIUM_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(AstralItems.VOIDINIUM_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(AstralItems.VOIDINIUM_HOE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(AstralItems.VOIDINIUM_HELMET.get())
                .add(AstralItems.VOIDINIUM_CHESTPLATE.get())
                .add(AstralItems.VOIDINIUM_LEGGINGS.get())
                .add(AstralItems.VOIDINIUM_BOOTS.get());

        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(AstralItems.VOIDINIUM_HELMET.get())
                .add(AstralItems.VOIDINIUM_CHESTPLATE.get())
                .add(AstralItems.VOIDINIUM_LEGGINGS.get())
                .add(AstralItems.VOIDINIUM_BOOTS.get());



    }
}
