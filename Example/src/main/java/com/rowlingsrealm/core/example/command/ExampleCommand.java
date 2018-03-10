package com.rowlingsrealm.core.example.command;

import com.rowlingsrealm.core.command.api.CommandBase;
import com.rowlingsrealm.core.command.api.CommandDetails;
import com.rowlingsrealm.core.example.ExamplePlugin;
import com.rowlingsrealm.core.item.SkullItemBuilder;
import com.rowlingsrealm.core.user.User;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
            User user = new User(((Player) sender));
            ItemStack item = SkullItemBuilder.of("MineStein_");

            user.getInventory().addItem(item);
        }
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
