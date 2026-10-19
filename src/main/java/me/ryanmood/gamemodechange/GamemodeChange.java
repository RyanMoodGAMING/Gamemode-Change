package me.ryanmood.gamemodechange;

import lombok.Getter;
import me.ryanmood.gamemodechange.commands.*;
import me.ryanmood.gamemodechange.config.Configuration;
import me.ryanmood.gamemodechange.config.MessagesConfig;
import me.ryanmood.gamemodechange.config.PermsConfig;
import me.ryanmood.gamemodechange.listeners.PlayerListener;
import me.ryanmood.ryutils.spigot.RyMessageUtil;
import me.ryanmood.ryutils.spigot.RySpigot;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class GamemodeChange extends JavaPlugin {

    private RySpigot rySpigot;
    private RyMessageUtil messageUtil;

    private Configuration configuration;
    private PermsConfig permsConfig;
    private MessagesConfig messageConfig;

    @Override
    public void onEnable() {
        this.rySpigot = new RySpigot(this, "&bGamemode Change &7» &f");
        this.messageUtil = this.rySpigot.getMessageUtil();

        this.messageUtil.sendConsole(true, "Loading Gamemode Change...");

        this.configuration = new Configuration(this);
        this.permsConfig = new PermsConfig(this);
        this.messageConfig = new MessagesConfig(this);

        this.getRySpigot().getCommandManager().register(
                new GamemodeChangeCMD(this),
                new CreativeCMD(this),
                new SurvivalCMD(this),
                new AdventureCMD(this)
        );

        if (!this.getServer().getVersion().contains("1.7")) {
            this.rySpigot.getCommandManager().register(new SpectatorCMD(this));
        }

        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        this.messageUtil.sendConsole(true, "&aSuccessfully loaded Gamemode Change");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
