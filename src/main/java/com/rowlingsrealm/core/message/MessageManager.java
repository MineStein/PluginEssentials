package com.rowlingsrealm.core.message;

import com.rowlingsrealm.core.CorePlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.logging.Level;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
public class MessageManager {

    @Getter
    private CorePlugin plugin;

    private FileConfiguration messagesYml;
    private File messagesFile;

    public MessageManager(CorePlugin plugin) {
        this.plugin = plugin;
    }

    public void reloadMessages() {
        if (messagesFile == null) {
            messagesFile = new File(getPlugin().getDataFolder(), "messages.yml");
        }

        messagesYml = YamlConfiguration.loadConfiguration(messagesFile);

        Reader defConfigStream = null;

        try {
            defConfigStream = new InputStreamReader(getPlugin().getResource("messages.yml"), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);

            messagesYml.setDefaults(defConfig);
        }
    }

    public FileConfiguration getMessages() {
        if (messagesFile == null) {
            reloadMessages();
        }

        return messagesYml;
    }

    public void saveMessages() {
        if (messagesYml == null || messagesFile == null) {
            return;
        }

        try {
            messagesYml.save(messagesFile);
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save config to " + messagesFile, ex);
        }
    }

    public Message getMessage(String node) {
        FileConfiguration config = getMessages();
        Object obj = config.get(node);

        if (obj == null || !(obj instanceof String)) throw new IllegalArgumentException(String.format("Entry at messages.yml node `%s` is not a String", node));

        return new Message(node, (String) obj);
    }
}
