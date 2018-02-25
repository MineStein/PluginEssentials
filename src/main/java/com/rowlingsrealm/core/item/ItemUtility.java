package com.rowlingsrealm.core.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.rowlingsrealm.core.color.ColorUtility.strip;

/**
 * Copyright Tyler Grissom 2018
 */
public class ItemUtility {

    public static boolean isSimilar(ItemStack item, Material material) {
        return item.getType().equals(material);
    }

    public static boolean isSimilar(ItemStack item, String name) {
        return strip(item.getItemMeta().getDisplayName()).equalsIgnoreCase(strip(name));
    }

    public static boolean isSimilar(ItemStack item, Material material, String name) {
        return isSimilar(item, material) && isSimilar(item, name);
    }
}
