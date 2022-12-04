package me.ryanmood.gamemodechange.config.cache;

import me.ryanmood.gamemodechange.config.Files;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class Config {

    // Messages

    public static String GAMEMODE_CHANGED;
    public static String NO_PERMISSION;
    public static String CREATIVE;
    public static String SURVIVAL;
    public static String ADVENTURE;
    public static String SPECTATOR;
    public static String OTHER_PLAYER;
    public static String PLAYER_NOT_FOUND;
    public static String INVALID_USAGE;
    public static String INVALID_GAMEMODE;

    // Has Other Player Perm Message

    public static Boolean HAS_OTHER_PLAYER_ENABLED;
    public static String HAS_OTHER_PLAYER_MSG;

    // Death Change

    public static Boolean DEATH_CHANGE_ENABLED;
    public static int DEATH_CHANGE_GAMEMODE;

    // Anti-Creative

    public static Boolean ANTI_CREATIVE_ENABLED;
    public static Boolean ANTI_CREATIVE_BLOCK_OP;
    public static String ANTI_CREATIVE_ERROR;
    public static String ANTI_CREATIVE_NOTIFY;

    // Notify

    public static Boolean NOTIFY_ENABLED;
    public static String NOTIFY_MESSAGE;
    public static Boolean NOTIFY_CREATIVE;
    public static Boolean NOTIFY_SURVIVAL;
    public static Boolean NOTIFY_ADVENTURE;
    public static Boolean NOTIFY_SPECTATOR;

    // JOIN CHANGE

    public static boolean JOIN_CHANGE_ENABLED;
    public static int JOIN_CHANGE_GAMEMODE;

    public static void loadConfig() {

        // MESSAGES

        GAMEMODE_CHANGED = Files.getConfig().getString("gmChanged");
        NO_PERMISSION = Files.getConfig().getString("noPerm");
        CREATIVE = Files.getConfig().getString("creative");
        SURVIVAL = Files.getConfig().getString("survival");
        ADVENTURE = Files.getConfig().getString("adventure");
        SPECTATOR = Files.getConfig().getString("spectator");
        OTHER_PLAYER = Files.getConfig().getString("otherChanged");
        PLAYER_NOT_FOUND = Files.getConfig().getString("notFoundMSG");
        INVALID_USAGE = Files.getConfig().getString("invalidUsageMSG");
        INVALID_GAMEMODE = Files.getConfig().getString("invalidGMMSG");

        // Has Other Player Perm Message

        HAS_OTHER_PLAYER_ENABLED = Files.getConfig().getBoolean("hasOtherPermsMSG.enabled");
        HAS_OTHER_PLAYER_MSG = Files.getConfig().getString("hasOtherPermsMSG.message");

        // Death Change

        DEATH_CHANGE_ENABLED = Files.getConfig().getBoolean("deathChange.enabled");
        DEATH_CHANGE_GAMEMODE = Files.getConfig().getInt("deathChange.gamemode");

        // Anti-Creative

        ANTI_CREATIVE_ENABLED = Files.getConfig().getBoolean("antiCreative.enabled");
        ANTI_CREATIVE_BLOCK_OP = Files.getConfig().getBoolean("antiCreative.blockOP");
        ANTI_CREATIVE_ERROR = Files.getConfig().getString("antiCreative.errorMSG");
        ANTI_CREATIVE_NOTIFY = Files.getConfig().getString("antiCreative.notifyMSG");

        // Notify

        NOTIFY_ENABLED = Files.getConfig().getBoolean("notify.enabled");
        NOTIFY_MESSAGE = Files.getConfig().getString("notify.message");
        NOTIFY_CREATIVE = Files.getConfig().getBoolean("notify.gamemodes.creative");
        NOTIFY_SURVIVAL = Files.getConfig().getBoolean("notify.gamemodes.survival");
        NOTIFY_SPECTATOR = Files.getConfig().getBoolean("notify.gamemodes.spectator");
        NOTIFY_ADVENTURE = Files.getConfig().getBoolean("notify.gamemodes.adventure");

        // Join Change

        JOIN_CHANGE_ENABLED = Files.getConfig().getBoolean("joinChange.enabled");
        JOIN_CHANGE_GAMEMODE = Files.getConfig().getInt("joinChange.gamemode");

    }

}
