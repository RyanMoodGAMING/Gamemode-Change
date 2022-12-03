package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.cache.Config;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamemodeChangeCMD extends Command {

    public GamemodeChangeCMD() {
        super("gamemodechange", "gmchange");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            RyUtil.sendConsoleMSG(true, "&eRunning &bGamemode Change "
                    + RyUtil.getDescription().getVersion());
            return true;
        }
        Player player = (Player) sender;
        if (player.getUniqueId().toString().equals("ab898e40-9088-45eb-9d69-e0b78e872627")) {
            RyUtil.sendPlayerMSG(player, "&b&lGamemode Change");
            RyUtil.sendPlayerMSG(player, "&e");
            RyUtil.sendPlayerMSG(player, "&eVersion: &b" + RyUtil.getDescription().getVersion());
            RyUtil.sendPlayerMSG(player, "&eServer Version: &b" + Bukkit.getServer().getVersion());
            RyUtil.sendPlayerMSG(player, "&eHas Other Player: &b" + Config.HAS_OTHER_PLAYER_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eDeath Change: &b" + Config.DEATH_CHANGE_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eAnti-Creative: &b" + Config.ANTI_CREATIVE_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eAnti-Creative Block OP: &b" + Config.ANTI_CREATIVE_BLOCK_OP);
            RyUtil.sendPlayerMSG(player, "&eNotify: &b" + Config.NOTIFY_ENABLED);
            RyUtil.sendPlayerMSG(player, "&eGUI: &cComing Soon");
            RyUtil.sendPlayerMSG(player, "&eOn-join: &cComing Soon");

            return true;
        }

        RyUtil.sendPlayerMSG(player, "&eRunning &bGamemode Change "
                + RyUtil.getDescription().getVersion());
        return true;
    }

    @Override
    public int compareTo(@NotNull Command o) {
        return 0;
    }
}
