package me.ryanmood.gamemodechange.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@Getter
public class CommandInfo {

    private final CommandSender sender;
    private final String label;
    private final String[] args;

    public int length() { return this.args.length; }

    public boolean isPlayer() {
        return this.sender instanceof Player;
    }

    public boolean isConsole() {
        return this.sender instanceof ConsoleCommandSender;
    }

    public Player getPlayer() {
        if (!(sender instanceof Player)) return null;
        else return (Player) sender;
    }
}
