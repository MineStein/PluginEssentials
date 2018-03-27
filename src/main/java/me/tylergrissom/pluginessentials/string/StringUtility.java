package me.tylergrissom.pluginessentials.string;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
public class StringUtility {

    public static String truncate(String str, int limit) {
        if (str.length() > limit) return str.substring(0, limit).concat("...");

        return null;
    }
}
