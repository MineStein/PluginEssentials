package com.rowlingsrealm.core.menu;

import com.rowlingsrealm.core.sound.QuickSound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Copyright Tyler Grissom 2018
 */
public abstract class Menu {

    public abstract Inventory getInventory();

    /**
     * Opens the menu for a set of players with a click.
     *
     * @param players The players to open the inventory.
     */
    public void open(Player... players) {
        for (Player player :
                players) {
            player.openInventory(getInventory());

            QuickSound.click(player);
        }
    }
}
