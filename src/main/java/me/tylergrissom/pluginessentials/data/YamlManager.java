package me.tylergrissom.pluginessentials.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.tylergrissom.pluginessentials.SpigotPlugin;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public class YamlManager {

    @Getter
    private SpigotPlugin plugin;

    public CustomYaml getCustomYaml(String path) {
        return new CustomYaml(getPlugin(), path);
    }
}
