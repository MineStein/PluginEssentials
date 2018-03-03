package com.rowlingsrealm.core.item;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
public class SkullItemBuilder extends ItemBuilder {

    public static ItemStack of(String owner) {
        return new SkullItemBuilder()
                .owner(owner)
                .build();
    }

    @Getter private String owner;

    public SkullItemBuilder() {
        type(Material.SKULL_ITEM);
        data((byte) SkullType.PLAYER.ordinal());
    }

    public SkullItemBuilder owner(String owner) {
        this.owner = owner;

        return this;
    }

    @Override
    public ItemStack build() {
        ItemStack i = super.build(); {
            SkullMeta meta = (SkullMeta) i.getItemMeta();

            meta.setOwningPlayer(Bukkit.getOfflinePlayer(getOwner()));

            i.setItemMeta(meta);
        }

        return i;
    }
}
