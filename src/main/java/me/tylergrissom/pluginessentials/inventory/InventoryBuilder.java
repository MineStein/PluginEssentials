package me.tylergrissom.pluginessentials.inventory;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.List;

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

    @Getter
    private InventoryHolder holder;

    @Getter
    private String name;

    @Getter
    private InventoryRows rows;

    @Getter
    private ItemStack[] contents;

    public InventoryBuilder holder(InventoryHolder holder) {
        this.holder = holder;

        return this;
    }

    public InventoryBuilder name(String name) {
        this.name = name;

        return this;
    }

    public InventoryBuilder rows(InventoryRows rows) {
        this.rows = rows;

        return this;
    }

    public InventoryBuilder withContents(ItemStack... itemStacks) {
        this.contents = itemStacks;

        return this;
    }

    public InventoryBuilder withContents(List<ItemStack> itemStacks) {
        this.contents = (ItemStack[]) itemStacks.toArray();

        return this;
    }

    public InventoryBuilder setOption(int slot, ItemStack itemStack) {
        this.contents[slot] = itemStack;

        return this;
    }

    public Inventory build() {
        Inventory inv = Bukkit.createInventory(getHolder(), getRows().getSlotCount(), getName()); {
            inv.setContents(getContents());
        }

        return Bukkit.createInventory(getHolder(), getRows().getSlotCount(), getName());
    }
}
