package com.rowlingsrealm.core;

import com.rowlingsrealm.core.command.CommandBase;
import com.rowlingsrealm.core.command.CoreCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

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
 *  - Convert ItemBuilder to use Lombok and document
 *  - Wrap Player
 *  - Pagination for menus
 */
public class CorePlugin extends JavaPlugin {

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
