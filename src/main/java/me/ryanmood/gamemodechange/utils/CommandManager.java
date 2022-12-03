package me.ryanmood.gamemodechange.utils;

import me.ryanmood.gamemodechange.commands.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CommandManager {

    private static Set<Command> commands = new HashSet<>();

    public static void registerAll(){
        commands.addAll(Arrays.asList(
                new GamemodeChangeCMD()
        ));
    }

    public static void register(Command... command){
        commands.addAll(Arrays.asList(command));
    }

    public static Optional<Command> byCommand(String command){
        return commands.stream().filter(all -> {
            if(all.getName().equalsIgnoreCase(command)){
                return true;
            }else{
                for(String alias : all.getNameList()){
                    if(alias.equalsIgnoreCase(command)){
                        return true;
                    }
                }
                return false;
            }
        }).findFirst();
    }

}
