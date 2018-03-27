package me.tylergrissom.pluginessentials.menu;

import lombok.Getter;
import lombok.Setter;
import me.tylergrissom.pluginessentials.SpigotPlugin;
import me.tylergrissom.pluginessentials.inventory.InventoryBuilder;
import me.tylergrissom.pluginessentials.inventory.InventoryRows;
import me.tylergrissom.pluginessentials.item.ItemBuilder;
import me.tylergrissom.pluginessentials.item.ItemUtility;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
public abstract class ConfirmationMenu extends Menu {

    @Getter @Setter
    private String menuName;

    @Getter @Setter
    private ItemStack acceptedItemStack, deniedItemStack, middleItemStack;

    public enum Result {

        ACCEPTED,

        DENIED
    }

    public ConfirmationMenu(SpigotPlugin plugin) {
        super(plugin);

        this.acceptedItemStack = new ItemBuilder()
                .type(Material.STAINED_GLASS_PANE)
                .data((byte) 13)
                .name("§a§lYes, I am sure")
                .lore("", "§6Click §7to confirm")
                .build();

        this.deniedItemStack = new ItemBuilder()
                .type(Material.STAINED_GLASS_PANE)
                .data((byte) 14)
                .name("§a§lNo, I have changed my mind")
                .lore("", "§6Click §7to cancel")
                .build();

        this.acceptedItemStack = new ItemBuilder()
                .type(Material.STAINED_GLASS_PANE)
                .name("")
                .build();
    }

    public abstract void onResolve(Result result, InventoryClickEvent event);

    @Override
    public void onClick(InventoryEvent event) {
        if (!(event instanceof InventoryClickEvent)) return;

        InventoryClickEvent e = ((InventoryClickEvent) event);

        ItemStack i = e.getCurrentItem();

        Result result;

        if (ItemUtility.isSimilar(i, getAcceptedItemStack().getType(), getAcceptedItemStack().getItemMeta().getDisplayName())) result = Result.ACCEPTED;
        else result = Result.DENIED;

        onResolve(result, e);
    }

    @Override
    public Inventory getInventory() {
        Inventory inv = InventoryBuilder.of(InventoryRows.ONE_ROW, getMenuName());

        for (int i = 0; i < 4; i++) {
            inv.setItem(i, getAcceptedItemStack());
        }

        inv.setItem(5, getMiddleItemStack());

        for (int i = 5; i < 8; i++) {
            inv.setItem(i, getDeniedItemStack());
        }

        return inv;
    }
}
