package com.rowlingsrealm.core.data;

import com.rowlingsrealm.core.CorePlugin;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public class YamlManager {

    @Getter
    private CorePlugin plugin;

    public CustomYaml getCustomYaml(String path) {
        return new CustomYaml(getPlugin(), path);
    }
}
