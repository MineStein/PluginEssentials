package com.rowlingsrealm.core.user;

import com.rowlingsrealm.core.menu.Menu;
import com.rowlingsrealm.core.message.Message;
import com.rowlingsrealm.core.sound.QuickSound;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public class User {

    @Getter private Player player;

    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        getPlayer().sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    public void sendTitle(String title, String subtitle, int stay) {
        sendTitle(title, subtitle, 10, stay, 10);
    }

    public void sendTitle(String title, String subtitle) {
        sendTitle(title, subtitle, 100);
    }

    public PlayerInventory getInventory() {
        return getPlayer().getInventory();
    }

    public void performCommand(String cmd) {
        getPlayer().performCommand(cmd);
    }

    public void openMenu(Menu menu) {
        menu.open(player);
    }

    public void playSound(Sound sound) {
        QuickSound.play(sound, getPlayer());
    }

    public void sendMessage(Message message) {
        getPlayer().sendMessage(message.get());
    }

    public void sendMessage(String message) {
        getPlayer().sendMessage(message);
    }

    public void sendMessage(List<String> messages) {
        getPlayer().sendMessage((String[]) messages.toArray());
    }

    public void sendMessage(String... messages) {
        Arrays.stream(messages).forEach(this::sendMessage);
    }
}