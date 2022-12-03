package me.ryanmood.gamemodechange.listeners;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (!(event.getEntity().getType() == EntityType.PLAYER)) {
            return;
        }
        Player player = event.getEntity();

        if (Config.DEATH_CHANGE_ENABLED) {
            player.setGameMode(RyUtil.intToGamemode(Config.DEATH_CHANGE_GAMEMODE));
        }
    }

}
