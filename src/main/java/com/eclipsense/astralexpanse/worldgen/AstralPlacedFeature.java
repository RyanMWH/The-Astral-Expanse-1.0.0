package com.eclipsense.astralexpanse.worldgen;

import com.eclipsense.astralexpanse.AstralExpanse;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AstralPlacedFeature {

    public static final ResourceKey<PlacedFeature> END_VOIDINIUM_ORE_PLACED_KEY = registerKey("end_voidinium_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context){
        var configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, END_VOIDINIUM_ORE_PLACED_KEY, configuredFeature.getOrThrow(AstralConfiguredFeature.END_VOIDINIUM_ORE_KEY),
                rareEndOrePlacement());

    }

    private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count),
                heightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance),
                heightRange);
    }

    private static List<PlacementModifier> rareEndOrePlacement() {
        return List.of(
                CountPlacement.of(25),
                HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.TOP),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.AIR)),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(new Vec3i(0, 1, 0), Blocks.END_STONE))
        );
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(AstralExpanse.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context,
                                 ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
