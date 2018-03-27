package me.tylergrissom.pluginessentials.item;

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

public class ItemBuilder {

    @Getter private Material material;
    @Getter private int amount;
    @Getter private byte data;
    @Getter private short durability;
    @Getter private String displayName;
    @Getter private List<String> lore;
    @Getter private Map<Enchantment, Integer> enchantments;
    @Getter private ItemAction action;
    @Getter private List<ItemFlag> flags;

    public ItemBuilder() {
        this.material = null;
        this.amount = 1;
        this.data = 0;
        this.durability = 0;
        this.displayName = null;
        this.lore = null;
        this.enchantments = null;
        this.action = null;
        this.flags = new ArrayList<>();
    }

    /**
     * Sets the Material of the resulting ItemStack.
     *
     * @param material The Material.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder type(Material material)
    {
        this.material = material;

        return this;
    }

    /**
     * Sets the amount of the resulting ItemStack.
     *
     * @param amount The amount represented as an Integer.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder amount(int amount) {
        this.amount = amount;

        return this;
    }

    /**
     * Sets the data of the resulting ItemStack.
     *
     * @param data The data represented as a Byte.
     * @return The ItemBuilder instance;
     */
    public ItemBuilder data(byte data) {
        this.data = data;

        return this;
    }

    /**
     * Sets the durability of the resulting ItemStack.
     *
     * @param durability The durability represented as a Short.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder durability(short durability) {
        this.durability = durability;

        return this;
    }

    /**
     * Sets the display name of the resulting ItemStack.
     *
     * @param displayName The name represented as String.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder name(String displayName) {
        this.displayName = displayName;

        return this;
    }

    /**
     * Sets the lore of the resulting ItemStack.
     *
     * @param strings The String[] to set the lore to.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder lore(String... strings) {
        this.lore = Arrays.asList(strings);

        return this;
    }

    /**
     * Adds an enchantment to the resulting ItemStack.
     *
     * @param enchantment The Enchantment.
     * @param level The enchantment level as an Integer.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder enchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);

        return this;
    }

    /**
     * Sets enchantments on the resulting ItemStack.
     *
     * @param enchantments The Map of Enchantments to enchantments level.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder enchantments(Map<Enchantment, Integer> enchantments) {
        this.enchantments = enchantments;

        return this;
    }

    /**
     * Attaches an ItemAction to the resulting ItemStack.
     *
     * @param action The ItemAction.
     * @return The ItemBuilder instance.
     */
    @Deprecated
    public ItemBuilder withAction(ItemAction action) {
        throw new UnsupportedOperationException("Refrain from using ItemBuilder#withAction for the time being as actions as not persistent");

        // action.setCorrespondingItem(this);
        //
        // this.action = action;
        //
        // return this;
    }

    /**
     * Adds ItemFlags to the resulting ItemStack.
     *
     * @param flags The ItemFlags.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder withFlags(ItemFlag... flags) {
        this.flags.addAll(Arrays.asList(flags));

        return this;
    }

    /**
     * Removes ItemFlags from the resulting ItemStack.
     *
     * @param flags The ItemFlags.
     * @return The ItemBuilder instance.
     */
    public ItemBuilder withoutFlags(ItemFlag... flags) {
        this.flags.removeAll(Arrays.asList(flags));

        return this;
    }

    /**
     * Constructs the ItemStack from the current ItemBuilder configuration.
     */
    public ItemStack build() {
        ItemStack item = new ItemStack(getMaterial(), getAmount(), getDurability(), getData()); {
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
