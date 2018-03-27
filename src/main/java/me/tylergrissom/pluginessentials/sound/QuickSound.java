package me.tylergrissom.pluginessentials.sound;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Copyright Tyler Grissom 2018
 */
public class QuickSound {

    /**
     * Plays a sound for the players.
     *
     * @param sound The sound to play.
     * @param players The players to play the sound for.
     */
    public static void play(Sound sound, Player... players) {
        SoundData data = new SoundData.SoundDataBuilder()
                .sound(sound)
                .build();

        data.play(players);
    }

    /**
     * Plays the UI_BUTTON_CLICK sound for players.
     *
     * @param players The players to play the click for.
     */
    public static void click(Player... players) {
        play(Sound.UI_BUTTON_CLICK, players);
    }

    /**
     * Plays the ENTITY_PLAYER_LEVELUP sound for players.
     *
     * @param players The players to play the level up for.
     */
    public static void levelUp(Player... players) {
        play(Sound.ENTITY_PLAYER_LEVELUP, players);
    }
}
