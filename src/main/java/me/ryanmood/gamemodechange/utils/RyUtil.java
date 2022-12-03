package me.ryanmood.gamemodechange.utils;

/*
If you decide to use this in your plugin, please give credit.
For support please join my support discord @ https://discord.gg/6QNEGPK3Fb
 */

import me.clip.placeholderapi.PlaceholderAPI;
import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.cache.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import javax.annotation.Nullable;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class RyUtil {

    public static String consolePrefix = "&b&lGAMEMODE CHANGE ";

    public static String translate(@Nullable Player player, String message) {
        // If player isn't null & if PlaceholderAPI is on the server.
        if (player != null && Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            return PlaceholderAPI.setPlaceholders(player, ChatColor.translateAlternateColorCodes('&', message));
        }
        // If player is null or PlaceholderAPI isn't on the server.
        return ChatColor.translateAlternateColorCodes('&', message);

    }

    public static void sendPlayerMSG(Player player, String message) {
        player.sendMessage(translate(player, message));
    }

    public static void sendConsoleMSG(Boolean prefix, String message) {
        if (prefix) {
            // If prefix is true
            Bukkit.getConsoleSender().sendMessage(translate(null, consolePrefix + message));
        } else {
            // If prefix is false.
            Bukkit.getConsoleSender().sendMessage(translate(null, message));
        }
    }

    public static void sendBroadcastPerm(Player player, @Nullable String perm, String message) {
        if (perm != null) {
            // If perm isn't null
            Bukkit.broadcast(translate(player, message), perm);
        } else {
            // If perm is null
            Bukkit.broadcastMessage(translate(player, message));
        }
    }

    public static String gamemodeToString(GameMode gamemode) {
        return gamemode.toString()
                .replace("CREATIVE", Config.CREATIVE)
                .replace("SURVIVAL", Config.SURVIVAL)
                .replace("ADVENTURE", Config.ADVENTURE)
                .replace("SPECTATOR", Config.SPECTATOR);
    }

    public static GameMode intToGamemode(int gamemode) {
        if (gamemode == 0) {
            // 0 = Survival
            return GameMode.SURVIVAL;
        } else if (gamemode == 1) {
            // 1 = Creative
            return GameMode.CREATIVE;
        } else if (gamemode == 2) {
            // 2 = Adventure
            return GameMode.ADVENTURE;
        } else /*if (gamemode == 3)*/ {
            // 3 = Spectator
            return GameMode.SPECTATOR;
        }
    }

    public static PluginDescriptionFile getDescription() {
        return GamemodeChange.getInstance().getDescription();
    }

}
