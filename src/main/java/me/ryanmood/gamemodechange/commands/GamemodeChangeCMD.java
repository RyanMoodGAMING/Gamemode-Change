package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.Messages;
import me.ryanmood.gamemodechange.utils.CommandInfo;
import me.ryanmood.gamemodechange.utils.RyCMD;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class GamemodeChangeCMD extends RyCMD {

    public GamemodeChangeCMD(GamemodeChange plugin) {
        super(plugin, "gamemodechange", "gmchange");
    }

    @Override
    public void onExecute(CommandInfo info) {
        CommandSender sender = info.getSender();
        String[] args = info.getArgs();

        if (args.length == 0) {
            this.sendSender(sender, "&eRunning &bGamemode Change " + this.getPlugin().getDescription().getVersion());

            if (info.isPlayer()) {
                if (info.getPlayer().getUniqueId().equals("ab898e40-9088-45eb-9d69-e0b78e872627")) this.sendSender(sender,
                        "&b&lGamemode Change",
                        "&e",
                        "&eVersion: &b" + this.getPlugin().getDescription().getVersion(),
                        "&eServer Version: &b" + Bukkit.getServer().getVersion(),
                        "&eHas Other Player: &b" + this.getPlugin().getConfiguration().isOTHER_PERMS_ENABLED(),
                        "&eDeath Change: &b" + this.getPlugin().getConfiguration().isDEATH_CHANGE_ENABLED(),
                        "&eAnti-Creative: &b" + this.getPlugin().getConfiguration().isANTI_CREATIVE_ENABLED(),
                        "&eAnti-Creative Block OP: &b" + this.getPlugin().getConfiguration().isANTI_CREATIVE_BLOCK_OP(),
                        "&eNotify: &b" + this.getPlugin().getConfiguration().isNOTIFY_ENABLED(),
                        "&eOn-join: &b" + this.getPlugin().getConfiguration().isJOIN_CHANGE_ENABLED(),
                        "&e",
                        "&b&lGamemode Change"
                );
            }
            return;
        }

        switch (args[0]) {
            case "reload":
                if (!sender.hasPermission("gmchange.reload")) {
                    this.sendSender(sender, Messages.NO_PERMISSION.toString().replaceAll("%perm%", "gmchange.reload"));
                    return;
                }

                this.getPlugin().getConfiguration().reloadFile();
                this.getPlugin().getMessageConfig().reloadFile();
                this.getPlugin().getPermsConfig().reloadFile();
                this.sendSender(sender, "%prefix% &aThe configuration files have been reloaded.");
                return;
            default:
                this.sendSender(sender, Messages.INVALID_USAGE.toString().replaceAll("%usage%", "/" + info.getLabel() + " reload"));
                return;
        }
    }

    @Override
    public List<String> onTabComplete(CommandInfo info) {
        List<String> completors = new ArrayList<>();

        switch (info.getArgs().length) {
            case 0:
                if (info.getSender().hasPermission("gmchange.reload")) {
                    completors.add("reload");
                }
        }

        return completors;
    }
}
