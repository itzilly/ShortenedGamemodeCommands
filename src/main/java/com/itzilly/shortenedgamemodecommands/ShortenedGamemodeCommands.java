package com.itzilly.shortenedgamemodecommands;

import com.itzilly.shortenedgamemodecommands.commands.gmc;
import com.itzilly.shortenedgamemodecommands.commands.gms;
import com.itzilly.shortenedgamemodecommands.commands.gma;
import com.itzilly.shortenedgamemodecommands.commands.gmsp;
import com.itzilly.shortenedgamemodecommands.commands.sgc;


import org.bukkit.plugin.java.JavaPlugin;

public final class ShortenedGamemodeCommands extends JavaPlugin {

    public static ShortenedGamemodeCommands plugin;



    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;
        System.out.println("[ShortenedGamemodeCommands] Plugin has been enabled!");
        System.out.println("[SGC] If there are any issues, please make sure you are up to date! Find a bug? Report it on the spigot page.");
        System.out.println("[SGC] Use '/sgc help' to see list of commands");

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();



        getCommand("gmc").setExecutor(new gmc());
        getCommand("gms").setExecutor(new gms());
        getCommand("gma").setExecutor(new gma());
        getCommand("gmsp").setExecutor(new gmsp());
        getCommand("sgc").setExecutor(new sgc());


    }



    @Override
    public void onDisable() {
        //Plugin shutdown logic
        System.out.println("[ShortenedGamemodeCommands] Plugin has been disabled!");
    }


}
