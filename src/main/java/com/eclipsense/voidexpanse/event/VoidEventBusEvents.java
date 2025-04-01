package com.eclipsense.voidexpanse.event;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.entity.VoidEntities;
import com.eclipsense.voidexpanse.entity.client.EnderWisp.EnderWispModel;
import com.eclipsense.voidexpanse.entity.custom.EnderWispEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = VoidExpanse.MODID, bus = EventBusSubscriber.Bus.MOD)
public class VoidEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(EnderWispModel.LAYER_LOCATION, EnderWispModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttribute(EntityAttributeCreationEvent event){
        event.put(VoidEntities.ENDER_WISP.get(), EnderWispEntity.createAttributes().build());
    }

}
