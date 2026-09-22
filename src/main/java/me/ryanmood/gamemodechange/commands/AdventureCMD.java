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

public class AdventureCMD extends RyCMD {

    public AdventureCMD(GamemodeChange plugin) {
        super(plugin, "adventure", "gma", "a");
        this.setPlayerOnly(true);
        this.setPermission(this.getPlugin().getPermsConfig().getADVENTURE());
    }

    @Override
    public void onExecute(CommandInfo info) {
        Player player = info.getPlayer();
        String[] args = info.getArgs();
        Player target = player;

        if (args.length == 1 && player.hasPermission(this.getPlugin().getPermsConfig().getOTHERS())) {
            if (Bukkit.getPlayer(args[0]) == null) {
                this.sendPlayer(player, Messages.INVALID_USAGE.toString());
                return;
            } else target = Bukkit.getPlayer(args[0]);
        }

        this.changeGamemode(target, player, GameMode.ADVENTURE);
    }

    @Override
    public List<String> onTabComplete(CommandInfo info) {
        List<String> completors = new ArrayList<>();

        switch (info.getArgs().length) {
            case 0:
                if (info.getSender().hasPermission(this.getPlugin().getPermsConfig().getOTHERS())) {
                    Bukkit.getOnlinePlayers().forEach(player -> completors.add(player.getName()));
                }
                break;
        }

        return completors;
    }
}
