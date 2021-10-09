package com.itzilly.shortenedgamemodecommands.commands;

import com.itzilly.shortenedgamemodecommands.ShortenedGamemodeCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

import static org.bukkit.Bukkit.getLogger;


public class CreativeMode implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        //Change your own gamemode (the sender)
        if (sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;
            creativePlayerSelf(player);

            //Change other's gamemode (from sender to a target player)
        } else if (sender instanceof Player) {
            Player target = Bukkit.getPlayerExact(args[0]);
            Player player = (Player) sender;
            if (player.hasPermission("sgc.creative.others")) {
                //If the player sending the command types their own name after the command it will not send 2 messages
                if (player == target) {
                    player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");
                    player.setGameMode(GameMode.CREATIVE);
                } else { //This will tell the sender who's gamemode has been updated to what mode
                    player.sendMessage("You changed " + target.getDisplayName() + " into " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");  //Tell sender who's gamemode you changed
                    target.setGameMode(GameMode.CREATIVE);

                    //Check config.yml to see if the target player gets a message saying their gamemode has been updated
                    boolean targetSendMessage = ShortenedGamemodeCommands.plugin.getConfig().getBoolean("targetSendMessage");
                    if (targetSendMessage) {
                        target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");
                    }
                }
            }
        }

        if (sender instanceof ConsoleCommandSender && args.length == 0) { getLogger().info("Please specify a player"); } //Console but no target specified

        return false;
    }

    public void creativePlayerSelf(Player player) {

        if (player.getGameMode() == GameMode.CREATIVE) { getLogger().info("Player is already in Creative!");
        } else if (player.hasPermission("sgc.creative.self")) {
            player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");
            player.setGameMode(GameMode.CREATIVE);

        } else {
            player.sendMessage(ChatColor.RED + "Insufficient permissions!");
        }
    }
}