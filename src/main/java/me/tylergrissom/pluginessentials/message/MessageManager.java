package me.tylergrissom.pluginessentials.message;

import lombok.Getter;
import me.tylergrissom.pluginessentials.SpigotPlugin;
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
    private SpigotPlugin plugin;

    private FileConfiguration messagesYml;
    private File messagesFile;

    public MessageManager(SpigotPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Reloads the messages.yml.
     */
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

    /**
     * Gets the messages.yml.
     *
     * @return The messages.yml configuration file.
     */
    public FileConfiguration getMessages() {
        if (messagesFile == null) {
            reloadMessages();
        }

        return messagesYml;
    }

    /**
     * Saves the messages.yml.
     */
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

    /**
     * Retrieves the Message at the node.
     *
     * @param node The node to look for.
     * @return The Message instance.
     */
    public Message getMessage(String node) {
        FileConfiguration config = getMessages();
        Object obj = config.get(node);

        if (obj == null || !(obj instanceof String)) throw new IllegalArgumentException(String.format("Entry at messages.yml node `%s` is not a String", node));

        return new Message(node, (String) obj);
    }
}
