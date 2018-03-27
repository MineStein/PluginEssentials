package me.tylergrissom.pluginessentials.command;

import lombok.Getter;
import me.tylergrissom.pluginessentials.SpigotPlugin;
import me.tylergrissom.pluginessentials.command.api.CommandBase;
import me.tylergrissom.pluginessentials.command.api.CommandDetails;

import java.util.List;

/**
 * Copyright Tyler Grissom 2018
 */
public class PluginEssentialsCommand extends CommandBase {

    @Getter private SpigotPlugin plugin;

    public PluginEssentialsCommand(SpigotPlugin plugin) {
        super("pluginessentials");

        this.plugin = plugin;
    }

    public void execute(CommandDetails details) {
        String version = getPlugin().getDescription().getVersion();

        details.sendMessage("§e§lPluginEssentials §8> §7Version " + version);
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
