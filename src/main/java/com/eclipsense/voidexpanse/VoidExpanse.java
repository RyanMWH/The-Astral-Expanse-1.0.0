package com.eclipsense.voidexpanse;

import com.eclipsense.voidexpanse.entity.VoidEntities;
import com.eclipsense.voidexpanse.entity.client.enderwisp.EnderWispModel;
import com.eclipsense.voidexpanse.entity.client.enderwisp.EnderWispRenderer;
import com.eclipsense.voidexpanse.init.VoidBlocks;
import com.eclipsense.voidexpanse.init.VoidEffects;
import com.eclipsense.voidexpanse.init.VoidItems;
import com.eclipsense.voidexpanse.init.VoidPotions;
import net.minecraft.client.color.item.Potion;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(com.eclipsense.voidexpanse.VoidExpanse.MODID)
public class VoidExpanse {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "voidexpanse";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VOID_EXPANSE = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.voidexpanse")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> VoidItems.VOID_INFUSED_HEART.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(VoidItems.VOID_INFUSED_HEART.get());
                output.accept(VoidItems.VOID_FRAGMENT.get());
                output.accept(VoidItems.ENDER_DUST.get());
                output.accept(VoidItems.END_STONE_VOIDINIUM_ORE_ITEM.get());
                output.accept(VoidItems.VOIDINIUM_SHARD.get());
                output.accept(VoidItems.CONCENTRATED_VOIDINIUM.get());
                output.accept(VoidItems.VOIDINIUM_INGOT.get());
                output.accept(VoidItems.VOIDINIUM_BLOCK_ITEM.get());
                output.accept(VoidItems.VOIDINIUM_SWORD);
                output.accept(VoidItems.VOIDINIUM_PICKAXE);
                output.accept(VoidItems.VOIDINIUM_AXE);
                output.accept(VoidItems.VOIDINIUM_SHOVEL);
                output.accept(VoidItems.VOIDINIUM_HOE);
                output.accept(VoidItems.VOIDINIUM_HELMET);
                output.accept(VoidItems.VOIDINIUM_CHESTPLATE);
                output.accept(VoidItems.VOIDINIUM_LEGGINGS);
                output.accept(VoidItems.VOIDINIUM_BOOTS);

                output.accept(VoidItems.ENDER_WISP_SPAWN_EGG);





            }).build());


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public VoidExpanse(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (VoidExpanse) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        VoidItems.register(modEventBus);

        VoidBlocks.register(modEventBus);

        VoidEntities.register(modEventBus);

        VoidEffects.register(modEventBus);

        VoidPotions.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(VoidEntities.ENDER_WISP.get(), EnderWispRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            // Register the model layer
            event.registerLayerDefinition(EnderWispModel.LAYER_LOCATION, EnderWispModel::createBodyLayer);
        }
    }
}
