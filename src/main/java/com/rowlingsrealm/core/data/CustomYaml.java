package com.rowlingsrealm.core.data;

import com.rowlingsrealm.core.CorePlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.logging.Level;

/**
 * Copyright Tyler Grissom 2018
 */
public class CustomYaml {

    @Getter
    private CorePlugin plugin;

    @Getter
    private String path;

    @Getter
    private File file;

    private FileConfiguration yml;

    public CustomYaml(CorePlugin plugin, String path) {
        this.plugin = plugin;
        this.path = path;

        reload();
    }

    /**
     * Reloads the custom YAML.
     */
    public void reload() {
        if (!path.endsWith(".yml")) path += ".yml";
        if (file == null) file = new File(getPlugin().getDataFolder(), path);

        yml = YamlConfiguration.loadConfiguration(file);

        Reader defConfigStream = null;

        try {
            defConfigStream = new InputStreamReader(getPlugin().getResource(path), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);

            yml.setDefaults(defConfig);
        }
    }

    /**
     * Gets the custom YAML.
     *
     * @return The messages.yml configuration file.
     */
    public FileConfiguration getYml() {
        if (file == null) reload();

        return yml;
    }

    /**
     * Saves the custom YAML.
     */
    public void save() {
        if (yml == null || file == null) return;

        try {
            yml.save(file);
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save config to " + file, ex);
        }
    }
}
