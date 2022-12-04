package me.ryanmood.gamemodechange.listeners;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.config.cache.Perms;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (Config.JOIN_CHANGE_ENABLED
                && !player.hasPermission(Perms.JOIN_BYPASS)) {
            player.setGameMode(RyUtil.intToGamemode(Config.JOIN_CHANGE_GAMEMODE));
        }
    }

}
