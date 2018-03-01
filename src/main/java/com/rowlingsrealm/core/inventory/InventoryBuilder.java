package com.rowlingsrealm.core.inventory;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Copyright Tyler Grissom 2018
 */
public class InventoryBuilder {

    public static Inventory of(InventoryHolder holder, InventoryRows rows, String title) {
        return Bukkit.createInventory(holder, rows.getSlotCount(), title);
    }

    public static Inventory of(InventoryRows rows, String title) {
        return of(null, rows, title);
    }

    @Getter @Setter
    private InventoryHolder holder;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int size;
}
