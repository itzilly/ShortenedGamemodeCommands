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

public class gma implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        //Change your own gamemode (the sender)
        if (sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;
            adventurePlayerSelf(player);

            //Change other's gamemode (from sender to a target player)
        } else if (sender instanceof Player) {
            Player target = Bukkit.getPlayerExact(args[0]);
            Player player = (Player) sender;
            if (player.hasPermission("sgc.adventure.others")) {
                //If the player sending the command types their own name after the command it will not send 2 messages
                if (player == target) {
                    player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                    player.setGameMode(GameMode.ADVENTURE);
                } else { //This will tell the sender who's gamemode has been updated to what mode
                    player.sendMessage("You changed " + target.getDisplayName() + " into " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");  //Tell sender who's gamemode you changed
                    target.setGameMode(GameMode.ADVENTURE);

                    //Check config.yml to see if the target player gets a message saying their gamemode has been updated
                    boolean targetSendMessage = ShortenedGamemodeCommands.plugin.getConfig().getBoolean("targetSendMessage");
                    if (targetSendMessage) {
                        target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                    }
                }
            }
        }

        if (sender instanceof ConsoleCommandSender && args.length == 0) { System.out.println("Please specify a player"); } //Console but no target specified

        return false;
    }

    public void adventurePlayerSelf(Player player) {

        if (player.hasPermission("sgc.adventure.self")) {
            player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
            player.setGameMode(GameMode.ADVENTURE);

        } else {
            player.sendMessage(ChatColor.RED + "Insufficient permissions!");
        }
    }
}