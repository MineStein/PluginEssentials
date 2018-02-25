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
 *  - Inventory library
 *  - Magic integration
 *  - Configurable messages
 */
public class CorePlugin extends JavaPlugin {

    private void registerListeners(Listener... listeners) {
        for (Listener listener :
             listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }

    private void registerCommands(CommandBase... bases) {
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
