package com.eclipsense.astralexpanse.datagen.data;

import com.eclipsense.astralexpanse.AstralExpanse;
import com.eclipsense.astralexpanse.worldgen.AstralBiomeModifier;
import com.eclipsense.astralexpanse.worldgen.AstralConfiguredFeature;
import com.eclipsense.astralexpanse.worldgen.AstralPlacedFeature;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;



public class DataPackGen extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AstralConfiguredFeature::bootstrap)
            .add(Registries.PLACED_FEATURE, AstralPlacedFeature::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, AstralBiomeModifier::bootstrap);


    public DataPackGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AstralExpanse.MODID));
    }
}
