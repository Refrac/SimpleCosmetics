/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.utils;

import org.bukkit.Bukkit;

/**
 * @author Zachary Baldwin / Refrac
 */
public enum Logger {

    NONE('r'), SUCCESS('a'), ERROR('c'), WARNING('e'), INFO('b');

    char color;

    Logger(char color) { this.color = color; }

    public void out(String message) {
        message = Utils.getColor(String.format("&%c%s", this.color, message));
        Bukkit.getConsoleSender().sendMessage(message);
    }
}