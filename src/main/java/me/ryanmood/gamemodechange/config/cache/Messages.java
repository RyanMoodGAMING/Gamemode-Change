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
    public static String INVALID_PLAYER;
    public static String INVALID_USAGE;
    public static String INVALID_GAMEMODE;
    public static String ANTI_CREATIVE_ERROR;
    public static String NOTIFY;
    public static String ANTI_CREATIVE_NOTIFY;

    public static void loadConfig() {

        NO_PERMISSION = Files.getMessagesConfig().getString("noPerm");
        CHANGED_GM = Files.getMessagesConfig().getString("changedGM");
        CHANGED_OTHER = Files.getMessagesConfig().getString("changedOther");
        CREATIVE = Files.getMessagesConfig().getString("creative");
        SURVIVAL = Files.getMessagesConfig().getString("survival");
        ADVENTURE = Files.getMessagesConfig().getString("adventure");
        SPECTATOR = Files.getMessagesConfig().getString("spectator");
        INVALID_PLAYER = Files.getMessagesConfig().getString("invalidPlayer");
        INVALID_USAGE = Files.getMessagesConfig().getString("invalidUsage");
        INVALID_GAMEMODE = Files.getMessagesConfig().getString("invalidGM");
        ANTI_CREATIVE_ERROR = Files.getMessagesConfig().getString("antiCreativeError");
        NOTIFY = Files.getMessagesConfig().getString("notify.main");
        ANTI_CREATIVE_NOTIFY = Files.getMessagesConfig().getString("notify.antiCreative");

    }

}
