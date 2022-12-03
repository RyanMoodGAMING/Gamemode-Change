package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.config.cache.Perms;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCMD extends Command {

    public GamemodeCMD() {
        super("gamemode", "gm");
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
        if (!player.hasPermission(Perms.GAMEMODE)) {
            RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                    .replace("%perm%", Perms.CREATIVE));
            return true;
        }

        if (args.length == 0) {
            RyUtil.sendPlayerMSG(player, Config.INVALID_USAGE
                    .replace("%usage%", "/gamemode <GameMode> (Player)"));
            return true;
        }

        if (args[0].equalsIgnoreCase("0")
                || args[0].equalsIgnoreCase("survival") ||
                args[0].equalsIgnoreCase("s")) {
            if (!player.hasPermission(Perms.SURVIVAL)) {
                RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                        .replace("%perm%", Perms.SURVIVAL));
                return true;
            }
            if (args.length == 2) {
               return changeTarget(args[1], player, GameMode.SURVIVAL);
            } else {
                return changePlayer(player, GameMode.SURVIVAL);
            }
        } else if (args[0].equalsIgnoreCase("1")
                || args[0].equalsIgnoreCase("creative") ||
                args[0].equalsIgnoreCase("c")) {
            if (!player.hasPermission(Perms.CREATIVE)) {
                RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                        .replace("%perm%", Perms.CREATIVE));
                return true;
            }
            if (args.length == 2) {
                return changeTarget(args[1], player, GameMode.CREATIVE);
            } else {
                return changePlayer(player, GameMode.CREATIVE);
            }
        } else if (args[0].equalsIgnoreCase("2")
                || args[0].equalsIgnoreCase("adventure") ||
                args[0].equalsIgnoreCase("a")) {
            if (!player.hasPermission(Perms.ADVENTURE)) {
                RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                        .replace("%perm%", Perms.ADVENTURE));
                return true;
            }
            if (args.length == 2) {
                return changeTarget(args[1], player, GameMode.ADVENTURE);
            } else {
                return changePlayer(player, GameMode.ADVENTURE);
            }
        } else if (args[0].equalsIgnoreCase("3")
                || args[0].equalsIgnoreCase("spectator") ||
                args[0].equalsIgnoreCase("sp")) {
            if (!player.hasPermission(Perms.SPECTATOR)) {
                RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                        .replace("%perm%", Perms.SPECTATOR));
                return true;
            }
            if (args.length == 2) {
                return changeTarget(args[1], player, GameMode.SPECTATOR);
            } else {
                return changePlayer(player, GameMode.SPECTATOR);
            }
        }

        return true;
    }

    private boolean changePlayer(Player player, GameMode gamemode) {
        player.setGameMode(gamemode);
        RyUtil.sendPlayerMSG(player, Config.GAMEMODE_CHANGED
                .replace("%gamemode%", RyUtil.gamemodeToString(gamemode)));
        return true;
    }
    private boolean changeTarget(String targetArg, Player player, GameMode gamemode) {
        if (!player.hasPermission(Perms.OTHERS)) {
            RyUtil.sendPlayerMSG(player, Config.NO_PERMISSION
                    .replace("%perm%", Perms.OTHERS));
            return true;
        } else if (Bukkit.getPlayer(targetArg) == null) {
            RyUtil.sendPlayerMSG(player, Config.PLAYER_NOT_FOUND);
            return true;
        }
        Player target = Bukkit.getPlayer(targetArg);
        target.setGameMode(gamemode);
        RyUtil.sendPlayerMSG(player, Config.OTHER_PLAYER
                .replace("%target%", target.getName())
                .replace("%gamemode%", RyUtil.gamemodeToString(gamemode)));
        return true;
    }

}
