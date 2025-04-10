package com.eclipsense.astralexpanse.datagen.loot;

import com.eclipsense.astralexpanse.init.AstralEntities;
import com.eclipsense.astralexpanse.init.AstralItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.stream.Stream;

public class MobLootTableGen extends EntityLootSubProvider {
    public MobLootTableGen(HolderLookup.Provider registries) {
        super(FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    public void generate() {
        this.add(AstralEntities.ENDER_WISP.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(AstralItems.ENDER_DUST.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))));
        this.add(AstralEntities.VOID_PROWLER.get(), LootTable.lootTable());
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return AstralEntities.ENTITY_TYPES.getEntries().stream()
                .map(e -> (EntityType<?>) e.value());
    }
}

