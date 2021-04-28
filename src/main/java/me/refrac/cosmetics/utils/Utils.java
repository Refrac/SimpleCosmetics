/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zachary Baldwin / Refrac
 */
public class Utils {

    public static List<String> flame = new ArrayList<>();
    public static List<String> heart = new ArrayList<>();
    public static List<String> slime = new ArrayList<>();
    public static List<String> smoke = new ArrayList<>();
    public static List<String> critical = new ArrayList<>();
    public static List<String> notes = new ArrayList<>();
    public static List<String> lava = new ArrayList<>();
    public static List<String> water = new ArrayList<>();
    public static List<String> cloud = new ArrayList<>();

    public static String getColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String getDeveloper = "Refrac";
    public static String getName = "SimpleCosmetics";
    public static String getVersion = "1.2";
    public static String getPluginURL = "https://www.spigotmc.org/resources/91660/";
    public static String getDevMessage = ChatColor.RED + "This command can only be used by Refrac for support reasons.";
    public static String getDevMessage2 = ChatColor.GRAY + "If you are worried about what this command does check it out on GitHub here:";
    public static String getDevMessage3 = ChatColor.GRAY + "https://bit.ly/2QxLPqf";
    public static String PREFIX = getColor("&8[&b&lCosmetics&8] &r");

    public static void removeTrails(Player player) {
        Utils.flame.remove(player.getName());
        Utils.heart.remove(player.getName());
        Utils.slime.remove(player.getName());
        Utils.smoke.remove(player.getName());
        Utils.critical.remove(player.getName());
        Utils.notes.remove(player.getName());
        Utils.lava.remove(player.getName());
        Utils.water.remove(player.getName());
        Utils.cloud.remove(player.getName());
    }
}