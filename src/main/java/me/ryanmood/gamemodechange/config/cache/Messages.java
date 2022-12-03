package me.ryanmood.gamemodechange.config.cache;

import me.ryanmood.gamemodechange.config.Files;

import java.io.File;

public class Messages {

    public static String NO_PERMISSION;
    public static String CHANGED_GM;
    public static String CHANGED_OTHER;
    public static String CREATIVE;
    public static String SURVIVAL;
    public static String ADVENTURE;
    public static String SPECTATOR;
    public static String ANTI_CREATIVE_ERROR;
    public static String NOTIFY;

    public static void loadConfig() {

        NO_PERMISSION = Files.getMessagesConfig().getString("noPerm");
        CHANGED_GM = Files.getConfig().getString("changedGM");
        CHANGED_OTHER = Files.getConfig().getString("changedOther");
        CREATIVE = Files.getConfig().getString("creative");
        SURVIVAL = Files.getConfig().getString("survival");
        ADVENTURE = Files.getConfig().getString("ADVENTURE");
        SPECTATOR = Files.getConfig().getString("SPECTATOR");
        ANTI_CREATIVE_ERROR = Files.getConfig().getString("antiCreativeError");
        NOTIFY = Files.getConfig().getString("notify");

    }

}
