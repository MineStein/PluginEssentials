package com.rowlingsrealm.core.example.menu;

import com.rowlingsrealm.core.example.ExamplePlugin;
import com.rowlingsrealm.core.inventory.InventoryBuilder;
import com.rowlingsrealm.core.item.ItemBuilder;
import com.rowlingsrealm.core.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Copyright Tyler Grissom 2018
 */
public class ExampleMenu extends Menu {

    public ExampleMenu(ExamplePlugin plugin) {
        super(plugin);
    }

    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);

        Player p = ((Player) event.getWhoClicked());

        p.sendMessage("§dHi!");
    }

    public Inventory getInventory() {
        Inventory inv = InventoryBuilder.of(27, "Example Menu");

        ItemStack i = new ItemBuilder()
                .type(Material.DIAMOND_SWORD)
                .name("§5A beautiful diamond sword")
                .build();

        inv.addItem(i);

        return inv;
    }
}
