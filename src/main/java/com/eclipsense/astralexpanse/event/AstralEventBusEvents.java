package com.eclipsense.astralexpanse.event;

import com.eclipsense.astralexpanse.AstralExpanse;
import com.eclipsense.astralexpanse.init.AstralEntities;
import com.eclipsense.astralexpanse.entity.client.enderwisp.EnderWispModel;
import com.eclipsense.astralexpanse.entity.custom.EnderWispEntity;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = AstralExpanse.MODID, bus = EventBusSubscriber.Bus.MOD)
public class AstralEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EnderWispModel.LAYER_LOCATION, EnderWispModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttribute(EntityAttributeCreationEvent event) {
        event.put(AstralEntities.ENDER_WISP.get(), EnderWispEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(AstralEntities.ENDER_WISP.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
