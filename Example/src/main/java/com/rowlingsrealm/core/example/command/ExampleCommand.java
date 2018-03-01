package com.rowlingsrealm.core.example.command;

import com.rowlingsrealm.core.command.CommandBase;
import com.rowlingsrealm.core.command.CommandDetails;
import com.rowlingsrealm.core.example.ExamplePlugin;
import com.rowlingsrealm.core.menu.ConfirmationMenu;
import com.rowlingsrealm.core.user.User;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

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
            User user = new User(((Player) sender));

            user.openMenu(new ConfirmationMenu(plugin) {
                @Override
                public void onResolve(Result result, InventoryClickEvent event) {
                    if (result.equals(Result.ACCEPTED)) {
                        user.sendMessage("Accepted!");
                    } else {
                        user.sendMessage("Denied!");
                    }
                }
            });
        }
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
