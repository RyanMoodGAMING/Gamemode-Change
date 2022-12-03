package me.ryanmood.gamemodechange.listeners;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

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
