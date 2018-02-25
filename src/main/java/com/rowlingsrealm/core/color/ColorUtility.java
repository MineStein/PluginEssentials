package com.rowlingsrealm.core.color;

import org.bukkit.ChatColor;

/**
 * Copyright Tyler Grissom 2018
 */
public class ColorUtility {

    public static String strip(String str) {
        return ChatColor.stripColor(str);
    }

    public static String altTranslate(char altColorCode, String str) {
        return ChatColor.translateAlternateColorCodes(altColorCode, str);
    }

    public static String translate(String str) {
        return altTranslate('&', str);
    }

    public static String translateAndStrip(String str) {
        return strip(translate(str));
    }
}
