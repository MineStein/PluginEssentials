package com.rowlingsrealm.core.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Copyright Tyler Grissom 2018
 */
public class InventoryBuilder {

    public static Inventory of(InventoryHolder holder, int size, String title) {
        return Bukkit.createInventory(holder, size, title);
    }

    public static Inventory of(int size, String title) {
        return of(null, size, title);
    }
}
