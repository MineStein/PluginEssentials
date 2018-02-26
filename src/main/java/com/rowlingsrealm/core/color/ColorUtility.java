package com.rowlingsrealm.core.color;

import org.bukkit.ChatColor;

/**
 * Copyright Tyler Grissom 2018
 */
public class ColorUtility {

    // TODO Add ChatColor enums and stuff to here for easy access

    public static char LEGAL_SECTION_SYMBOL = '§';

    /**
     * Strips all ChatColor from a String.
     *
     * @param str The String to strip.
     * @return The stripped String.
     */
    public static String strip(String str) {
        return ChatColor.stripColor(str);
    }

    /**
     * Translates all alternative color codes to the legal section symbol.
     *
     * @param altColorCode The character to replace.
     * @param str The String to translate.
     * @return The translated String.
     */
    public static String altTranslate(char altColorCode, String str) {
        return ChatColor.translateAlternateColorCodes(altColorCode, str);
    }

    /**
     * Translates the ampersand (&) to the legal section symbol.
     *
     * @param str The String to translate.
     * @return The translated String.
     */
    public static String translate(String str) {
        return altTranslate('&', str);
    }

    /**
     * Translates the ampersand (&) to the legal section symbol before subsequently stripping any color.
     *
     * @param str The String to translate and strip.
     * @return The stripped String.
     */
    public static String translateAndStrip(String str) {
        return strip(translate(str));
    }
}
