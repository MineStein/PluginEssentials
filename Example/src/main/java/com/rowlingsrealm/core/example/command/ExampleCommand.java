package com.rowlingsrealm.core.example.command;

import com.rowlingsrealm.core.command.CommandBase;
import com.rowlingsrealm.core.command.CommandDetails;
import com.rowlingsrealm.core.example.ExamplePlugin;
import com.rowlingsrealm.core.item.ItemAction;
import com.rowlingsrealm.core.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
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

        sender.sendMessage("The example works!");

        if (sender instanceof Player) {
            final Player p = ((Player) sender);

            ItemStack i = new ItemBuilder()
                    .type(Material.DIAMOND_SWORD)
                    .name("§5A beautiful diamond sword")
                    .withAction(new ItemAction(getPlugin()) {
                        @Override
                        public void onInteract(PlayerInteractEvent event) {
                            p.sendMessage("You " + event.getAction() + " the item");
                        }
                    })
                    .build();

            p.getInventory().addItem(i);
        }
    }

    public List<String> tab(CommandDetails details) {
        return null;
    }
}
