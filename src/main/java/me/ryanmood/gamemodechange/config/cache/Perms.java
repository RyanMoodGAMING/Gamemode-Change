package me.ryanmood.gamemodechange.config.cache;

import me.ryanmood.gamemodechange.config.Files;

public class Perms {

    // PERMISSIONS

    public static String GAMEMODE;
    public static String CREATIVE;
    public static String SURVIVAL;
    public static String ADVENTURE;
    public static String SPECTATOR;
    public static String OTHERS;
    public static String ANTI_CREATIVE_BYPASS;
    public static String NOTIFY;
    public static void loadConfig() {

        // PERMISSIONS

        GAMEMODE = Files.getPermsConfig().getString("gamemode");
        CREATIVE = Files.getPermsConfig().getString("creative");
        SURVIVAL = Files.getPermsConfig().getString("survival");
        ADVENTURE = Files.getPermsConfig().getString("adventure");
        SPECTATOR = Files.getPermsConfig().getString("spectator");
        OTHERS = Files.getPermsConfig().getString("others");
        ANTI_CREATIVE_BYPASS = Files.getPermsConfig().getString("anti_creative_bypass");
        NOTIFY = Files.getPermsConfig().getString("notify");

    }

}
