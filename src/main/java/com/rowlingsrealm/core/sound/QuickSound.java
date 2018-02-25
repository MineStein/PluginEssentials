package com.rowlingsrealm.core.sound;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Copyright Tyler Grissom 2018
 */
public class QuickSound {

    public static void play(Sound sound, Player... players) {
        for (Player player :
                players) {
            player.playSound(player.getLocation(), sound, 1F, 1F);
        }
    }

    public static void click(Player... players) {
        play(Sound.UI_BUTTON_CLICK, players);
    }

    public static void levelUp(Player... players) {
        play(Sound.ENTITY_PLAYER_LEVELUP, players);
    }
}
