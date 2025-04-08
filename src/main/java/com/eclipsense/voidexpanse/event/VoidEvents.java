package com.eclipsense.voidexpanse.event;

import com.eclipsense.voidexpanse.VoidExpanse;
import com.eclipsense.voidexpanse.init.VoidItems;
import com.eclipsense.voidexpanse.init.VoidPotions;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = VoidExpanse.MODID, bus = EventBusSubscriber.Bus.GAME)
public class VoidEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, VoidItems.ENDER_DUST.get(), VoidPotions.VOID_HUNGER_POTION);
    }

}
