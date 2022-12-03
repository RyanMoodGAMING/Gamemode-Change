package me.ryanmood.gamemodechange;

import me.ryanmood.gamemodechange.config.Files;
import me.ryanmood.gamemodechange.listeners.ChangeGamemodeListener;
import me.ryanmood.gamemodechange.listeners.DeathListener;
import me.ryanmood.gamemodechange.utils.CommandManager;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class GamemodeChange extends JavaPlugin {

    private static GamemodeChange instance;

    @Override
    public void onEnable() {
        instance = this;

        RyUtil.sendConsoleMSG(true, "&eLoading Gamemode Change...");
        RyUtil.sendConsoleMSG(true, "&eLoading commands...");
        CommandManager.registerAll();
        RyUtil.sendConsoleMSG(true, "&eLoading events...");
        loadListeners();
        RyUtil.sendConsoleMSG(true, "&eLoading config.yml...");
        RyUtil.sendConsoleMSG(true, "&eLoading perms.yml...");
        Files.loadFiles(this);
        RyUtil.sendConsoleMSG(true, "&eLoaded Gamemode Change");
        RyUtil.sendConsoleMSG(true, "&eFor support please join my discord @ https://discord.gg/6QNEGPK3Fb");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadListeners() {
        Bukkit.getPluginManager().registerEvents(new ChangeGamemodeListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
    }

    public static GamemodeChange getInstance() {
        return instance;
    }

}
