package me.tylergrissom.pluginessentials.message;

import me.tylergrissom.pluginessentials.color.ColorUtility;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
@AllArgsConstructor
public class Message {

    @Getter private String node;

    // TODO Make and keep an original copy

    private String messageString;

    /**
     * Translates the Message's alternate color codes.
     *
     * @return The modified Message.
     */
    public Message withColor() {
        this.messageString = ColorUtility.translate(messageString);

        return this;
    }

    /**
     * Removes all regular instances of color codes.
     *
     * @return The modified Message.
     */
    public Message withoutColor() {
        this.messageString = ColorUtility.strip(messageString);

        return this;
    }

    /**
     * Removes all irregular instances of color codes.
     *
     * @return The modified Message.
     */
    public Message withoutColorDeep() {
        this.messageString = ColorUtility.translateAndStrip(messageString);

        return this;
    }

    /**
     * Replaces a String, automatically prefixed with $, with another String.
     *
     * @param replace The String to search for.
     * @param with The String to replace with.
     * @return The modified Message.
     */
    public Message replace(String replace, String with) {
        this.messageString = messageString.replace("$" + replace, with);

        return this;
    }

    /**
     * Replaces a key in a Pair, automatically prefixed with $, with the value in the Pair.
     *
     * @param replaceWithPair The Pair.
     * @return The modified Message.
     */
    public Message replace(Pair<String, String> replaceWithPair) {
        this.messageString = messageString.replace("$" + replaceWithPair.getKey(), replaceWithPair.getValue());

        return this;
    }

    /**
     * Iterates through each entry within a Map and replaced the key, automatically prefixed with $, with the value.
     *
     * @param replaceWithMap The Map to iterate.
     * @return The modified Message.
     */
    public Message replace(Map<String, String> replaceWithMap) {
        for (Map.Entry<String, String> entry :
                replaceWithMap.entrySet()) {
            this.messageString = messageString.replace("$" + entry.getKey(), entry.getValue());
        }

        return this;
    }

    /**
     * Returns the Message as a String.
     */
    public String get() {
        return this.messageString;
    }

    @Override
    public String toString() {
        return get();
    }
}
