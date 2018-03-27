package me.tylergrissom.pluginessentials.server;

import me.tylergrissom.pluginessentials.SpigotPlugin;
import me.tylergrissom.pluginessentials.message.Message;
import me.tylergrissom.pluginessentials.user.User;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Copyright Tyler Grissom 2018
 */
public class Server {

    public static class Logger {

        public static void info(String... str) {
            Arrays.stream(str).forEach(Bukkit.getLogger()::info);
        }

        public static void warn(String... str) {
            Arrays.stream(str).forEach(Bukkit.getLogger()::warning);
        }

        public static void severe(String... str) {
            Arrays.stream(str).forEach(Bukkit.getLogger()::severe);
        }
    }

    public static class Utilities {

        public static void sendToServer(User user, String server) {
            user.sendToServer(server);
        }

        public static void sendToServer(Player player, String server) {
            SpigotPlugin.getInstance().getUserManager().getUser(player).sendToServer(server);
        }
    }

    public static Collection<? extends Player> getOnlinePlayers() {
        return Bukkit.getOnlinePlayers();
    }

    public static OfflinePlayer[] getOfflinePlayers() {
        return Bukkit.getOfflinePlayers();
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

    public static Player getPlayer(String id) {
        return Bukkit.getPlayer(id);
    }

    public static OfflinePlayer getOfflinePlayer(String id) {
        return Bukkit.getOfflinePlayer(id);
    }

    public static Player getPlayer(UUID uuid) {
        return Bukkit.getPlayer(uuid);
    }

    public static OfflinePlayer getOfflinePlayer(UUID uuid) {
        return Bukkit.getOfflinePlayer(uuid);
    }

    public static void dispatchCommand(CommandSender sender, String command) {
        Bukkit.dispatchCommand(sender, command);
    }

    public static void dispatchConsoleCommand(String command) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }

    public static PluginManager getPluginManager() {
        return Bukkit.getPluginManager();
    }
}
