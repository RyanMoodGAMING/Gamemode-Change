package me.ryanmood.gamemodechange.listeners;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.config.cache.Perms;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class ChangeGamemodeListener implements Listener {

    @EventHandler
    public void onCreative(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode newGamemode = event.getNewGameMode();

        if (Config.ANTI_CREATIVE_ENABLED && newGamemode == GameMode.CREATIVE) {
            if (!player.hasPermission(Perms.ANTI_CREATIVE_BYPASS)) {
                event.setCancelled(true);
                RyUtil.sendPlayerMSG(player, Config.ANTI_CREATIVE_ERROR);
            }
        }
    }

    @EventHandler
    public void onGMChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode newGamemode = event.getNewGameMode();

        if (Config.NOTIFY_ENABLED) {
            RyUtil.sendBroadcastPerm(player, Perms.NOTIFY,
                    Config.NOTIFY_MESSAGE
                            .replace("%target%", player.getName())
                            .replace("%gamemode%", RyUtil.gamemodeToString(newGamemode)));
        }
    }

}
