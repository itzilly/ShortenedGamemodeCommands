package com.itzilly.shortenedgamemodecommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class GameModeAdventure implements CommandExecutor {

    FileConfiguration config = ShortenedGamemodeCommands.plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command GMCcmd, String label, String[] args) {

        //Player update to creative mod
        if (sender instanceof Player) { //Player vs Console check   player below
            Player player = (Player) sender;

            if (args.length == 0) {  //No words after initial command
                if (player.hasPermission("sgc.self.adventure")) { //Permission check

                    adventureUpdatePlayerSelf(player); //Success!

                } else {
                    noPermsError(player); //Permission Check FAIL
                }
            } else if (args.length != 0) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (player.hasPermission("sgc.others.adventure")) {

                    player.sendMessage("You changed " + target.getDisplayName() + " into " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                    target.setGameMode(GameMode.ADVENTURE);


                    boolean targetSendMessage = ShortenedGamemodeCommands.plugin.getConfig().getBoolean("targetSendMessage");
                    if (targetSendMessage = true) {
                        target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                    }

                }

            } else {
                System.out.println("[SGC] Error, please specify player!"); //Console command with no args
                System.out.println("[SGC] Target player MUST be online!"); //Console command with no args
            }
        } else if (sender instanceof ConsoleCommandSender) {

        }
        return false;
    }

    public void adventureUpdatePlayerSelf (Player player) {

        player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
        player.setGameMode(GameMode.ADVENTURE);

    }

    //No permissions error message
    public void noPermsError (Player player) {
        player.sendMessage(ChatColor.RED + "Insufficient permissions!");
    }

}