package com.rowlingsrealm.core.command;

import com.rowlingsrealm.core.CorePlugin;
import lombok.Getter;

import java.util.List;

import static java.lang.String.format;

/**
 * Copyright Tyler Grissom 2018
 */
public class CoreCommand extends CommandBase {

    @Getter private CorePlugin plugin;

    public CoreCommand(CorePlugin plugin) {
        super("core");

        this.plugin = plugin;
    }

    public void execute(CommandDetails details) {
        String version = getPlugin().getDescription().getVersion();

        details.getSender().sendMessage(format("§dRowling's Realm §8§l| §5§lCore §6v%s", version));
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
