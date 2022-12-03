package me.ryanmood.gamemodechange.commands;

import me.ryanmood.gamemodechange.utils.RyUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

import java.lang.reflect.Field;
import java.util.*;

/*
 * This software and its content is copyright of RyanMoodGAMING - © RyanMoodGAMING 2022. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is prohibited other than the following:
 * you may print or download to a local hard disk extracts for your personal and non-commercial use only
 * you may copy the content to individual third parties for their personal use, but only if you acknowledge the website as the source of the material
 * You may not, except with our express written permission, distribute or commercially exploit the content. Nor may you transmit it or store it in any other website or other form of electronic retrieval system.
 */

public abstract class Command extends org.bukkit.command.Command implements Comparable<Command>, Executable {

        private final String name;
        private final Set<String> aliases;
        private String usage;
        private int argsLength;


        public Command(String name, String... aliases) {
            this(0, "", name, aliases);
        }

        public Command(int argsLength, String usage, String name, String... aliases) {
            super(name, "", usage, Arrays.asList(aliases));

            this.name = name;
            this.argsLength = argsLength;
            this.usage = RyUtil.translate(null, usage);

            this.aliases = new HashSet<>();
            this.aliases.add(name);
            Collections.addAll(this.aliases, aliases);

            registerBukkitCommand(aliases);
        }

        private void registerBukkitCommand(String[] aliases) {
            try {
                final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                bukkitCommandMap.setAccessible(true);
                CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
                commandMap.register("command", this);
                for (String alias : aliases) {
                    commandMap.register(alias, "command", this);
                }
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException exception) {
                RyUtil.sendConsoleMSG(false, "&c&lERROR - &rcould not register a command properly (name: " + this.name + "), stacktrace: ");
            }
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getUsage() {
            return this.usage;
        }

        @Override
        public int getArgsLength() {
            return this.argsLength;
        }

        @Override
        public Set<String> getNameList() {
            return this.aliases;
        }

        @Override
        public boolean hasUsage() {
            return !this.usage.isEmpty();
        }

        @Override
        public Command setArgsLength(int argsLength) {
            this.argsLength = argsLength;
            return this;
        }

        @Override
        public Command setUsage(String usage) {
            this.usage = RyUtil.translate(null, usage);
            return this;
        }


}
