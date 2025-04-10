package com.eclipsense.astralexpanse.armor;

import com.eclipsense.astralexpanse.init.AstralTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;

import java.util.Random;

public class VoidiniumSpecialArmor extends ArmorItem {
    public VoidiniumSpecialArmor(ArmorMaterial material, ArmorType armorType, Properties properties) {
        super(material, armorType, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (hasVoidiniumArmor((Player) entity)){
            Random random = new Random();
            double randx = random.nextDouble(2.5) - 2.5;
            double randy = random.nextDouble(2.5) - 2.5;
            double randz = random.nextDouble(2.5) - 2.5;


            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.PORTAL,
                        (double) entity.getX() + randx + 1.25,
                        (double) entity.getY() + randy + 1.5,
                        (double) entity.getZ() + randz + 1.25,
                        0, 0, 0);
            }
        }
    }

    public static boolean hasVoidiniumArmor(Player player){
        for (EquipmentSlot slot : new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET})
        {
            ItemStack equippedItem = player.getItemBySlot(slot);
            if (equippedItem.isEmpty() || !equippedItem.is(AstralTags.Items.VOIDINIUM_ARMOR)){
                return false;
            }

        }
        return true;
    }
}
