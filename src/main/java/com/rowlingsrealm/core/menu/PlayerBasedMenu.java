package com.rowlingsrealm.core.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public abstract class PlayerBasedMenu extends Menu {

    @Getter private Player player;

    public abstract Inventory getInventory(Player player);

    public Inventory getInventory() {
        return getInventory(player);
    }
}
