package com.rowlingsrealm.core;

import com.rowlingsrealm.core.command.CommandBase;
import com.rowlingsrealm.core.command.CoreCommand;
import com.rowlingsrealm.core.message.MessageManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Copyright Tyler Grissom 2018
 *
 * TODO:
 *  - Simple ConfigurationSerializable implementation
 *  - Magic integration
 *  - Configurable messages
 *  - InventoryBuilder
 *  - InventoryUtility
 *  - Devise a better way to handle inventory sizes than numbers
 *  - Add checks for null items and stuff like that to Menu for simplification
 *  - Reflection utilities
 *  - Custom, deep ItemBuilder with documentation
 *  - Wrap Player
 *  - Pagination for menus
 *  - Add support to MessageManager for custom replace formats such as %value% instead of default $value
 *  - Provide a set of default messages that are commonly used for consistency (i.e. no permission, only players, etc.)
 *  - Titles
 *  - Boss bars
 *  - Action bars
 *  - Add logging with verbosity options
 */
public class CorePlugin extends JavaPlugin {

    private FileConfiguration messagesYml;
    private File messagesFile;

    @Getter private MessageManager messageManager;

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
        registerCommands(new CoreCommand(this));
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
