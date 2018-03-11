package com.rowlingsrealm.core.example;

import com.rowlingsrealm.core.CorePlugin;
import com.rowlingsrealm.core.example.command.ExampleCommand;

/**
 * Copyright Tyler Grissom 2018
 */
public class ExamplePlugin extends CorePlugin {

    @Override
    public void onEnable() {
        registerCommands(new ExampleCommand(this));

        setupMessageManager();
    }
}
