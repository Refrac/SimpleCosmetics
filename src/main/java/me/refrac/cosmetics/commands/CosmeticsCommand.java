/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.commands;

import me.refrac.cosmetics.Cosmetics;
import me.refrac.cosmetics.menu.TrailsMenu;
import me.refrac.cosmetics.utils.UpdateChecker;
import me.refrac.cosmetics.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zachary Baldwin / Refrac
 */
public class CosmeticsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.getColor("&cYou must be a player to execute this command."));
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (!player.hasPermission("simplecosmetics.use")) {
                player.sendMessage(Utils.getColor("&cYou don't have permission to execute this command."));
                return false;
            }
            TrailsMenu.openMenu(player);
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                if (!player.hasPermission("simplecosmetics.clear")) {
                    player.sendMessage(Utils.getColor("&cYou don't have permission to execute this command."));
                    return false;
                }
                Utils.removeTrails(player);
                player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-ALL-TRAILS")));
            } else if (args[0].equalsIgnoreCase("update")) {
                if (!player.hasPermission("simplecosmetics.admin")) {
                    player.sendMessage(Utils.getColor("&cYou don't have permission to execute this command."));
                    return false;
                }
                player.sendMessage(ChatColor.RED + "Checking for updates...");
                new UpdateChecker (Cosmetics.getInstance(), 91660).getLatestVersion(version -> {
                    if (!Cosmetics.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                        player.sendMessage(Utils.getColor("&7&m-----------------------------------------"));
                        player.sendMessage(Utils.getColor("&bA new version of SimpleCosmetics&7(SimpleCosmetics " + version + ") &bhas been released!"));
                        player.sendMessage(Utils.getColor("&bPlease update here: " + Utils.getPluginURL));
                        player.sendMessage(Utils.getColor("&7&m-----------------------------------------"));
                    } else
                        player.sendMessage(ChatColor.GREEN + "SimpleCosmetics is up to date!");
                });
            } else if (args[0].equalsIgnoreCase("dev")) {
                if (!player.getName().equalsIgnoreCase("Refrac")) {
                    player.sendMessage(Utils.getDevMessage);
                    player.sendMessage(Utils.getDevMessage2);
                    player.sendMessage(Utils.getDevMessage3);
                    return false;
                }
                player.sendMessage(ChatColor.WHITE + "Hello Refrac!");
                player.sendMessage(ChatColor.GRAY + "Plugin Version - " + ChatColor.WHITE + Utils.getVersion);
                player.sendMessage(ChatColor.GRAY + "Config Version - " + ChatColor.WHITE + Cosmetics.getInstance().getConfig().getString("configVersion").replace("&", "§"));
                player.sendMessage(ChatColor.GRAY + "End of log.");
                return true;
            }
        }
        return false;
    }
}