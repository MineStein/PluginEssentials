package com.rowlingsrealm.core.example.command;

import com.rowlingsrealm.core.color.ColorUtility;
import com.rowlingsrealm.core.command.api.CommandBase;
import com.rowlingsrealm.core.command.api.CommandDetails;
import com.rowlingsrealm.core.example.ExamplePlugin;
import com.rowlingsrealm.core.magic.MagicUtility;
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

        details.sendMessage("The example works!");

        if (sender instanceof Player) {
            Player p = ((Player) sender);

            if (MagicUtility.isHoldingWand(p)) {
                p.sendMessage(ColorUtility.translate("&aIt works!"));
            } else {
                p.sendMessage(ColorUtility.translate("&cIt didn't work :( Hold a wand!"));
            }
        }
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
