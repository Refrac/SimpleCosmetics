/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.listeners;

import me.refrac.cosmetics.utils.Utils;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Zachary Baldwin / Refrac
 */
public class Particlev1_13PlusListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (Utils.flame.contains(player.getName())) {
            player.spawnParticle(Particle.FLAME, player.getLocation(), 0);
        }
        if (Utils.heart.contains(player.getName())) {
            player.spawnParticle(Particle.HEART, player.getLocation(), 0);
        }
        if (Utils.slime.contains(player.getName())) {
            player.spawnParticle(Particle.SLIME, player.getLocation(), 0);
        }
        if (Utils.smoke.contains(player.getName())) {
            player.spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 0);
        }
        if (Utils.critical.contains(player.getName())) {
            player.spawnParticle(Particle.CRIT, player.getLocation(), 1);
        }
        if (Utils.notes.contains(player.getName())) {
            player.spawnParticle(Particle.NOTE, player.getLocation(), 1);
        }
        if (Utils.lava.contains(player.getName())) {
            player.spawnParticle(Particle.DRIP_LAVA, player.getLocation(), 1);
        }
        if (Utils.water.contains(player.getName())) {
            player.spawnParticle(Particle.DRIP_WATER, player.getLocation(), 1);
        }
        if (Utils.cloud.contains(player.getName())) {
            player.spawnParticle(Particle.VILLAGER_ANGRY, player.getLocation(), 0);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Utils.removeTrails(player);
    }
}
