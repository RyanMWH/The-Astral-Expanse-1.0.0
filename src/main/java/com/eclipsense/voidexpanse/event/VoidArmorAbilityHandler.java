package com.eclipsense.voidexpanse.event;

import com.eclipsense.voidexpanse.armor.VoidSpecialArmor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = "voidexpanse", value = Dist.CLIENT)
public class VoidArmorAbilityHandler {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide()) return;

        // Check if player is sneaking and wearing full Voidinium armor
        if (player.isShiftKeyDown() && VoidSpecialArmor.hasVoidiniumArmor(player)) {
            Vec3 coords = getLookingAtCoordinates(player, 25);
            if (coords != null) {
                player.teleportTo(coords.x, coords.y + 2, coords.z);
                // Optional: add cooldown, sound, or particle effect
                event.setCanceled(true); // Prevent default item usage
            }
        }
    }

    private static Vec3 getLookingAtCoordinates(Player player, double range) {
        Vec3 eyePosition = player.getEyePosition(1.0F);
        Vec3 viewVector = player.getLookAngle();
        Vec3 endVec = eyePosition.add(viewVector.scale(range));

        ClipContext context = new ClipContext(
                eyePosition,
                endVec,
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.NONE,
                player
        );

        HitResult hitResult = player.level().clip(context);

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            return Vec3.atCenterOf(((BlockHitResult)hitResult).getBlockPos());
        }
        return null;
    }
}
