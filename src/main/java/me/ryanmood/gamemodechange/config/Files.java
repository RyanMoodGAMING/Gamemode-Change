package me.ryanmood.gamemodechange.config;

import me.ryanmood.gamemodechange.GamemodeChange;
import me.ryanmood.gamemodechange.config.cache.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Files {

    private static File configFile;
    private static FileConfiguration config;
    private static File permsFile;
    private static FileConfiguration permsConfig;

    public static void loadFiles(GamemodeChange gamemodeChange) {
        if (!gamemodeChange.getDataFolder().exists()) {
            gamemodeChange.getDataFolder().mkdirs();
        }

        configFile = new File(gamemodeChange.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            gamemodeChange.saveResource("config.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);

        Config.loadConfig();

        permsFile = new File(gamemodeChange.getDataFolder(), "perms.yml");
        if (!permsFile.exists()) {
            gamemodeChange.saveResource("perms.yml", false);
        }
        permsConfig = YamlConfiguration.loadConfiguration(permsFile);

        Perms.loadConfig();
    }

        public static FileConfiguration getConfig() {
            return config;
        }

        public static FileConfiguration getPermsConfig() {
            return permsConfig;
        }

        public static void saveFiles() {
            try {
                permsConfig.save(permsFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void reloadFiles(GamemodeChange gamemodeChange) {
            configFile = new File(gamemodeChange.getDataFolder(), "config.yml");
            try {
                config = YamlConfiguration.loadConfiguration(configFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Config.loadConfig();

            permsFile = new File(gamemodeChange.getDataFolder(), "perms.yml");
            try {
                permsConfig = YamlConfiguration.loadConfiguration(permsFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Perms.loadConfig();
        }

}
