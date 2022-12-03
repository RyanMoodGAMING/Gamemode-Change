package me.ryanmood.gamemodechange.listeners;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.config.cache.Perms;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class ChangeGamemodeListener implements Listener {

    @EventHandler
    public void onCreative(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode newGamemode = event.getNewGameMode();

        if (Config.ANTI_CREATIVE_ENABLED && newGamemode == GameMode.CREATIVE) {
            if (!player.hasPermission(Perms.ANTI_CREATIVE_BYPASS)) {
                event.setCancelled(true);
                RyUtil.sendPlayerMSG(player, Config.ANTI_CREATIVE_ERROR
                        .replace("%perm%", Perms.ANTI_CREATIVE_BYPASS));
                RyUtil.sendBroadcast(player, Perms.ANTI_CREATIVE_NOTIFY, Config.ANTI_CREATIVE_NOTIFY);
            } else if (Config.ANTI_CREATIVE_BLOCK_OP && newGamemode == GameMode.CREATIVE
                    && player.isOp()
                    && !player.hasPermission(Perms.ANTI_CREATIVE_BYPASS)) {
                event.setCancelled(true);
                RyUtil.sendPlayerMSG(player, Config.ANTI_CREATIVE_ERROR
                        .replace("%perm%", Perms.ANTI_CREATIVE_BYPASS));
            }
        }
    }

    @EventHandler
    public void onGMChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode newGamemode = event.getNewGameMode();

        if (Config.NOTIFY_ENABLED && !player.hasPermission(Perms.NOTIFY_BYPASS)) {
            RyUtil.sendBroadcast(player, Perms.NOTIFY,
                    Config.NOTIFY_MESSAGE
                            .replace("%target%", player.getName())
                            .replace("%gamemode%", RyUtil.gamemodeToString(newGamemode)));
        }
    }

}
