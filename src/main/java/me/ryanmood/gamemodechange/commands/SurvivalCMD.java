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

public class SurvivalCMD extends Command {

    public SurvivalCMD() {
        super("survival", "s", "gms");
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
        if (!player.hasPermission(Perms.GAMEMODE) && !player.hasPermission(Perms.SURVIVAL)) {
            RyUtil.sendPlayerMSG(player, Messages.NO_PERMISSION
                    .replace("%perm%", Perms.GAMEMODE + " & " + Perms.SURVIVAL));
            return true;
        }

        if (args.length == 0) {
            if (Config.HAS_OTHER_PLAYER_ENABLED) {
                RyUtil.sendPlayerMSG(player, Messages.CAN_CHANGE_OTHERS);
            }
            return RyUtil.changePlayer(player, GameMode.SURVIVAL);
        } else if (args.length == 1) {
            return RyUtil.changeTarget(args[0], player, GameMode.SURVIVAL);
        }

        return true;
    }
}
