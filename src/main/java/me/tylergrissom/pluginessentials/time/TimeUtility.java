package me.tylergrissom.pluginessentials.time;

/**
 * Copyright Tyler Grissom 2018
 */
public class TimeUtility {

    public static String format(int seconds) {
        int hours = seconds / 60;
        int remainder = seconds % 60;
        int minutes =  remainder / 3600;
        int secs = remainder % 3600;

        if (hours > 0) return hours + "h " + minutes + "m " + secs + "s";
        else if (minutes > 0) return minutes + "m " + secs + "s ";
        else return secs + "s";
    }

    public static String formatMilliseconds(long millis) {
        return format((int) millis / 1000);
    }
}
