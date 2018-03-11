package com.rowlingsrealm.core.magic;

import com.elmakers.mine.bukkit.api.magic.MagicAPI;
import com.rowlingsrealm.core.CorePlugin;
import com.rowlingsrealm.core.integration.MagicIntegration;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * Copyright Tyler Grissom 2018
 */
public class MagicUtility {

    @Getter
    private static MagicAPI api;

    static {
        api = ((MagicIntegration) CorePlugin.getInstance().getPluginIntegration("Magic")).getMagicAPI();
    }

    private static boolean isIntegrated() {
        return CorePlugin.getInstance().getPluginIntegration("Magic") != null;
    }

    public static boolean isHoldingWand(Player player) {
        if (!isIntegrated()) throw new UnsupportedOperationException("Magic is not integrated for this server.");

        return api.isWand(player.getInventory().getItemInMainHand());
    }
}
