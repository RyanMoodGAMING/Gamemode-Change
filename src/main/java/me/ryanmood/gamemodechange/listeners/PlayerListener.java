package me.ryanmood.gamemodechange.listeners;

import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.Configuration;
import me.ryanmood.gamemodechange.config.Messages;
import me.ryanmood.gamemodechange.config.PermsConfig;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private GamemodeChange plugin;
    private Configuration config;
    private PermsConfig perms;

    public PlayerListener(GamemodeChange plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfiguration();
        this.perms = plugin.getPermsConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (this.config.isJOIN_CHANGE_ENABLED() && !player.hasPermission(this.perms.getBYPASS_JOIN_CHANGE())) {
            player.setGameMode(this.getGamemodeFromInt(this.config.getJOIN_CHANGE_GAMEMODE()));
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (event.getEntity().getType() != EntityType.PLAYER) return;
        Player player = event.getEntity();

        if (this.config.isDEATH_CHANGE_ENABLED() && !player.hasPermission(this.perms.getBYPASS_DEATH())) {
            player.setGameMode(this.getGamemodeFromInt(this.config.getDEATH_CHANGE_GAMEMODE()));
        }
    }

    @EventHandler
    public void notifyEvent(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode newGamemode = event.getNewGameMode();

        if (!this.config.isNOTIFY_ENABLED() && player.hasPermission(this.perms.getBYPASS_NOTIFY())) return;
        if (event.isCancelled()) return;

        switch (newGamemode) {
            case CREATIVE:
                if (!config.isNOTIFY_CREATIVE()) return;

                this.plugin.getMessageUtil().broadcast(player, this.perms.getNOTIFY_MAIN(), Messages.NOTIFY_MAIN.toString()
                        .replaceAll("%player%", player.getName())
                        .replaceAll("%gamemode%", Messages.CREATIVE.toString()));
                break;
            case SURVIVAL:
                if (!config.isNOTIFY_SURVIVAL()) return;

                this.plugin.getMessageUtil().broadcast(player, this.perms.getNOTIFY_MAIN(), Messages.NOTIFY_MAIN.toString()
                        .replaceAll("%player%", player.getName())
                        .replaceAll("%gamemode%", Messages.SURVIVAL.toString()));
                break;
            case ADVENTURE:
                if (!config.isNOTIFY_ADVENTURE()) return;

                this.plugin.getMessageUtil().broadcast(player, this.perms.getNOTIFY_MAIN(), Messages.NOTIFY_MAIN.toString()
                        .replaceAll("%player%", player.getName())
                        .replaceAll("%gamemode%", Messages.ADVENTURE.toString()));
                break;
            case SPECTATOR:
                if (!config.isNOTIFY_SPECTATOR()) return;

                this.plugin.getMessageUtil().broadcast(player, this.perms.getNOTIFY_MAIN(), Messages.NOTIFY_MAIN.toString()
                        .replaceAll("%player%", player.getName())
                        .replaceAll("%gamemode%", Messages.SPECTATOR.toString()));
                break;
        }
    }

    @EventHandler
    public void onCreative(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode newGamemode = event.getNewGameMode();
        boolean bypass = false;

        if (this.config.isANTI_CREATIVE_ENABLED()) return;
        if (newGamemode != GameMode.CREATIVE) return;
        if (this.config.isANTI_CREATIVE_BLOCK_OP() && player.isOp()) bypass = false;
        else bypass = true;
        if (!player.hasPermission(this.perms.getBYPASS_ANTI_CREATIVE())) bypass = false;
        else bypass = true;

        if (bypass) return;

        event.setCancelled(true);
        this.plugin.getMessageUtil().sendPlayer(player, Messages.ANTI_CREATIVE_ERROR.toString()
                .replaceAll("%perms%", this.perms.getBYPASS_ANTI_CREATIVE()));

        if (this.config.isNOTIFY_ENABLED()) this.plugin.getMessageUtil().broadcast(player, this.perms.getNOTIFY_ANTI_CREATIVE(),
                Messages.NOTIFY_ANTICREATIVE.toString()
                        .replaceAll("%player%", player.getName())
                        .replaceAll("%gamemode%", this.getGamemodeString(newGamemode)));
    }

    private GameMode getGamemodeFromInt(int input) {
        switch (input) {
            case 0:
                return GameMode.SURVIVAL;
            case 1:
                return GameMode.CREATIVE;
            case 2:
                return GameMode.ADVENTURE;
            case 3:
                return GameMode.SPECTATOR;
        }
        return GameMode.SURVIVAL;
    }

    private String getGamemodeString(GameMode gamemode) {
        switch (gamemode.toString()) {
            case "CREATIVE":
                return Messages.CREATIVE.toString();
            case "SURVIVAL":
                return Messages.SURVIVAL.toString();
            case "ADVENTURE":
                return Messages.ADVENTURE.toString();
            case "SPECTATOR":
                return Messages.SPECTATOR.toString();
        }

        return gamemode.toString();
    }

}
