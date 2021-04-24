/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zachary Baldwin / Refrac
 */
public class Utils {

    // TODO: Add MySQL Support as a secondary option
    public static List<String> flame = new ArrayList<>();
    public static List<String> heart = new ArrayList<>();
    public static List<String> slime = new ArrayList<>();
    public static List<String> smoke = new ArrayList<>();
    public static List<String> critical = new ArrayList<>();
    public static List<String> notes = new ArrayList<>();

    public static String getColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String getDeveloper = "Refrac";
    public static String getName = "SimpleCosmetics";
    public static String getVersion = "1.0";
    public static String PREFIX = getColor("&8[&b&lCosmetics&8] &r");

}
