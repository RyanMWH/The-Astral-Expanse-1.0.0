package com.eclipsense.voidexpanse.worldgen;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class VoidConfiguredFeature {

    public static final ResourceKey<ConfiguredFeature<?, ?>> END_VOIDINIUM_ORE_KEY = registerKey("end_stone_voidinium_ore");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        // Made this in case we want to add more ores to the end.
        List<OreConfiguration.TargetBlockState> endVoidiniumOres = List.of(
                OreConfiguration.target(endStoneReplaceables, ModBlocks.END_STONE_VOIDINIUM_ORE.get().defaultBlockState())
        );

        register(context, END_VOIDINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                ModBlocks.END_STONE_VOIDINIUM_ORE.get().defaultBlockState(),
                10));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(VoidExpanse.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
