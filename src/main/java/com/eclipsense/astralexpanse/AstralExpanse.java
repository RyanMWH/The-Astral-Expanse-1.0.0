package com.eclipsense.astralexpanse;

import com.eclipsense.astralexpanse.init.AstralEntities;
import com.eclipsense.astralexpanse.entity.client.enderwisp.EnderWispModel;
import com.eclipsense.astralexpanse.entity.client.enderwisp.EnderWispRenderer;
import com.eclipsense.astralexpanse.init.AstralItems;
import com.eclipsense.astralexpanse.init.AstralBlocks;
import com.eclipsense.astralexpanse.init.AstralEffects;
import com.eclipsense.astralexpanse.init.AstralPotions;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
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
@Mod(AstralExpanse.MODID)
public class AstralExpanse {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "astralexpanse";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ASTRAL_EXPANSE = CREATIVE_MODE_TABS.register("astral_expanse", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.astralexpanse")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> AstralItems.VOID_INFUSED_HEART.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(AstralItems.VOID_INFUSED_HEART.get());
                output.accept(AstralItems.VOID_FRAGMENT.get());
                output.accept(AstralItems.ENDER_DUST.get());
                output.accept(AstralItems.END_STONE_VOIDINIUM_ORE_ITEM.get());
                output.accept(AstralItems.VOIDINIUM_SHARD.get());
                output.accept(AstralItems.CONCENTRATED_VOIDINIUM.get());
                output.accept(AstralItems.VOIDINIUM_INGOT.get());
                output.accept(AstralItems.VOIDINIUM_BLOCK_ITEM.get());
                output.accept(AstralItems.VOIDINIUM_SWORD);
                output.accept(AstralItems.VOIDINIUM_PICKAXE);
                output.accept(AstralItems.VOIDINIUM_AXE);
                output.accept(AstralItems.VOIDINIUM_SHOVEL);
                output.accept(AstralItems.VOIDINIUM_HOE);
                output.accept(AstralItems.VOIDINIUM_HELMET);
                output.accept(AstralItems.VOIDINIUM_CHESTPLATE);
                output.accept(AstralItems.VOIDINIUM_LEGGINGS);
                output.accept(AstralItems.VOIDINIUM_BOOTS);

                output.accept(AstralItems.ENDER_WISP_SPAWN_EGG);





            }).build());


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public AstralExpanse(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (astralexpanse) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        AstralItems.register(modEventBus);

        AstralBlocks.register(modEventBus);

        AstralEntities.register(modEventBus);

        AstralEffects.register(modEventBus);

        AstralPotions.register(modEventBus);

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
            EntityRenderers.register(AstralEntities.ENDER_WISP.get(), EnderWispRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            // Register the model layer
            event.registerLayerDefinition(EnderWispModel.LAYER_LOCATION, EnderWispModel::createBodyLayer);
        }
    }
}
