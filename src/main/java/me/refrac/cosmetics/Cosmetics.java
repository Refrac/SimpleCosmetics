/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics;

import me.refrac.cosmetics.commands.CosmeticsCommand;
import me.refrac.cosmetics.commands.CosmeticsReloadCommand;
import me.refrac.cosmetics.listeners.JoinListener;
import me.refrac.cosmetics.listeners.ParticleListener;
import me.refrac.cosmetics.listeners.Particlev1_13PlusListener;
import me.refrac.cosmetics.menu.TrailsMenu;
import me.refrac.cosmetics.utils.Logger;
import me.refrac.cosmetics.utils.UpdateChecker;
import me.refrac.cosmetics.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Zachary Baldwin / Refrac
 */
public final class Cosmetics extends JavaPlugin {

    private static Cosmetics instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();
        getCommand("cosmetics").setExecutor(new CosmeticsCommand());
        getCommand("cosmeticsreload").setExecutor(new CosmeticsReloadCommand());
        if (Bukkit.getServer().getVersion().contains("1.13") || Bukkit.getServer().getVersion().contains("1.14") ||
                Bukkit.getServer().getVersion().contains("1.15") || Bukkit.getServer().getVersion().contains("1.16") || Bukkit.getServer().getVersion().contains("1.17")) {
            Bukkit.getPluginManager().registerEvents(new Particlev1_13PlusListener(), this);
        } else {
            Bukkit.getPluginManager().registerEvents(new ParticleListener(), this);
        }
        Bukkit.getPluginManager().registerEvents(new TrailsMenu(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Logger.NONE.out(Utils.getColor("&8&m==&c&m=====&f&m======================&c&m=====&8&m=="));
        Logger.NONE.out(Utils.getColor("&e" + Utils.getName + " has been enabled."));
        Logger.NONE.out(Utils.getColor(" &f[*] &6Version&f: &b" + Utils.getVersion));
        Logger.NONE.out(Utils.getColor(" &f[*] &6Name&f: &b" + Utils.getName));
        Logger.NONE.out(Utils.getColor(" &f[*] &6Author&f: &b" + Utils.getDeveloper));
        Logger.NONE.out(Utils.getColor("&8&m==&c&m=====&f&m======================&c&m=====&8&m=="));
        Logger.INFO.out("Checking for updates...");
        new UpdateChecker (Cosmetics.instance, 91660).getLatestVersion(version -> {
            if (!Cosmetics.instance.getDescription().getVersion().equalsIgnoreCase(version)) {
                Logger.NONE.out(Utils.getColor("&7&m-----------------------------------------"));
                Logger.NONE.out(Utils.getColor("&bA new version of SimpleCosmetics&7(SimpleCosmetics " + version + ") &bhas been released!"));
                Logger.NONE.out(Utils.getColor("&bPlease update here: " + Utils.getPluginURL));
                Logger.NONE.out(Utils.getColor("&7&m-----------------------------------------"));
            } else
                Logger.SUCCESS.out("SimpleCosmetics is up to date!");
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    public static Cosmetics getInstance() {
        return instance;
    }
}