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

    // Notify

    public static Boolean NOTIFY_ENABLED;
    public static String NOTIFY_MESSAGE;

    public static void loadConfig() {

        // MESSAGES

        GAMEMODE_CHANGED = Files.getConfig().getString("gm_changed_msg");
        NO_PERMISSION = Files.getConfig().getString("no_permission_msg");
        CREATIVE = Files.getConfig().getString("CREATIVE");
        SURVIVAL = Files.getConfig().getString("SURVIVAL");
        ADVENTURE = Files.getConfig().getString("ADVENTURE");
        SPECTATOR = Files.getConfig().getString("SPECTATOR");
        OTHER_PLAYER = Files.getConfig().getString("other_player_msg");
        PLAYER_NOT_FOUND = Files.getConfig().getString("player_not_found_msg");
        INVALID_USAGE = Files.getConfig().getString("invalid_usage_msg");
        INVALID_GAMEMODE = Files.getConfig().getString("invalid_gamemode_msg");

        // Has Other Player Perm Message

        HAS_OTHER_PLAYER_ENABLED = Files.getConfig().getBoolean("has_other_players_perm.enabled");
        HAS_OTHER_PLAYER_MSG = Files.getConfig().getString("has_other_players_perm.message");

        // Death Change

        DEATH_CHANGE_ENABLED = Files.getConfig().getBoolean("death_change.enabled");
        DEATH_CHANGE_GAMEMODE = Files.getConfig().getInt("death_change.gamemode");

        // Anti-Creative

        ANTI_CREATIVE_ENABLED = Files.getConfig().getBoolean("anti_creative.enabled");
        ANTI_CREATIVE_BLOCK_OP = Files.getConfig().getBoolean("anti_creative.block_op");
        ANTI_CREATIVE_ERROR = Files.getConfig().getString("anti_creative.error_msg");

        // Notify

        NOTIFY_ENABLED = Files.getConfig().getBoolean("notify.enabled");
        NOTIFY_MESSAGE = Files.getConfig().getString("notify.message");

    }

}
