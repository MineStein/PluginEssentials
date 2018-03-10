package com.rowlingsrealm.core;

import com.rowlingsrealm.core.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * Copyright Tyler Grissom 2018
 */
public class Server {

    public static class Logger {

        public static void info(String str) {
            Bukkit.getLogger().info(str);
        }

        public static void warn(String str) {
            Bukkit.getLogger().warning(str);
        }

        public static void severe(String str) {
            Bukkit.getLogger().severe(str);
        }
    }

    public static Collection<? extends Player> getOnlinePlayers() {
        return Bukkit.getOnlinePlayers();
    }

    public static void broadcast(String str) {
        getOnlinePlayers().forEach((Consumer<Player>) player -> player.sendMessage(str));
    }

    public static void broadcast(Message message) {
        broadcast(message.get());
    }

    public static World getWorld(String name) {
        return Bukkit.getWorld(name);
    }

    public static List<World> getWorlds() {
        return Bukkit.getWorlds();
    }
}
