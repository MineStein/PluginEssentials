package com.rowlingsrealm.core;

import com.rowlingsrealm.core.command.*;
import com.rowlingsrealm.core.message.MessageManager;
import com.rowlingsrealm.core.user.UserManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright Tyler Grissom 2018
 *
 * TODO:
 *  - Simple ConfigurationSerializable implementation
 *  - Magic integration
 *  - InventoryBuilder
 *  - InventoryUtility
 *  - Devise a better way to handle inventory sizes than numbers
 *  - Add checks for null items and stuff like that to Menu for simplification
 *  - Reflection utilities
 *  - Pagination for menus
 *  - Add support to MessageManager for custom replace formats such as %value% instead of default $value
 *  - Multi-line messages
 *  - Provide a set of default messages that are commonly used for consistency (i.e. no permission, only players, etc.)
 *  - Boss bars
 *  - Action bars
 *  - Add logging with verbosity options
 *  - Custom Runnable implementation for scheduling
 *  - Wrap Vault (PEX, eco, etc.)
 *  - Some way to bundle sounds and messages together
 *  - Scoreboard utilities
 *  - Simple creation and access to custom configs
 *  - Support for separate defaults folder for config write/read
 *  - Simple SQL database driver access and method wrapping
 *  - Item message https://www.spigotmc.org/threads/itemmessagereloaded-popup-message-packet.304903/
 *  - Advancements https://www.spigotmc.org/threads/advancement-creator-rapid-advancement-creation-library.293465/
 *  - Send tab header and footer
 *  - Add package-info files, double-check documentation of everything, and get docs hosted
 *  - More fleshed-out TimeUtility methods
 *  - EffectLib integration
 *  - Customize Essentials commands
 *  - Wrap Worlds
 *  - Lore splitter to divide up items
 *  - Cross-server utilities
 *  - Add quick methods to CommandDetails such as hasPermission, isPlayer, etc.
 */
public class CorePlugin extends JavaPlugin {

    @Getter private MessageManager messageManager;
    @Getter private UserManager userManager;

    /**
     * Sets up the config.yml for this plugin.
     */
    public FileConfiguration setupDefaultConfigurationFile() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        return getConfig();
    }

    /**
     * Sets up the MessageManager instance for this plugin.
     *
     * @return The MessageManager instance.
     */
    public MessageManager setupMessageManager() {
        if (messageManager != null) return messageManager;

        this.messageManager = new MessageManager(this);

        return this.messageManager;
    }

    /**
     * Registers your event listeners.
     *
     * @param listeners The listeners to register.
     */
    public void registerListeners(Listener... listeners) {
        for (Listener listener :
             listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }

    /**
     * Registers your command executors and tab completers, bundled into one class.
     *
     * @param bases The CommandBases to register.
     */
    public void registerCommands(CommandBase... bases) {
        for (CommandBase base :
                bases) {
            getCommand(base.getCommandLabel()).setExecutor(base);
            getCommand(base.getCommandLabel()).setTabCompleter(base);
        }
    }

    @Override
    public void onEnable() {
        userManager = new UserManager(this);

        setupMessageManager();

        {
            registerCommands(
                    new CoreCommand(this),
                    new DiscordCommand(this),
                    new FaqCommand(this),
                    new StoreCommand(this),
                    new WebsiteCommand(this)
            );
        }
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
