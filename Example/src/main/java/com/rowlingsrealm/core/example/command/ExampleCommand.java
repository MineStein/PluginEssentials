package com.rowlingsrealm.core.example.command;

import com.rowlingsrealm.core.command.CommandBase;
import com.rowlingsrealm.core.command.CommandDetails;
import com.rowlingsrealm.core.example.ExamplePlugin;
import com.rowlingsrealm.core.example.menu.ExampleMenu;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

        sender.sendMessage("The example works!");

        if (sender instanceof Player) {
            new ExampleMenu(plugin).open(((Player) sender));
        }
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
