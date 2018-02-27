package com.rowlingsrealm.core.item;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

    public ItemStack build()
    {
        ItemStack itemStack = new ItemStack(getMaterial(), getAmount().intValue(), (short)getData().byteValue());
        ItemMeta itemMeta;
        if ((this.displayName != null) || (this.lore != null))
        {
            itemMeta = itemStack.getItemMeta();
            if (this.displayName != null) {
                itemMeta.setDisplayName(this.displayName);
            }
            if (this.lore != null) {
                itemMeta.setLore(this.lore);
            }
            itemStack.setItemMeta(itemMeta);
        }
        if (this.enchantments != null) {
            for (Enchantment ench : this.enchantments.keySet())
            {
                int level = ((Integer)this.enchantments.get(ench)).intValue();
                itemStack.addUnsafeEnchantment(ench, level);
            }
        }
        return itemStack;
    }
}
