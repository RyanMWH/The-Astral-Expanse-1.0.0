package com.eclipsense.voidexpanse.datagen.loot;

import com.eclipsense.voidexpanse.init.ModBlocks;
import com.eclipsense.voidexpanse.init.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;


import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class LootTableGen extends BlockLootSubProvider {
    public LootTableGen(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.VOIDINIUM_BLOCK.get());
        add(ModBlocks.END_STONE_VOIDINIUM_ORE.get(), createMultipleOreDropsWithRareDrop(
                ModBlocks.END_STONE_VOIDINIUM_ORE.get(),
                ModItems.VOIDINIUM_SHARD.get(),
                ModItems.CONCENTRATED_VOIDINIUM.get(),
                1.0f,
                3.0f,
                0.10f));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pblock, Item item, float min, float max){
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pblock,
                this.applyExplosionDecay(pblock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected LootTable.Builder createMultipleOreDropsWithRareDrop(Block pblock, Item commonDrop, Item rareDrop, float min, float max, float rareDropChance) {
        try {
            HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

            // Create the base loot table with the common drop
            LootTable.Builder baseTable = this.createSilkTouchDispatchTable(pblock,
                    this.applyExplosionDecay(pblock, LootItem.lootTableItem(commonDrop)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                            .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));

            // Add an additional pool for the rare drop
            return baseTable.withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .when(LootItemRandomChanceCondition.randomChance(rareDropChance))
                    .add(this.applyExplosionDecay(pblock, LootItem.lootTableItem(rareDrop))));
        } catch (Exception e) {
            e.printStackTrace();
            return LootTable.lootTable();
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
