package com.itzilly.shortenedgamemodecommands.commands;

import com.itzilly.shortenedgamemodecommands.utilz.CenteredTextUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import static org.bukkit.Bukkit.getLogger;

public class Help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            TextComponent webString = new TextComponent("\n");

            TextComponent websiteLinkMessage = new TextComponent("Permission nodes/More help");
            websiteLinkMessage.setColor(net.md_5.bungee.api.ChatColor.GRAY);

            TextComponent webLink = new TextComponent(" Visit my website.");
            webLink.setColor(net.md_5.bungee.api.ChatColor.RED);
            webLink.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("itzilly.com").create()));
            webLink.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.itzilly.com/plugins/sgc"));

            webString.addExtra(websiteLinkMessage);
            websiteLinkMessage.addExtra(webLink);



            player.sendMessage(ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------");
            CenteredTextUtils.sendCenteredMessage(player, ChatColor.BOLD + "" + ChatColor.GREEN + "" + ChatColor.BOLD + "Shortened Gamemode Commands Help Page");
            player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "" + "\nCommands:\n" + ChatColor.RESET
            + ChatColor.DARK_GREEN + "" + ChatColor.BOLD +" \n"
            + ChatColor.GREEN + "  /gmc" + ChatColor.AQUA + ChatColor.ITALIC + " (playername)" + ChatColor.RESET + " Creative Mode Shortcut\n"
            + ChatColor.GREEN + "  /gms" + ChatColor.AQUA + ChatColor.ITALIC + " (playername)" + ChatColor.RESET + " Survival Mode Shortcut\n"
            + ChatColor.GREEN + "  /gma" + ChatColor.AQUA + ChatColor.ITALIC + " (playername)" + ChatColor.RESET + " Adventure Mode Shortcut\n"
            + ChatColor.GREEN + "  /gmsp" + ChatColor.AQUA + ChatColor.ITALIC + " (playername)" + ChatColor.RESET + " Spectator Mode Shortcut\n"
            + " \n"
            + " \n"
            + "Items in " + ChatColor.AQUA + "blue" + ChatColor.RESET + " are optional if you'd like to\nchange a different player's gamemode.");

            player.spigot().sendMessage(webString);

            player.sendMessage(ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------");


        } else {

            getLogger().info("Shortened Gamemode Commands Help:");
            getLogger().info("Commands: gmc (playername), gms (playername), gmsp (playername), gma (playername) for Creative, Survival, Spectator and Adventure respectively. Console support is here!");
            getLogger().info("Please visit 'itzilly.com/plugins/sgc for more information'");

        }

        return false;
    }
}
