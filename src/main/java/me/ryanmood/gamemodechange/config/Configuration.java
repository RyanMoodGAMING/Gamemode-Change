package me.ryanmood.gamemodechange.config;

import lombok.Getter;
import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.ryutils.spigot.RyFile;

@Getter
public class Configuration extends RyFile {

    public Configuration(GamemodeChange plugin) {
        super(plugin, "config.yml");
    }

    private boolean JOIN_CHANGE_ENABLED;
    private int JOIN_CHANGE_GAMEMODE;

    private boolean ANTI_CREATIVE_ENABLED;
    private boolean ANTI_CREATIVE_BLOCK_OP;

    private boolean NOTIFY_ENABLED;
    private boolean NOTIFY_CREATIVE;
    private boolean NOTIFY_SURVIVAL;
    private boolean NOTIFY_ADVENTURE;
    private boolean NOTIFY_SPECTATOR;

    private boolean DEATH_CHANGE_ENABLED;
    private int DEATH_CHANGE_GAMEMODE;

    private boolean OTHER_PERMS_ENABLED;

    /**
     * The cache of the config.
     */
    @Override
    public void loadConfig() {
        JOIN_CHANGE_ENABLED = getConfig().getBoolean("joinChange.enabled");
        JOIN_CHANGE_GAMEMODE = getConfig().getInt("joinChange.gamemode");

        ANTI_CREATIVE_ENABLED = getConfig().getBoolean("antiCreative.enabled");
        ANTI_CREATIVE_BLOCK_OP = getConfig().getBoolean("antiCreative.blockOp");

        NOTIFY_ENABLED = getConfig().getBoolean("notify.enabled");
        NOTIFY_CREATIVE = getConfig().getBoolean("notify.creative");
        NOTIFY_SURVIVAL = getConfig().getBoolean("notify.survival");
        NOTIFY_ADVENTURE = getConfig().getBoolean("notify.adventure");
        NOTIFY_SPECTATOR = getConfig().getBoolean("notify.spectator");

        DEATH_CHANGE_ENABLED = getConfig().getBoolean("deathChange.enabled");
        DEATH_CHANGE_GAMEMODE = getConfig().getInt("deathChange.gamemode");

        OTHER_PERMS_ENABLED = getConfig().getBoolean("hasOtherPermsMSG");
    }
}
