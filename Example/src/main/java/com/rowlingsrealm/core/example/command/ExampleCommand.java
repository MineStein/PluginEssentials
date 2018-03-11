package com.rowlingsrealm.core.example.command;

import com.rowlingsrealm.core.command.api.CommandBase;
import com.rowlingsrealm.core.command.api.CommandDetails;
import com.rowlingsrealm.core.example.ExamplePlugin;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

/**
 * Copyright Tyler Grissom 2018
 */
public class ExampleCommand extends CommandBase {

    @Getter private ExamplePlugin plugin;

    public ExampleCommand(ExamplePlugin plugin) {
        super("example");

        this.plugin = plugin;
    }

    public void execute(CommandDetails details) {
        CommandSender sender = details.getSender();
        FileConfiguration fc = getPlugin().getYamlManager().getCustomYaml("example").getYml();

        sender.sendMessage(fc.getString("example"));
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
