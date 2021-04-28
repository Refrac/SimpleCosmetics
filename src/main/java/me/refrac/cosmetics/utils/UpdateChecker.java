package me.refrac.cosmetics.utils;

import me.refrac.cosmetics.Cosmetics;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

// Created by BGHDDevelopment
public class UpdateChecker {
    private Cosmetics plugin;
    private int resourceId;

    public UpdateChecker(Cosmetics plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getLatestVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                Logger.INFO.out("Cannot look for updates: " + exception.getMessage());
            }
        });
    }
}