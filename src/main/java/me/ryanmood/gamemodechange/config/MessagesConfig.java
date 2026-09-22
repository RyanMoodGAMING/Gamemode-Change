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
        Arrays.stream(Messages.values()).forEach(message -> {
           if (this.getString(message.getKey()) == null) {
               if (message.getMessage() != null) this.getConfig().set(message.getKey(), message.getMessage());
               else if (message.getMessages() != null) this.getConfig().set(message.getKey(), message.getMessages());
           }
        });

        this.saveFile();
    }
}
