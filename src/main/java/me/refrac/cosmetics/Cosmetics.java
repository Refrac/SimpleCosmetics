/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics;

import me.refrac.cosmetics.commands.CosmeticsCommand;
import me.refrac.cosmetics.commands.CosmeticsReloadCommand;
import me.refrac.cosmetics.listeners.ParticleListener;
import me.refrac.cosmetics.menu.CosmeticsMenu;
import me.refrac.cosmetics.utils.Logger;
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
        Bukkit.getPluginManager().registerEvents(new ParticleListener(), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticsMenu(), this);
        Logger.NONE.out(Utils.getColor("&8&m==&c&m=====&f&m======================&c&m=====&8&m=="));
        Logger.NONE.out(Utils.getColor("&e" + Utils.getName + " has been enabled."));
        Logger.NONE.out(Utils.getColor(" &f[*] &6Version&f: &b" + Utils.getVersion));
        Logger.NONE.out(Utils.getColor(" &f[*] &6Name&f: &b" + Utils.getName));
        Logger.NONE.out(Utils.getColor(" &f[*] &6Author&f: &b" + Utils.getDeveloper));
        Logger.NONE.out(Utils.getColor("&8&m==&c&m=====&f&m======================&c&m=====&8&m=="));
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
