package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.Messages;
import me.ryanmood.gamemodechange.utils.CommandInfo;
import me.ryanmood.gamemodechange.utils.RyCMD;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GamemodeCMD extends RyCMD {

    public GamemodeCMD(GamemodeChange plugin) {
        super(plugin, "gamemode", "gm");
        this.setPlayerOnly(true);
        this.setPermission(this.getPlugin().getPermsConfig().getGAMEMODE());
    }

    @Override
    public void onExecute(CommandInfo info) {
        Player player = info.getPlayer();
        String[] args = info.getArgs();

        if (args.length == 0) {
            this.sendPlayer(player, Messages.INVALID_USAGE.toString()
                    .replaceAll("%usage%", "/" + info.getLabel() + "<gamemode> (player)"));

            return;
        }
        Player target = player;

        if (args.length == 2 && player.hasPermission(this.getPlugin().getPermsConfig().getOTHERS())) {
            if (Bukkit.getPlayer(args[1]) == null) {
                this.sendPlayer(player, Messages.INVALID_USAGE.toString());
                return;
            } else target = Bukkit.getPlayer(args[1]);
        }

        switch (args[0].toLowerCase()) {
            case "survival":
            case "0":
            case "s":
                this.changeGamemode(target, player, GameMode.SURVIVAL);
                break;
            case "creative":
            case "1":
            case "c":
                this.changeGamemode(target, player, GameMode.CREATIVE);
                break;
            case "adventure":
            case "2":
            case "a":
                this.changeGamemode(target, player, GameMode.ADVENTURE);
                break;
            case "spectator":
            case "3":
            case "sp":
                this.changeGamemode(target, player, GameMode.SPECTATOR);
                break;
        }
    }

    @Override
    public List<String> onTabComplete(CommandInfo info) {
        List<String> completors = new ArrayList<>();

        switch (info.getArgs().length) {
            case 0:
                completors.add("creative");
                completors.add("1");
                completors.add("survival");
                completors.add("0");
                completors.add("adventure");
                completors.add("2");
                completors.add("spectator");
                completors.add("3");
                break;
            case 1:
                if (info.getSender().hasPermission(this.getPlugin().getPermsConfig().getOTHERS())) {
                    Bukkit.getOnlinePlayers().forEach(player -> completors.add(player.getName()));
                }
                break;
        }

        return completors;
    }
}
