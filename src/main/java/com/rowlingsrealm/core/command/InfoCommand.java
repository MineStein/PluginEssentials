package com.rowlingsrealm.core.command;

import com.rowlingsrealm.core.CorePlugin;
import com.rowlingsrealm.core.message.Message;
import com.rowlingsrealm.core.message.MessageManager;
import lombok.Getter;

import java.util.List;

/**
 * Copyright Tyler Grissom 2018
 */
public abstract class InfoCommand extends CommandBase {

    @Getter private CorePlugin plugin;

    public InfoCommand(CorePlugin plugin, String commandLabel) {
        super(commandLabel);

        this.plugin = plugin;
    }

    @Override
    public void execute(CommandDetails details) {
        MessageManager messageManager = getPlugin().getMessageManager();

        Message info = messageManager.getMessage("info." + details.getLabel())
                .withColor();

        details.sendMessage(info);
    }

    @Override
    public List<String> tab(CommandDetails details) {
        return null;
    }
}
