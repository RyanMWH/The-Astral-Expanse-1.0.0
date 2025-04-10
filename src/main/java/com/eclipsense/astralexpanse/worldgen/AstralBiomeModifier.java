package com.eclipsense.astralexpanse.worldgen;

import com.eclipsense.astralexpanse.AstralExpanse;
import com.eclipsense.astralexpanse.init.AstralEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class AstralBiomeModifier {

    public static final ResourceKey<BiomeModifier> ADD_VOIDINIUM_ORE = registerkey("add_voidinium_ore");
    public static final ResourceKey<BiomeModifier> SPAWN_ENDER_WISP = registerkey("spawn_ender_wisp");



    public static void bootstrap(BootstrapContext<BiomeModifier> context){
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_VOIDINIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeature.getOrThrow(AstralPlacedFeature.END_VOIDINIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(SPAWN_ENDER_WISP, new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                List.of(new MobSpawnSettings.SpawnerData(AstralEntities.ENDER_WISP.get(), 12, 4, 10))));
    }

    private  static ResourceKey<BiomeModifier> registerkey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(AstralExpanse.MODID, name));
    }
}
