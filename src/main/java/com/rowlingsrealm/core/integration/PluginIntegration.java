package com.rowlingsrealm.core.integration;

import com.rowlingsrealm.core.CorePlugin;
import com.rowlingsrealm.core.Server;
import lombok.Getter;

/**
 * Copyright Tyler Grissom 2018
 */
public abstract class PluginIntegration {

    @Getter
    private CorePlugin plugin;

    @Getter
    private boolean successful;

    public PluginIntegration(CorePlugin plugin) {
        this.plugin = plugin;

        if (!isRunningPlugin(getPluginName())) {
            Server.Logger.warn(String.format("Could not integrate with " + (isSoftDependency() ? " soft " : " ") + "dependency '%s'", getPluginName()));

            this.successful = false;
        } else {
            integrate();

            this.successful = true;

            if (shouldNotifyRegistration()) Server.Logger.info(String.format("Integrated with '%s' successfully.", getPluginName()));
        }
    }

    public abstract String getPluginName();

    public abstract boolean shouldNotifyRegistration();
    public abstract boolean isSoftDependency();

    public abstract void integrate();

    protected boolean isRunningPlugin(String pluginName) {
        return Server.getPluginManager().getPlugin(pluginName) != null;
    }
}
