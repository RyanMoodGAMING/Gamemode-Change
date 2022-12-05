package me.ryanmood.gamemodechange.config.cache;

import me.ryanmood.gamemodechange.config.Files;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

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
    public static String CAN_CHANGE_OTHERS;
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
        CAN_CHANGE_OTHERS = Files.getMessagesConfig().getString("othersMSG");
        ANTI_CREATIVE_ERROR = Files.getMessagesConfig().getString("antiCreativeError");
        NOTIFY = Files.getMessagesConfig().getString("notify.main");
        ANTI_CREATIVE_NOTIFY = Files.getMessagesConfig().getString("notify.antiCreative");

    }

}
