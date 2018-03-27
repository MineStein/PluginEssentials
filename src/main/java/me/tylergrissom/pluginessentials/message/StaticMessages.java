package me.tylergrissom.pluginessentials.message;

import lombok.Getter;
import me.tylergrissom.pluginessentials.SpigotPlugin;

/**
 * Copyright Tyler Grissom 2018
 */
public class StaticMessages {

    @Getter
    private static MessageManager messageManager;

    static {
        messageManager = SpigotPlugin.getInstance().getMessageManager();
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
