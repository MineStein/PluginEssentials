package com.rowlingsrealm.core.message;

import com.rowlingsrealm.core.color.ColorUtility;
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

    private String messageString;

    public Message withColor() {
        this.messageString = ColorUtility.translate(messageString);

        return this;
    }

    public Message withoutColor() {
        this.messageString = ColorUtility.strip(messageString);

        return this;
    }

    public Message withoutColorDeep() {
        this.messageString = ColorUtility.translateAndStrip(messageString);

        return this;
    }

    public Message replace(String replace, String with) {
        this.messageString = messageString.replace("$" + replace, with);

        return this;
    }

    public Message replace(Pair<String, String> replaceWithPair) {
        this.messageString = messageString.replace("$" + replaceWithPair.getKey(), replaceWithPair.getValue());

        return this;
    }

    public Message replace(Map<String, String> replaceWithMap) {
        for (Map.Entry<String, String> entry :
                replaceWithMap.entrySet()) {
            this.messageString = messageString.replace("$" + entry.getKey(), entry.getValue());
        }

        return this;
    }

    public String get() {
        return this.messageString;
    }
}
