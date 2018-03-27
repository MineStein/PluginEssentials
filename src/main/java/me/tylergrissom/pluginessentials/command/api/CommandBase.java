package me.tylergrissom.pluginessentials.command.api;

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

    /**
     * Called when the player executes the command.
     *
     * @param details The CommandDetails object.
     */
    public abstract void execute(CommandDetails details);

    /**
     * Called when the player presses tab while they have the command opened.
     *
     * @param details The CommandDetails object.
     * @return The tab options to present to the player.
     */
    public abstract List<String> tab(CommandDetails details);

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        execute(new CommandDetails(commandSender, command, s, strings));

        return true;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return tab(new CommandDetails(commandSender, command, s, strings));
    }
}
