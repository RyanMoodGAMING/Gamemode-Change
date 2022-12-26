package me.ryanmood.gamemodechange;

import me.ryanmood.gamemodechange.config.Files;
import me.ryanmood.gamemodechange.listeners.ChangeGamemodeListener;
import me.ryanmood.gamemodechange.listeners.DeathListener;
import me.ryanmood.gamemodechange.listeners.JoinListener;
import me.ryanmood.gamemodechange.utils.CommandManager;
import me.ryanmood.gamemodechange.utils.Metrics;
import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public final class GamemodeChange extends JavaPlugin {

    private static GamemodeChange instance;

    @Override
    public void onEnable() {
        int pluginId = 17187;
        Metrics metrics = new Metrics(this, 17187);
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
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
    }

    public static GamemodeChange getInstance() {
        return instance;
    }

}
