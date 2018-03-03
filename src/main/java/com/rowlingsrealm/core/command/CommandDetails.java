package com.rowlingsrealm.core.command;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

/**
 * Copyright Tyler Grissom 2018
 */
public class CommandDetails {

    @Getter private CommandSender sender;
    @Getter private Command command;
    @Getter private String label;
    @Getter private String[] args;

    public CommandDetails(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
    }

    public boolean isPlayer() {
        return sender instanceof Player;
    }

    public boolean isConsole() {
        return sender instanceof ConsoleCommandSender;
    }

    public boolean hasPermission(Permission permission) {
        return sender.hasPermission(permission);
    }

    public boolean hasPermission(String permission) {
        return sender.hasPermission(permission);
    }
}
