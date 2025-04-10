package com.eclipsense.astralexpanse.event;

import com.eclipsense.astralexpanse.AstralExpanse;
import com.eclipsense.astralexpanse.init.AstralItems;
import com.eclipsense.astralexpanse.init.AstralPotions;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = AstralExpanse.MODID, bus = EventBusSubscriber.Bus.GAME)
public class AstralEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, AstralItems.ENDER_DUST.get(), AstralPotions.VOID_HUNGER_POTION);
    }

}
