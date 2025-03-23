package com.eclipsense.voidexpanse.datagen.data;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.worldgen.VoidBiomeModifier;
import com.eclipsense.voidexpanse.worldgen.VoidConfiguredFeature;
import com.eclipsense.voidexpanse.worldgen.VoidPlacedFeature;
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
            .add(Registries.CONFIGURED_FEATURE, VoidConfiguredFeature::bootstrap)
            .add(Registries.PLACED_FEATURE, VoidPlacedFeature::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, VoidBiomeModifier::bootstrap);


    public DataPackGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(VoidExpanse.MODID));
    }
}
