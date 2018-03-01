package com.rowlingsrealm.core.user;

import com.rowlingsrealm.core.menu.Menu;
import com.rowlingsrealm.core.message.Message;
import com.rowlingsrealm.core.sound.QuickSound;
import com.rowlingsrealm.core.title.TitleData;
import com.rowlingsrealm.core.title.TitleUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
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

    public void sendTitle(TitleData titleData) {
        TitleUtility.sendTitle(titleData, getPlayer());
    }

    public PlayerInventory getInventory() {
        return getPlayer().getInventory();
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

    public void sendActionBar(String actionBar) {
        getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(actionBar));
    }
}
