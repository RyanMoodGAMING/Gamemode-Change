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

    // Has Other Player Perm Message

    public static Boolean HAS_OTHER_PLAYER_ENABLED;

    // Death Change

    public static Boolean DEATH_CHANGE_ENABLED;
    public static int DEATH_CHANGE_GAMEMODE;

    // Anti-Creative

    public static Boolean ANTI_CREATIVE_ENABLED;
    public static Boolean ANTI_CREATIVE_BLOCK_OP;

    // Notify

    public static Boolean NOTIFY_ENABLED;
    public static Boolean NOTIFY_CREATIVE;
    public static Boolean NOTIFY_SURVIVAL;
    public static Boolean NOTIFY_ADVENTURE;
    public static Boolean NOTIFY_SPECTATOR;

    // JOIN CHANGE

    public static boolean JOIN_CHANGE_ENABLED;
    public static int JOIN_CHANGE_GAMEMODE;

    public static void loadConfig() {

        // Has Other Player Perm Message

        HAS_OTHER_PLAYER_ENABLED = Files.getConfig().getBoolean("hasOtherPermsMSG");

        // Death Change

        DEATH_CHANGE_ENABLED = Files.getConfig().getBoolean("deathChange.enabled");
        DEATH_CHANGE_GAMEMODE = Files.getConfig().getInt("deathChange.gamemode");

        // Anti-Creative

        ANTI_CREATIVE_ENABLED = Files.getConfig().getBoolean("antiCreative.enabled");
        ANTI_CREATIVE_BLOCK_OP = Files.getConfig().getBoolean("antiCreative.blockOP");

        // Notify

        NOTIFY_ENABLED = Files.getConfig().getBoolean("notify.enabled");
        NOTIFY_CREATIVE = Files.getConfig().getBoolean("notify.gamemodes.creative");
        NOTIFY_SURVIVAL = Files.getConfig().getBoolean("notify.gamemodes.survival");
        NOTIFY_SPECTATOR = Files.getConfig().getBoolean("notify.gamemodes.spectator");
        NOTIFY_ADVENTURE = Files.getConfig().getBoolean("notify.gamemodes.adventure");

        // Join Change

        JOIN_CHANGE_ENABLED = Files.getConfig().getBoolean("joinChange.enabled");
        JOIN_CHANGE_GAMEMODE = Files.getConfig().getInt("joinChange.gamemode");

    }

}
