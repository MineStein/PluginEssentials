package com.rowlingsrealm.core.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public abstract class CommandBase implements CommandExecutor, TabCompleter {

    @Getter private String commandLabel;

    abstract void execute(CommandDetails details);

    abstract List<String> tab(CommandDetails details);

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        execute(new CommandDetails(commandSender, command, s, strings));

        return true;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return tab(new CommandDetails(commandSender, command, s, strings));
    }
}
