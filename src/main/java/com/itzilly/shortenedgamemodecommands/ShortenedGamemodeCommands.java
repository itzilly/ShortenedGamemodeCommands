package com.itzilly.shortenedgamemodecommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShortenedGamemodeCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[ShortenedGamemodeCommands] Plugin has been enabled!");

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        //Plugin shutdown logic
        System.out.println("[ShortenedamemodeCommands] Plugin has been disabled!");
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        //Creative Mode Self
        if (cmd.getName().equals("gmc")) {
            if (args.length == 0) {
                if (sender instanceof Player) {

                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.self.creative")) {

                        player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");
                        player.setGameMode(GameMode.CREATIVE);
                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }

                } else {
                    System.out.println("Please specify a player");
                }


        //Creative Mode Other
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (sender instanceof ConsoleCommandSender) {
                    boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                    if (targetSendMessage) {
                        target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");
                    }
                    target.setGameMode(GameMode.CREATIVE);
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.others.creative")) {

                        player.sendMessage("Updated " + target.getDisplayName() + " to " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");
                        target.setGameMode(GameMode.CREATIVE);

                        boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                        if (targetSendMessage) {
                            target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Creative Mode");
                        }
                        target.setGameMode(GameMode.CREATIVE);
                        System.out.println("[ShortenedamemodeCommands] Set "+ target.getDisplayName() + " to Creative mode");

                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }
                } else {
                    Player player = (Player) sender;
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                }
            }

            return false;
        }

        //Survival Mode Self
        if (cmd.getName().equals("gms")) {
            if (args.length == 0) {
                if (sender instanceof Player) {

                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.self.survival")) {

                        player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Survival Mode");
                        player.setGameMode(GameMode.SURVIVAL);
                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }

                } else {
                    System.out.println("Please specify a player");
                }


                //Survival Mode Other
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (sender instanceof ConsoleCommandSender) {
                    boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                    if (targetSendMessage) {
                        target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Survival Mode");
                    }
                    target.setGameMode(GameMode.SURVIVAL);
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.others.survival")) {

                        player.sendMessage("Updated " + target.getDisplayName() + " to " + ChatColor.ITALIC + ChatColor.GRAY + "Survival Mode");
                        target.setGameMode(GameMode.SURVIVAL);
                        System.out.println("[ShortenedamemodeCommands] Set "+ target.getDisplayName() + " to Survival mode");

                        boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                        if (targetSendMessage) {
                            target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Survival Mode");
                        }
                        target.setGameMode(GameMode.SURVIVAL);
                        System.out.println("[ShortenedamemodeCommands] Set "+ target.getDisplayName() + " to Survival mode");

                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }
                } else {
                    Player player = (Player) sender;
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                }
            }

            return false;
        }

        //Adventure Mode Self
        if (cmd.getName().equals("gma")) {
            if (args.length == 0) {
                if (sender instanceof Player) {

                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.self.adventure")) {

                        player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                        player.setGameMode(GameMode.ADVENTURE);
                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }

                } else {
                    System.out.println("Please specify a player");
                }


                //Survival Mode Other
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (sender instanceof ConsoleCommandSender) {
                    boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                    if (targetSendMessage) {
                        target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                    }
                    target.setGameMode(GameMode.ADVENTURE);
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.others.adventure")) {

                        player.sendMessage("Updated " + target.getDisplayName() + " to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                        target.setGameMode(GameMode.ADVENTURE);
                        System.out.println("[ShortenedamemodeCommands] Set "+ target.getDisplayName() + " to Adventure mode");

                        boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                        if (targetSendMessage) {
                            target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Adventure Mode");
                        }
                        target.setGameMode(GameMode.ADVENTURE);
                        System.out.println("[ShortenedamemodeCommands] Set "+ target.getDisplayName() + " to Adventure mode");

                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }
                } else {
                    Player player = (Player) sender;
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                }
            }

            return false;
        }

        //Spectator Mode Self
        if (cmd.getName().equals("gma")) {
            if (args.length == 0) {
                if (sender instanceof Player) {

                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.self.spectator")) {

                        player.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Spectator Mode");
                        player.setGameMode(GameMode.SPECTATOR);
                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }

                } else {
                    System.out.println("Please specify a player");
                }


                //Survival Mode Other
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (sender instanceof ConsoleCommandSender) {
                    boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                    if (targetSendMessage) {
                        target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Spectator Mode");
                    }
                    target.setGameMode(GameMode.SPECTATOR);
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("sgc.others.spectator")) {

                        player.sendMessage("Updated " + target.getDisplayName() + " to " + ChatColor.ITALIC + ChatColor.GRAY + "Spectator Mode");
                        target.setGameMode(GameMode.SPECTATOR);
                        System.out.println("[ShortenedamemodeCommands] Set "+ target.getDisplayName() + " to Spectator mode");

                        boolean targetSendMessage = this.getConfig().getBoolean("targetSendMessage");
                        if (targetSendMessage) {
                            target.sendMessage("Your gamemode has been updated to " + ChatColor.ITALIC + ChatColor.GRAY + "Spectator Mode");
                        }
                        target.setGameMode(GameMode.SPECTATOR);
                        System.out.println("[ShortenedamemodeCommands] Set "+ target.getDisplayName() + " to Spectator mode");

                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                    }
                } else {
                    Player player = (Player) sender;
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                }
            }

            return false;
        }

        return false;
    }

}
