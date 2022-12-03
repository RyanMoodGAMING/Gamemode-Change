package me.ryanmood.gamemodechange.config.cache;

import me.ryanmood.gamemodechange.config.Files;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public class Perms {

    // PERMISSIONS

    public static String GAMEMODE;
    public static String CREATIVE;
    public static String SURVIVAL;
    public static String ADVENTURE;
    public static String SPECTATOR;
    public static String OTHERS;
    public static String ANTI_CREATIVE_BYPASS;
    public static String DEATH_BYPASS;
    public static String NOTIFY;
    public static void loadConfig() {

        // PERMISSIONS

        GAMEMODE = Files.getPermsConfig().getString("gamemode");
        CREATIVE = Files.getPermsConfig().getString("creative");
        SURVIVAL = Files.getPermsConfig().getString("survival");
        ADVENTURE = Files.getPermsConfig().getString("adventure");
        SPECTATOR = Files.getPermsConfig().getString("spectator");
        OTHERS = Files.getPermsConfig().getString("others");
        ANTI_CREATIVE_BYPASS = Files.getPermsConfig().getString("bypass.antiCreative");
        DEATH_BYPASS = Files.getPermsConfig().getString("bypass.death");
        NOTIFY = Files.getPermsConfig().getString("notify");

    }

}
