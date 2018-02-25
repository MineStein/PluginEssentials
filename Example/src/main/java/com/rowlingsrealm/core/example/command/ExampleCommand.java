package com.rowlingsrealm.core.example.command;

import com.rowlingsrealm.core.command.CommandBase;
import com.rowlingsrealm.core.command.CommandDetails;
import com.rowlingsrealm.core.item.ItemBuilder;
import com.rowlingsrealm.core.sound.QuickSound;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Copyright Tyler Grissom 2018
 */
public class ExampleCommand extends CommandBase {

    public ExampleCommand() {
        super("example");
    }

    public void execute(CommandDetails details) {
        CommandSender sender = details.getSender();

        sender.sendMessage("The example works!");

        if (sender instanceof Player) {
            Player p = ((Player) sender);
            ItemStack item = new ItemBuilder()
                    .type(Material.DIRT)
                    .name("§6§l§mTesting!")
                    .lore("§7this is a §b§ktest §0of my example command")
                    .build();

            p.getInventory().addItem(item);

            QuickSound.levelUp(p);
        }
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
