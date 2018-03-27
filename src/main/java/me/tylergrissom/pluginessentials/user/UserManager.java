package me.tylergrissom.pluginessentials.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.tylergrissom.pluginessentials.SpigotPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public class UserManager {

    @Getter private SpigotPlugin plugin;

    /**
     * Get User instance from Player.
     *
     * @param player The Player to base the User on.
     * @return The User instance.
     */
    public User getUser(Player player) {
        return new User(player);
    }

    /**
     * Get User instance from UUID String or username.
     *
     * @param str The UUID String or username to use.
     * @return The User instance.
     */
    public User getUser(String str) {
        return getUser(Bukkit.getPlayer(str));
    }

    /**
     * Get User instance from UUID.
     *
     * @param uuid The UUID to use.
     * @return The User instance.
     */
    public User getUser(UUID uuid) {
        return getUser(Bukkit.getPlayer(uuid));
    }

    /**
     * Gets a List of Users in a World
     *
     * @param world The World to grab the Users from.
     * @return The User instance.
     */
    public List<User> getUsersInWorld(World world) {
        List<User> users = new ArrayList<>();

        for (Player player :
                world.getPlayers()) {
            users.add(getUser(player));
        }

        return users;
    }

    /**
     * Gets a List of all Users online.
     *
     * @return The User instance.
     */
    public List<User> getOnlineUsers() {
        List<User> users = new ArrayList<>();

        Bukkit.getOnlinePlayers().forEach((Consumer<Player>) player -> users.add(getUser(player)));

        return users;
    }
}
