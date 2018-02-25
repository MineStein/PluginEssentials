package com.rowlingsrealm.core.command;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

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
}
