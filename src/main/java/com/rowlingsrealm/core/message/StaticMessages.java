package com.rowlingsrealm.core.message;

import com.rowlingsrealm.core.CorePlugin;
import lombok.Getter;

/**
 * Copyright Tyler Grissom 2018
 */
public class StaticMessages {

    @Getter
    private static MessageManager messageManager;

    static {
        messageManager = CorePlugin.getInstance().getMessageManager();
    }

    private static Message getStaticMessage(String subNode) {
        return getMessageManager().getMessage("static." + subNode);
    }

    public static Message getNoPermission() {
        return getStaticMessage("no_permission");
    }

    public static Message getTargetIsOffline() {
        return getStaticMessage("target_offline");
    }

    public static Message getOnlyPlayers() {
        return getStaticMessage("only_players");
    }
}
