package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.config.cache.Perms;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpectatorCMD extends Command {

    public SpectatorCMD() {
        super("spectator", "sp", "gmsp");
    }


    @Override
    public int compareTo(@NotNull Command o) {
        return 0;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            RyUtil.sendConsoleMSG(true, "&c&l(!) &cThis command must be ran by a player.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(Perms.GAMEMODE) && !player.hasPermission(Perms.SPECTATOR)) {
            RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                    .replace("%perm%", Perms.GAMEMODE + " and " + Perms.SPECTATOR));
            return true;
        }

        if (args.length == 0) {
            RyUtil.sendPlayerMSG(player, Config.GAMEMODE_CHANGED
                    .replace("%gamemode%", Config.SPECTATOR));
            player.setGameMode(GameMode.SPECTATOR);
            if (Config.HAS_OTHER_PLAYER_ENABLED) {
                RyUtil.sendPlayerMSG(player, Config.HAS_OTHER_PLAYER_MSG);
            }
            return true;
        } else if (args.length == 1) {
            if (!player.hasPermission(Perms.OTHERS)) {
                RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                        .replace("%perm%", Perms.OTHERS));
                return true;
            } else if (Bukkit.getPlayer(args[0]) == null) {
                RyUtil.sendPlayerMSG(player, Config.PLAYER_NOT_FOUND);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            target.setGameMode(GameMode.SPECTATOR);
            RyUtil.sendPlayerMSG(player, Config.OTHER_PLAYER
                    .replace("%target%", target.getName())
                    .replace("%gamemode%", Config.SPECTATOR));
            return true;
        }

        return true;
    }
}
