package com.rowlingsrealm.core.menu;

import com.rowlingsrealm.core.CorePlugin;
import com.rowlingsrealm.core.sound.QuickSound;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Copyright Tyler Grissom 2018
 */
public abstract class Menu implements Listener {

    @Getter private CorePlugin plugin;

    public Menu(CorePlugin plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, getPlugin());
    }

    public abstract void onClick(final InventoryClickEvent event);
    public abstract Inventory getInventory();

    @EventHandler(priority = EventPriority.LOW)
    public void handler(final InventoryClickEvent event) {
        if (event.isCancelled()) return;
        if (event.getInventory().getName().equals(getInventory().getName())) onClick(event);
    }

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
