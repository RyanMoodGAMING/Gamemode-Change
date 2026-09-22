package me.ryanmood.gamemodechange.utils;

import lombok.Getter;
import lombok.Setter;
import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.Messages;
import me.ryanmood.ryutils.spigot.commands.RyCommand;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.List;

@Getter
public abstract class RyCMD extends RyCommand {

    private GamemodeChange plugin;
    @Setter
    private boolean playerOnly = false;
    @Setter
    private boolean async = false;
    @Setter
    private String permission = "";

    public RyCMD(GamemodeChange plugin, String name, String... aliases) {
        super(name, aliases);
        this.plugin = plugin;
    }


    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (this.isPlayerOnly() && !(sender instanceof Player)) {
            this.sendSender(sender, "&cOnly players can execute this command.");
            return true;
        }

        if (this.permission.isEmpty() && !sender.hasPermission(this.permission)) {
            this.sendSender(sender, Messages.NO_PERMISSION.toString().replace("%perm%", this.permission));
            return true;
        }

        CommandInfo info = new CommandInfo(sender, label, args);

        if (this.async) {
            this.getPlugin().getRySpigot().getTaskUtil().runAsync(() -> this.onExecute(info));
        } else {
            this.onExecute(info);
        }

        return true;
    }

    @Override
    public int compareTo(@NonNull RyCommand o) {
        return 0;
    }

    public abstract void onExecute(CommandInfo info);

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return this.onTabComplete(new CommandInfo(sender, null, args));
    }

    public abstract List<String> onTabComplete(CommandInfo info);

    public void sendPlayer(Player player, String message) {
        this.getPlugin().getMessageUtil().sendPlayer(player, message);
    }

    public void sendPlayer(Player player, String... messages) {
        this.getPlugin().getMessageUtil().sendPlayer(player, messages);
    }

    public void sendSender(CommandSender sender, String message) {
        this.getPlugin().getMessageUtil().sendSender(sender, message);
    }

    public void sendSender(CommandSender sender, String... messages) {
        this.getPlugin().getMessageUtil().sendSender(sender, messages);
    }

    public void changeGamemode(Player player, GameMode gamemode) {
        if (!player.hasPermission(this.getGamemodePerm(gamemode))) {
            this.sendPlayer(player, Messages.NO_PERMISSION.toString().replaceAll("%perm%", this.getGamemodePerm(gamemode)));
            return;
        }

        player.setGameMode(gamemode);
        this.sendPlayer(player, Messages.CHANGED_GAMEMODE.toString().replaceAll("%gamemode%", this.getGamemodeString(gamemode)));

        if (this.getPlugin().getConfiguration().isOTHER_PERMS_ENABLED()) {
            this.sendPlayer(player, Messages.OTHERS.toString());
        }

        return;
    }

    public void changeGamemode(Player target, Player player, GameMode gamemode) {
        if (!player.hasPermission(this.getGamemodePerm(gamemode))) {
            this.sendPlayer(player, Messages.NO_PERMISSION.toString().replaceAll("%perm%", this.getGamemodePerm(gamemode)));
            return;
        }

        target.setGameMode(gamemode);

        if (target == player) {
            this.sendPlayer(player, Messages.CHANGED_GAMEMODE.toString().replaceAll("%gamemode%", this.getGamemodeString(gamemode)));

            if (this.getPlugin().getConfiguration().isOTHER_PERMS_ENABLED()) {
                this.sendPlayer(player, Messages.OTHERS.toString());
            }
        } else if (target != player) this.sendPlayer(player, Messages.CHANGED_GAMEMODE.toString()
                .replaceAll("%target%", target.getName())
                .replaceAll("%gamemode%", this.getGamemodeString(gamemode)));

        return;
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

    private String getGamemodePerm(GameMode gamemode) {
        switch (gamemode.toString()) {
            case "CREATIVE":
                return this.getPlugin().getPermsConfig().getCREATIVE();
            case "SURVIVAL":
                return this.getPlugin().getPermsConfig().getSURVIVAL();
            case "ADVENTURE":
                return this.getPlugin().getPermsConfig().getADVENTURE();
            case "SPECTATOR":
                return this.getPlugin().getPermsConfig().getSPECTATOR();
        }

        return this.getPlugin().getPermsConfig().getGAMEMODE();
    }
}
