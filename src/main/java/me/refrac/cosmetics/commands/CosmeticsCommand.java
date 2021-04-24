/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.commands;

import me.refrac.cosmetics.Cosmetics;
import me.refrac.cosmetics.menu.CosmeticsMenu;
import me.refrac.cosmetics.utils.Utils;
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
            CosmeticsMenu.openTrailsMenu(player);
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                if (!player.hasPermission("simplecosmetics.clear")) {
                    player.sendMessage(Utils.getColor("&cYou don't have permission to execute this command."));
                    return false;
                }
                Utils.removeTrails(player);
                player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-ALL-TRAILS")));
            }
        }
        return false;
    }
}
