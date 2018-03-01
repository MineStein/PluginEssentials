package com.rowlingsrealm.core.title;

import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
public class TitleUtility {

    public static void sendTitle(TitleData titleData, Player... players) {
        Arrays.stream(players).forEach(player -> {
            if (player != null && player.isOnline()) {
                player.sendTitle(titleData.getTitle(), titleData.getSubtitle(), titleData.getFadeIn(), titleData.getStay(), titleData.getFadeOut());
            }
        });
    }
}
