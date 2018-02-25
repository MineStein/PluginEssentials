package com.rowlingsrealm.core.menu;

import com.rowlingsrealm.core.CorePlugin;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Copyright Tyler Grissom 2018
 */
public abstract class PlayerBasedMenu extends Menu {

    @Getter private Player player;

    public PlayerBasedMenu(CorePlugin plugin) {
        super(plugin);
    }

    public abstract Inventory getInventory(Player player);

    public Inventory getInventory() {
        return getInventory(player);
    }
}
