package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.config.cache.Messages;
import me.ryanmood.gamemodechange.config.cache.Perms;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class AdventureCMD extends Command {

    public AdventureCMD() {
        super("adventure", "a", "gma");
    }


    @Override
    public int compareTo(@NotNull Command o) {
        return 0;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            RyUtil.sendConsoleMSG(true, "&c&l(!) &cThis command must be ran by a player.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(Perms.GAMEMODE) && !player.hasPermission(Perms.ADVENTURE)) {
            RyUtil.sendPlayerMSG(player, Messages.NO_PERMISSION
                    .replace("%perm%", Perms.GAMEMODE + " & " + Perms.ADVENTURE));
            return true;
        }

        if (args.length == 0) {
            RyUtil.sendPlayerMSG(player, Messages.CHANGED_GM
                    .replace("%gamemode%", Messages.ADVENTURE));
            player.setGameMode(GameMode.ADVENTURE);
            if (Config.HAS_OTHER_PLAYER_ENABLED) {
                RyUtil.sendPlayerMSG(player, Messages.CAN_CHANGE_OTHERS);
            }
            return true;
        } else if (args.length == 1) {
            if (!player.hasPermission(Perms.OTHERS)) {
                RyUtil.sendPlayerMSG(player, Messages.NO_PERMISSION
                        .replace("%perm%", Perms.OTHERS));
                return true;
            } else if (Bukkit.getPlayer(args[0]) == null) {
                RyUtil.sendPlayerMSG(player, Messages.INVALID_PLAYER);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            target.setGameMode(GameMode.ADVENTURE);
            RyUtil.sendPlayerMSG(player, Messages.CHANGED_OTHER
                    .replace("%target%", target.getName())
                    .replace("%gamemode%", Messages.ADVENTURE));
            return true;
        }

        return true;
    }
}
