package com.rowlingsrealm.core.integration;

import com.elmakers.mine.bukkit.api.magic.MagicAPI;
import com.rowlingsrealm.core.CorePlugin;
import com.rowlingsrealm.core.server.Server;
import lombok.Getter;

/**
 * Copyright Tyler Grissom 2018
 */
public class MagicIntegration extends PluginIntegration {

    @Getter
    private MagicAPI magicAPI;

    public MagicIntegration(CorePlugin plugin) {
        super(plugin);
    }

    @Override
    public String getPluginName() {
        return "Magic";
    }

    @Override
    public boolean shouldNotifyRegistration() {
        return true;
    }

    @Override
    public boolean isSoftDependency() {
        return true;
    }

    @Override
    public void integrate() {
        this.magicAPI = (MagicAPI) Server.getPluginManager().getPlugin("Magic");
    }
}
