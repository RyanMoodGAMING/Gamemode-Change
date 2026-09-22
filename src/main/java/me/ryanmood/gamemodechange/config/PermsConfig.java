package me.ryanmood.gamemodechange.config;

import lombok.Getter;
import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.ryutils.spigot.RyFile;

@Getter
public class PermsConfig extends RyFile {

    public PermsConfig(GamemodeChange plugin) {
        super(plugin, "perms.yml");
    }

    private String GAMEMODE;
    private String CREATIVE;
    private String SURVIVAL;
    private String ADVENTURE;
    private String SPECTATOR;
    private String OTHERS;

    private String BYPASS_ANTI_CREATIVE;
    private String BYPASS_DEATH;
    private String BYPASS_NOTIFY;
    private String BYPASS_JOIN_CHANGE;

    private String NOTIFY_MAIN;
    private String NOTIFY_ANTI_CREATIVE;

    /**
     * The cache of the config.
     */
    @Override
    public void loadConfig() {
        this.GAMEMODE = this.getString("gamemode", "gmchange.gamemode");
        this.CREATIVE = this.getString("creative", "gmchange.creative");
        this.SURVIVAL = this.getString("survival", "gmchange.survival");
        this.ADVENTURE = this.getString("adventure", "gmchange.adventure");
        this.SPECTATOR = this.getString("spectator", "gmchange.sepctator");
        this.OTHERS = this.getString("others", "gmchange.others");

        this.BYPASS_ANTI_CREATIVE = this.getString("bypass.antiCreative", "gmchange.bypass.anticreative");
        this.BYPASS_DEATH = this.getString("bypass.death", "gmchange.bypass.death");
        this.BYPASS_NOTIFY = this.getString("bypass.notify", "gmchange.bypass.notify");
        this.BYPASS_JOIN_CHANGE = this.getString("bypass.joinChange", "gmchange.bypass.join");

        this.NOTIFY_MAIN = this.getString("notify.main", "gmchange.notify");
        this.NOTIFY_ANTI_CREATIVE = this.getString("notify.antiCreative", "gmchange.notify.antiCreative");
    }
}
