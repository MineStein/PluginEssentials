package me.tylergrissom.pluginessentials.menu;

import lombok.Getter;
import me.tylergrissom.pluginessentials.SpigotPlugin;
import me.tylergrissom.pluginessentials.sound.QuickSound;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;

import java.util.Collection;

/**
 * Copyright Tyler Grissom 2018
 */
public abstract class Menu implements Listener {

    @Getter private SpigotPlugin plugin;

    public Menu(SpigotPlugin plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, getPlugin());
    }

    public abstract void onClick(final InventoryEvent event);
    public abstract Inventory getInventory();

    @EventHandler(priority = EventPriority.LOWEST)
    public void handler(final InventoryEvent event) {
        if ((event instanceof Cancellable) && ((Cancellable) event).isCancelled()) return;

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

    /**
     * Gets the optimal inventory size based on a collection.
     *
     * @param collection The collection to size.
     * @return The optimal amount of slots.
     */
    public int resize(Collection<?> collection) {
        int resize = 9;
        int size = collection.size();

        if (size > 9) resize = 18;
        if (size > 18) resize = 27;
        if (size > 27) resize = 36;
        if (size > 36) resize = 45;
        if (size > 45) resize = 54;

        return resize;
    }
}
