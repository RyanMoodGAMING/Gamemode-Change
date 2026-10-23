package me.ryanmood.gamemodechange.config;

import lombok.Getter;
import lombok.Setter;
import me.ryanmood.ryutils.spigot.RyFile;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Messages {

    NO_PERMISSION("noPerm", "&c[!] You do not have permissions to do that. You need &b%perm%&c."),
    CHANGED_GAMEMODE("changedGM", "&a[!] Your gamemode has been changed to &b%gamemode%&a!"),
    CHANGED_OTHER("changedOther", "&a[!] You have changed &b%target%&a's gamemode to &b%gamemode%&a."),
    CREATIVE("creative", "CREATIVE"),
    SURVIVAL("survival", "SURVIVAL"),
    ADVENTURE("adventure", "ADVENTURE"),
    SPECTATOR("spectator", "SPECTATOR"),

    INVALID_PLAYER("invalidPlayer", "&c[!] The player provided is not found."),
    INVALID_USAGE("invalidUsage", "&c[!] Valid usage: &b%usage%"),
    INVALID_GAMEMODE("invalidGM", "&c[!] Invalid gamemode. Gamemodes: Creative, Survival, Adventure or Spectator."),
    ALREADY_GAMEMODE("alreadyGM", "&c[!] &b%target% gamemode is already that %gamemode%."),
    OTHERS("othersMSG", "&7[!] You can change other players gamemodes."),
    ANTI_CREATIVE_ERROR("antiCreativeError", "&c[!] You do not have permission to go into creative mode. You need the bypass permission (&b%perm%&c)."),
    NOTIFY_MAIN("notify.main", "&c[!] &b%player% &chas just changed there gamemode to &b%gamemode%&c."),
    NOTIFY_ANTICREATIVE("notify.antiCreative", "&c[!] &b%player% &chas been blocked from going into creative. They have been kept as %gamemode%."),

    END("", "");

    @Setter
    private static RyFile config;
    private String key;
    private String message;
    private List<String> messages;

    Messages(String key, String message) {
        this.key = key;
        this.message = message;
    }

    Messages(String key, String... messages) {
        this.key = key;
        this.messages = Arrays.asList(messages);
    }

    public String toString() {
        return config.getString(this.key, this.message);
    }

    public List<String> toStringList() {
        return config.getStringList(this.key, this.messages);
    }

    public static void loadMessagesFromConfig() {
        Arrays.stream(Messages.values()).forEach(message -> {
            if (config.getConfig().get(message.getKey()) == null) {
                if (message.getMessage() != null) config.getConfig().set(message.getKey(), message.getMessage());
                else if (message.getMessages() != null) config.getConfig().set(message.getKey(), message.getMessages());
            }
        });

        config.saveFile();
    }

}
