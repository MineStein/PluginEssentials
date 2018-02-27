package com.rowlingsrealm.core.item;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ItemBuilder
{
    @Getter private Material material = null;
    @Getter private Integer amount = Integer.valueOf(1);
    @Getter private Byte data = Byte.valueOf((byte)0);
    @Getter private String displayName = null;
    @Getter private List<String> lore = null;
    @Getter private Map<Enchantment, Integer> enchantments = null;
    @Getter private ItemAction action = null;
    @Getter private List<ItemFlag> flags = new ArrayList<>();

    public ItemBuilder() {}

    public ItemBuilder type(Material material)
    {
        this.material = material;

        return this;
    }

    public ItemBuilder amount(Integer amount)
    {
        this.amount = amount;

        return this;
    }

    public ItemBuilder data(Byte data)
    {
        this.data = data;

        return this;
    }

    public ItemBuilder name(String displayName)
    {
        this.displayName = displayName;

        return this;
    }

    public ItemBuilder lore(String... strings)
    {
        this.lore = Arrays.asList(strings);

        return this;
    }

    public ItemBuilder enchant(Enchantment enchantment, Integer level)
    {
        this.enchantments.put(enchantment, level);

        return this;
    }

    public ItemBuilder enchantments(Map<Enchantment, Integer> enchantments)
    {
        this.enchantments = enchantments;

        return this;
    }

    @Deprecated
    public ItemBuilder withAction(ItemAction action) {
        throw new UnsupportedOperationException("Refrain from using ItemBuilder#withAction for the time being as actions as not persistent");
//
//        action.setCorrespondingItem(this);
//
//        this.action = action;
//
//        return this;
    }

    public ItemBuilder withFlags(ItemFlag... flags) {
        this.flags.addAll(Arrays.asList(flags));

        return this;
    }

    public ItemBuilder withoutFlags(ItemFlag... flags) {
        this.flags.removeAll(Arrays.asList(flags));

        return this;
    }

    public ItemStack build()
    {
        ItemStack item = new ItemStack(getMaterial(), getAmount(), (short) getData()); {
            ItemMeta meta;

            if (getDisplayName() != null || getLore() != null || getFlags() != null) {
                meta = item.getItemMeta();

                if (getDisplayName() != null) meta.setDisplayName(getDisplayName());
                if (getLore() != null) meta.setLore(getLore());
                if (getFlags() != null) {
                    meta.getItemFlags().clear();

                    getFlags().forEach(meta::addItemFlags);
                }

                item.setItemMeta(meta);
            }

            if (getEnchantments() != null) {
                getEnchantments().forEach((enchantment, integer) -> {
                    int level = getEnchantments().get(enchantment);

                    item.addUnsafeEnchantment(enchantment, level);
                });
            }
        }

        return item;
    }
}
