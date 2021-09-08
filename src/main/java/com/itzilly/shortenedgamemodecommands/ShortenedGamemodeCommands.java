package com.itzilly.shortenedgamemodecommands;

import org.bukkit.plugin.java.JavaPlugin;

public final class ShortenedGamemodeCommands extends JavaPlugin {

    public static ShortenedGamemodeCommands plugin;



    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;
        System.out.println("[ShortenedGamemodeCommands] Plugin has been enabled!");
        System.out.println("[ShortenedGamemodeCommands] If there are any issues, please make sure you are up to date!");
        System.out.println("[ShortenedGamemodeCommands] Find a bug? Report it on the spigot page, or ");

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("gmc").setExecutor(new GameModeCreative());
        getCommand("gms").setExecutor(new GameModeSurvival());
        getCommand("gmsp").setExecutor(new GameModeSpectator());
        getCommand("gma").setExecutor(new GameModeAdventure());

    }



    @Override
    public void onDisable() {
        //Plugin shutdown logic
        System.out.println("[ShortenedGamemodeCommands] Plugin has been disabled!");
    }


}
