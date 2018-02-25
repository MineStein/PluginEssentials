package com.rowlingsrealm.core.item;

import com.google.common.collect.ComparisonChain;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.rowlingsrealm.core.color.ColorUtility.strip;

/**
 * Copyright Tyler Grissom 2018
 */
public class ItemUtility {

    /**
     * Checks if the item's Material and the provided Material are a match.
     *
     * @param item The item to gather the Material from.
     * @param material The Material to compare against.
     * @return Whether or not there was a match.
     */
    public static boolean isSimilar(ItemStack item, Material material) {
        return ComparisonChain
                .start()
                .compare(item.getType(), material)
                .result() == 0;
    }

    /**
     * Checks if the item's display name and the provided String are a match.
     *
     * @param item The item to gather the display name from.
     * @param name The display name to compare against.
     * @return Whether or not there was a match.
     */
    public static boolean isSimilar(ItemStack item, String name) {
        String displayName = strip(item.getItemMeta().getDisplayName()).toLowerCase();

        name = strip(name).toLowerCase();

        return ComparisonChain
                .start()
                .compare(displayName, name)
                .result() == 0;
    }

    /**
     * Checks if both the item's Material and display name are a match with their corresponding provided Material and String.
     *
     * @param item The item to gather the Material and display name from.
     * @param material The Material to compare against.
     * @param name The display to compare against.
     * @return Whether or not there was a match.
     */
    public static boolean isSimilar(ItemStack item, Material material, String name) {
        return isSimilar(item, material) && isSimilar(item, name);
    }
}
