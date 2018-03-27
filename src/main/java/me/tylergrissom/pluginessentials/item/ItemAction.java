package me.tylergrissom.pluginessentials.item;

import lombok.Getter;
import lombok.Setter;
import me.tylergrissom.pluginessentials.SpigotPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Copyright Tyler Grissom 2018
 */
@Deprecated
public abstract class ItemAction implements Listener {

    @Getter
    private SpigotPlugin plugin;

    @Getter @Setter
    private ItemBuilder correspondingItem;

    public ItemAction(SpigotPlugin plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, getPlugin());
    }

    public ItemAction(SpigotPlugin plugin, ItemBuilder correspondingItem) {
        this.plugin = plugin;
        this.correspondingItem = correspondingItem;

        Bukkit.getPluginManager().registerEvents(this, getPlugin());
    }

    @EventHandler
    public void handler(final PlayerInteractEvent event) {
        ItemStack builtItem = correspondingItem.build();
        ItemStack currentItem = event.getItem();

        if (!ItemUtility.isSimilar(builtItem, currentItem.getType(), currentItem.getItemMeta().getDisplayName())) return;

        onInteract(event);
    }

    public abstract void onInteract(final PlayerInteractEvent event);
}
