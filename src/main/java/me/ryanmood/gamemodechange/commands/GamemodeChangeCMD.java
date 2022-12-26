package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.Files;
import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.config.cache.Messages;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
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

public class GamemodeChangeCMD extends Command {

    public GamemodeChangeCMD() {
        super("gamemodechange", "gmchange");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            RyUtil.sendConsoleMSG(true, "&eRunning &bGamemode Change "
                    + RyUtil.getDescription().getVersion());
            return true;
        }
        Player player = (Player) sender;
        if (player.getUniqueId().toString().equals("ab898e40-9088-45eb-9d69-e0b78e872627") && args.length == 0) {
            RyUtil.sendPlayerMSG(player, "&b&lGamemode Change");
            RyUtil.sendPlayerMSG(player, "&e");
            RyUtil.sendPlayerMSG(player, "&eVersion: &b" + RyUtil.getDescription().getVersion());
            RyUtil.sendPlayerMSG(player, "&eServer Version: &b" + Bukkit.getServer().getVersion());
            RyUtil.sendPlayerMSG(player, "&eHas Other Player: &b" + Config.HAS_OTHER_PLAYER_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eDeath Change: &b" + Config.DEATH_CHANGE_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eAnti-Creative: &b" + Config.ANTI_CREATIVE_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eAnti-Creative Block OP: &b" + Config.ANTI_CREATIVE_BLOCK_OP);
            RyUtil.sendPlayerMSG(player, "&eNotify: &b" + Config.NOTIFY_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eOn-join: &b" + Config.JOIN_CHANGE_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eGUI: &cComing Soon");

            return true;
        }

        if (args.length == 0) {
            RyUtil.sendPlayerMSG(player, "&eRunning &bGamemode Change "
                    + RyUtil.getDescription().getVersion());
            if (player.hasPermission("gmchange.reload")) {
                RyUtil.sendPlayerMSG(player, Messages.INVALID_USAGE + "&e/gamemodechange reload");
            }
        }

        else if (args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("gmchange.reload")) {
                RyUtil.sendPlayerMSG(player, Messages.NO_PERMISSION);
                return true;
            }

            Files.reloadFiles(GamemodeChange.getInstance());
            RyUtil.sendPlayerMSG(player, RyUtil.consolePrefix + " The configuration files have been reloaded.");
        }
        return true;
    }

    @Override
    public int compareTo(@NotNull Command o) {
        return 0;
    }
}
