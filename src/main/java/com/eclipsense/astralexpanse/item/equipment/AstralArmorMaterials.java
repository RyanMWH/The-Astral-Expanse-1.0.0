package com.eclipsense.astralexpanse.item.equipment;

import com.eclipsense.astralexpanse.init.AstralTags;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.EnumMap;

public class AstralArmorMaterials {
    public static final ArmorMaterial VOIDINIUM_ARMOR_MATERIAL = new ArmorMaterial(
            40,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 11);
            }),
            16,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            3.5F,
            0,
            AstralTags.Items.VOIDINIUM_TOOL_MATERIALS,
            ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath("astralexpanse", "voidinium"))
    );
}

