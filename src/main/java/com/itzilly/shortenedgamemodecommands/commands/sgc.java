package com.itzilly.shortenedgamemodecommands.commands;

//import com.itzilly.shortenedgamemodecommands.ShortenedGamemodeCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
//import org.bukkit.CommandExecutor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




//This is the help page for ShortenedGamemodeCommands

public class sgc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;

            helpList(player);

        }

        return false;
    }

    public void helpList(Player player) {
        player.sendMessage(ChatColor.GREEN + "&m--------------------" +
                ">" + ChatColor.GREEN + "" + ChatColor.BOLD + "SGC Help" + "/n" +
                "" + "/n" +
                "" + "/n" +
                "" + "/n" +
                "");

    }

}
