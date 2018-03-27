package me.tylergrissom.pluginessentials.menu;

import lombok.Getter;
import me.tylergrissom.pluginessentials.SpigotPlugin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Copyright Tyler Grissom 2018
 */
public abstract class PlayerBasedMenu extends Menu {

    @Getter private Player player;

    public PlayerBasedMenu(SpigotPlugin plugin) {
        super(plugin);
    }

    public abstract Inventory getInventory(Player player);

    public Inventory getInventory() {
        return getInventory(player);
    }
}
