package me.ryanmood.gamemodechange.config;

import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.ryutils.spigot.RyFile;

import java.util.Arrays;

public class MessagesConfig extends RyFile {

    public MessagesConfig(GamemodeChange plugin) {
        super(plugin, "messages.yml");
    }

    /**
     * The cache of the config.
     */
    @Override
    public void loadConfig() {
        Messages.setConfig(this);
    }
}
