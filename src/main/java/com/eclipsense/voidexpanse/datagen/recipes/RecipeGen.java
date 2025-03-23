package com.eclipsense.voidexpanse.datagen.recipes;


import com.eclipsense.voidexpanse.block.ModBlocks;
import com.eclipsense.voidexpanse.item.ModItems;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;


public class RecipeGen extends RecipeProvider{

    public static final ImmutableList<ItemLike> VOIDINIUM_SMELTABLES = ImmutableList.of(ModItems.CONCENTRATED_VOIDINIUM.get());


    public RecipeGen(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ModBlocks.VOIDINIUM_BLOCK)
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium", has(ModItems.VOIDINIUM_INGOT))
                .save(output);
        twoByTwoPacker(RecipeCategory.MISC, ModItems.CONCENTRATED_VOIDINIUM, ModItems.VOIDINIUM_SHARD);
        oreBlasting(VOIDINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDINIUM_INGOT.get(), 1.0f, 200, "voidinium_ingot");

    }

    // The runner to add to the data generator
    public static class Runner extends RecipeProvider.Runner {
        // Get the parameters from the `GatherDataEvent`s.
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new RecipeGen(provider, recipeOutput);
        }


        @Override
        public String getName() {
            return "Test";
        }
    }
}
