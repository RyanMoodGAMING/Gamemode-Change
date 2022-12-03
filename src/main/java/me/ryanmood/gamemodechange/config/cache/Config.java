package me.ryanmood.gamemodechange.config.cache;

import me.ryanmood.gamemodechange.config.Files;

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
        ANTI_CREATIVE_ERROR = Files.getConfig().getString("anti_creative.error_msg");

        // Notify

        NOTIFY_ENABLED = Files.getConfig().getBoolean("notify.enabled");
        NOTIFY_MESSAGE = Files.getConfig().getString("notify.message");

    }

}
