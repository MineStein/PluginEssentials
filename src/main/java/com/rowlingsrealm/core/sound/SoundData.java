package com.rowlingsrealm.core.sound;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Copyright Tyler Grissom 2018
 */
@Builder
public class SoundData {

    @Getter
    private Sound sound;

    @Getter
    private float volume = 1.0F, pitch = 1.0F;

    @Getter
    private int count = 1;

    public void play(Player... players) {
        for (int i = 0; i < getCount(); i++) {
            Arrays.stream(players).forEach(player -> player.playSound(player.getLocation(), getSound(), getVolume(), getPitch()));
        }
    }
}
