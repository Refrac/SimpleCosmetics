/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.listeners;

import me.refrac.cosmetics.Cosmetics;
import me.refrac.cosmetics.utils.UpdateChecker;
import me.refrac.cosmetics.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Zachary Baldwin / Refrac
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Cosmetics.getInstance().getConfig().getBoolean("Update.Enabled")) {
            if (player.hasPermission("simplecosmetics.admin")) {
                new UpdateChecker (Cosmetics.getInstance(), 91660).getLatestVersion(version -> {
                    if (!Cosmetics.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                        player.sendMessage(Utils.getColor("&7&m-----------------------------------------"));
                        player.sendMessage(Utils.getColor("&bA new version of SimpleCosmetics&7(SimpleCosmetics " + version + ") &bhas been released!"));
                        player.sendMessage(Utils.getColor("&bPlease update here: &e" + Utils.getPluginURL));
                        player.sendMessage(Utils.getColor("&7&m-----------------------------------------"));
                    }});
            }
        }
        if (player.getName().equalsIgnoreCase("Refrac")) {
            player.sendMessage(ChatColor.RED + "Debug Message");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "This server is using " + Utils.getName + " version " + Utils.getVersion);
            player.sendMessage(ChatColor.GREEN + "Running " + Bukkit.getServer().getVersion());
            player.sendMessage(" ");
        }
    }
}