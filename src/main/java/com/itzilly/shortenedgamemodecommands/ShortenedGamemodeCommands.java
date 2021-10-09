package com.itzilly.shortenedgamemodecommands;

import com.itzilly.shortenedgamemodecommands.commands.CreativeMode;
import com.itzilly.shortenedgamemodecommands.commands.SurvivalMode;
import com.itzilly.shortenedgamemodecommands.commands.AdventureMode;
import com.itzilly.shortenedgamemodecommands.commands.SpectatorMode;
import com.itzilly.shortenedgamemodecommands.commands.Help;

import org.bukkit.plugin.java.JavaPlugin;


public final class ShortenedGamemodeCommands extends JavaPlugin {

    public static ShortenedGamemodeCommands plugin;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void onEnable() {

        plugin = this;
        getLogger().info(" " + ANSI_GREEN);
        getLogger().info("[ShortenedGamemodeCommands] Plugin has been enabled!");
        getLogger().info("[SGC] If there are any issues, please make sure you are up to date! Find a bug? Report it on the spigot page.");
        getLogger().info("[SGC] Use '/sgc help' to see list of commands");
        getLogger().info("Thank you to 'SirSpoodles' on SpigotMC for the code used for centering text in chat.");
        getLogger().info(" " + ANSI_RESET);

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();


        getCommand("gmc").setExecutor(new CreativeMode());
        getCommand("gms").setExecutor(new SurvivalMode());
        getCommand("gma").setExecutor(new AdventureMode());
        getCommand("gmsp").setExecutor(new SpectatorMode());
        getCommand("sgc").setExecutor(new Help());

    }



    @Override
    public void onDisable() {
//        getLogger().info("[ShortenedGamemodeCommands] Plugin has been disabled!");
    }


}
