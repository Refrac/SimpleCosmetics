/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.listeners;

import me.refrac.cosmetics.utils.Utils;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Zachary Baldwin / Refrac
 */
public class ParticleListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (Utils.flame.contains(player.getName())) {
            player.playEffect(player.getLocation(), Effect.FLAME, 0);
        }
        if (Utils.heart.contains(player.getName())) {
            player.playEffect(player.getLocation(), Effect.HEART, 0);
        }
        if (Utils.slime.contains(player.getName())) {
            player.playEffect(player.getLocation(), Effect.SLIME, 0);
        }
        if (Utils.smoke.contains(player.getName())) {
            player.playEffect(player.getLocation(), Effect.SMOKE, 0);
        }
        if (Utils.critical.contains(player.getName())) {
            player.playEffect(player.getLocation(), Effect.CRIT, 0);
        }
        if (Utils.notes.contains(player.getName())) {
            player.playEffect(player.getLocation(), Effect.NOTE, 0);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Utils.flame.remove(player.getName());
        Utils.heart.remove(player.getName());
        Utils.slime.remove(player.getName());
        Utils.smoke.remove(player.getName());
        Utils.critical.remove(player.getName());
        Utils.notes.remove(player.getName());
    }

}
