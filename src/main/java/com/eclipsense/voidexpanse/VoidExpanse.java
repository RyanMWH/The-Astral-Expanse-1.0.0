package com.eclipsense.voidexpanse;

import com.eclipsense.voidexpanse.entity.VoidEntities;
import com.eclipsense.voidexpanse.entity.client.EnderWisp.EnderWispRenderer;
import com.eclipsense.voidexpanse.init.ModBlocks;
import com.eclipsense.voidexpanse.init.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;


import net.minecraft.world.item.CreativeModeTabs;

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
            .icon(() -> ModItems.VOID_INFUSED_HEART.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.VOID_INFUSED_HEART.get());
                output.accept(ModItems.VOID_FRAGMENT.get());
                output.accept(ModItems.END_STONE_VOIDINIUM_ORE_ITEM.get());
                output.accept(ModItems.VOIDINIUM_SHARD.get());
                output.accept(ModItems.CONCENTRATED_VOIDINIUM.get());
                output.accept(ModItems.VOIDINIUM_INGOT.get());
                output.accept(ModItems.VOIDINIUM_BLOCK_ITEM.get());
                output.accept(ModItems.VOIDINIUM_SWORD);
                output.accept(ModItems.VOIDINIUM_PICKAXE);
                output.accept(ModItems.VOIDINIUM_AXE);
                output.accept(ModItems.VOIDINIUM_SHOVEL);
                output.accept(ModItems.VOIDINIUM_HOE);
                output.accept(ModItems.VOIDINIUM_HELMET);
                output.accept(ModItems.VOIDINIUM_CHESTPLATE);
                output.accept(ModItems.VOIDINIUM_LEGGINGS);
                output.accept(ModItems.VOIDINIUM_BOOTS);
                output.accept(ModItems.ENDER_WISP_SPAWN_EGG);


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

        ModItems.ITEMS.register(modEventBus);

        ModBlocks.BLOCKS.register(modEventBus);

        VoidEntities.ENTITY_TYPES.register(modEventBus);
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
            EntityRenderers.register(VoidEntities.EnderWisp.get(), EnderWispRenderer::new);
        }
    }
}
