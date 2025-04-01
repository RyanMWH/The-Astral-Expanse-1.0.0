package com.eclipsense.voidexpanse.datagen.recipes;


import com.eclipsense.voidexpanse.init.ModBlocks;
import com.eclipsense.voidexpanse.init.ModItems;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;


public class RecipeGen extends RecipeProvider{

    public static final ImmutableList<ItemLike> VOIDINIUM_SMELTABLES = ImmutableList.of(ModItems.CONCENTRATED_VOIDINIUM.get());


    public RecipeGen(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        // Voidinium Stuff
        threeByThreePacker(RecipeCategory.MISC, ModBlocks.VOIDINIUM_BLOCK, ModItems.VOIDINIUM_INGOT);
        threeByThreePacker(RecipeCategory.MISC, ModItems.CONCENTRATED_VOIDINIUM, ModItems.VOIDINIUM_SHARD);
        oreBlasting(VOIDINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDINIUM_INGOT.get(), 1.0f, 200, "voidinium_ingot");

        // Voidinium Tools
        shaped(RecipeCategory.TOOLS, ModItems.VOIDINIUM_PICKAXE)
                .pattern("VVV")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK).define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.VOIDINIUM_SHOVEL)
                .pattern("V")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK).define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.VOIDINIUM_AXE)
                .pattern("VV")
                .pattern("VS")
                .pattern(" S")
                .define('S', Items.STICK).define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.VOIDINIUM_HOE)
                .pattern("VV")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK).define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.VOIDINIUM_SWORD)
                .pattern("V")
                .pattern("V")
                .pattern("S")
                .define('S', Items.STICK).define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        // Voidinium Armor
        shaped(RecipeCategory.TOOLS, ModItems.VOIDINIUM_HELMET)
                .pattern("VVV")
                .pattern("V V")
                .define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.VOIDINIUM_CHESTPLATE)
                .pattern("V V")
                .pattern("VVV")
                .pattern("VVV")
                .define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.VOIDINIUM_LEGGINGS)
                .pattern("VVV")
                .pattern("V V")
                .pattern("V V")
                .define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.VOIDINIUM_BOOTS)
                .pattern("V V")
                .pattern("V V")
                .define('V', ModItems.VOIDINIUM_INGOT)
                .unlockedBy("has_voidinium_ingot", has(ModItems.VOIDINIUM_INGOT))
                .save(output);


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
