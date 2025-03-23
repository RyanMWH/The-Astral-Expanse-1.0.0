package com.eclipsense.voidexpanse.datagen.tags;

import com.eclipsense.voidexpanse.VoidExpanse;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

// Not sure if I really need this because I only made one tag so far
// The tag I made was under the neoforge directory so not sure how to change
// my directory
public class BlockTagGen extends BlockTagsProvider {
    public BlockTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, VoidExpanse.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
