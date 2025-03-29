package com.eclipsense.voidexpanse.util;

import com.eclipsense.voidexpanse.VoidExpanse;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {


        public static final TagKey<Block> NEEDS_VOIDINIUM_TOOL = createTag("needs_voidinium_tool");
        public static final TagKey<Block> INCORRECT_FOR_VOIDINIUM_TOOL = createTag("incorrect_for_voidinium_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(VoidExpanse.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> VOIDINIUM_TOOL_MATERIALS = createTag("voidinium_tool_materials");
        public static final TagKey<Item> VOIDINIUM_ARMOR = createTag("voidinium_armor");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(VoidExpanse.MODID, name));
        }
    }
}