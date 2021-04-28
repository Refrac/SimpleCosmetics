/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.menu.items;

import me.refrac.cosmetics.Cosmetics;
import me.refrac.cosmetics.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

/**
 * @author Zachary Baldwin / Refrac
 */
public class Trails {

    public static ItemStack removeTrailsItem() {
        return new ItemBuilder(Material.BARRIER)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.REMOVE-TRAIL.NAME").replace("&", "§"))
                .setLore(Cosmetics.getInstance().getConfig().getString("TrailsMenu.REMOVE-TRAIL.LORE").replace("&", "§"))
                .toItemStack();
    }

    public static ItemStack flameTrail() {
        return new ItemBuilder(Material.BLAZE_POWDER)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.FLAME.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.FLAME.LORE").replace("&", "§")
                ))
                .toItemStack();
    }

    public static ItemStack heartTrail() {
        return new ItemBuilder(Material.REDSTONE)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.HEART.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.HEART.LORE").replace("&", "§")
                ))
                .toItemStack();
    }

    public static ItemStack slimeTrail() {
        return new ItemBuilder(Material.SLIME_BALL)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.SLIME.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.SLIME.LORE").replace("&", "§")
                ))
                .toItemStack();
    }

    public static ItemStack smokeTrail() {
        return new ItemBuilder(Material.STRING)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.SMOKE.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.SMOKE.LORE").replace("&", "§")
                ))
                .toItemStack();
    }

    public static ItemStack criticalTrail() {
        return new ItemBuilder(Material.FLINT)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.CRITICAL.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.CRITICAL.LORE").replace("&", "§")
                ))
                .toItemStack();
    }

    public static ItemStack notesTrail() {
        return new ItemBuilder(Material.NOTE_BLOCK)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.NOTES.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.NOTES.LORE").replace("&", "§")
                ))
                .toItemStack();
    }

    public static ItemStack lavaTrail() {
        return new ItemBuilder(Material.LAVA_BUCKET)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.LAVA.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.LAVA.LORE").replace("&", "§")
                ))
                .toItemStack();
    }
    public static ItemStack waterTrail() {
        return new ItemBuilder(Material.WATER_BUCKET)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.WATER.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.WATER.LORE").replace("&", "§")
                ))
                .toItemStack();
    }
    public static ItemStack cloudTrail() {
        return new ItemBuilder(Material.BEACON)
                .setName(Cosmetics.getInstance().getConfig().getString("TrailsMenu.CLOUD.NAME").replace("&", "§"))
                .setLore(Arrays.asList(
                        Cosmetics.getInstance().getConfig().getString("TrailsMenu.CLOUD.LORE").replace("&", "§")
                ))
                .toItemStack();
    }
}