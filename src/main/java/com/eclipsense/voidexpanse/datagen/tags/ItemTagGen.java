package com.eclipsense.voidexpanse.datagen.tags;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.item.ModItems;
import com.eclipsense.voidexpanse.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

// Don't think I have a need for this one
public class ItemTagGen extends ItemTagsProvider {


    public ItemTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, VoidExpanse.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.VOIDINIUM_TOOL_MATERIALS)
                .add(ModItems.VOIDINIUM_INGOT.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.VOIDINIUM_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.VOIDINIUM_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.VOIDINIUM_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.VOIDINIUM_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.VOIDINIUM_HOE.get());




    }
}
