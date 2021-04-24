/*
 * Copyright (c) Refrac
 * If you have any questions please email refracplaysmc@gmail.com or reach me on Discord
 */
package me.refrac.cosmetics.menu;

import me.refrac.cosmetics.Cosmetics;
import me.refrac.cosmetics.menu.items.Trails;
import me.refrac.cosmetics.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author Zachary Baldwin / Refrac
 */
public class CosmeticsMenu implements Listener {

    public static String getTitle() {
        return Utils.getColor(Cosmetics.getInstance().getConfig().getString("TrailsMenu.TITLE"));
    }

    public static int getSize() {
        return 36;
    }

    public static void openTrailsMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, getSize(), getTitle());

        inv.setItem(0, Trails.flameTrail());
        inv.setItem(1, Trails.heartTrail());
        inv.setItem(2, Trails.slimeTrail());
        inv.setItem(3, Trails.smokeTrail());
        inv.setItem(4, Trails.criticalTrail());
        inv.setItem(5, Trails.notesTrail());
        inv.setItem(31, Trails.removeTrailsItem());

        for (int i = 0; i < 36; ++i) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, Glass());
            }
        }

        p.openInventory(inv);
    }

    private static ItemStack Glass() {
        ItemStack stone = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName("");
        stone.setItemMeta(stonem);
        return stone;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView() == null) return;
        if (!event.getView().getTitle().equals(CosmeticsMenu.getTitle())) return;

        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getType() == Material.AIR) return;

        event.setCancelled(true);
        if (event.getCurrentItem().isSimilar(Trails.flameTrail())) {
            if (player.hasPermission("simplecosmetics.trails.flame")) {
                if (!Utils.flame.contains(player.getName())) {
                    Utils.flame.add(player.getName());
                    Utils.heart.remove(player.getName());
                    Utils.slime.remove(player.getName());
                    Utils.smoke.remove(player.getName());
                    Utils.critical.remove(player.getName());
                    Utils.notes.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "flame")));
                } else {
                    Utils.flame.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "flame")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.heartTrail())) {
            if (player.hasPermission("simplecosmetics.trails.heart")) {
                if (!Utils.heart.contains(player.getName())) {
                    Utils.heart.add(player.getName());
                    Utils.flame.remove(player.getName());
                    Utils.slime.remove(player.getName());
                    Utils.smoke.remove(player.getName());
                    Utils.critical.remove(player.getName());
                    Utils.notes.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "heart")));
                } else {
                    Utils.heart.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "heart")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.slimeTrail())) {
            if (player.hasPermission("simplecosmetics.trails.slime")) {
                if (!Utils.slime.contains(player.getName())) {
                    Utils.slime.add(player.getName());
                    Utils.flame.remove(player.getName());
                    Utils.heart.remove(player.getName());
                    Utils.smoke.remove(player.getName());
                    Utils.critical.remove(player.getName());
                    Utils.notes.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "slime")));
                } else {
                    Utils.slime.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "slime")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.smokeTrail())) {
            if (player.hasPermission("simplecosmetics.trails.smoke")) {
                if (!Utils.smoke.contains(player.getName())) {
                    Utils.smoke.add(player.getName());
                    Utils.flame.remove(player.getName());
                    Utils.heart.remove(player.getName());
                    Utils.slime.remove(player.getName());
                    Utils.critical.remove(player.getName());
                    Utils.notes.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "smoke")));
                } else {
                    Utils.smoke.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "smoke")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.criticalTrail())) {
            if (player.hasPermission("simplecosmetics.trails.critical")) {
                if (!Utils.critical.contains(player.getName())) {
                    Utils.critical.add(player.getName());
                    Utils.flame.remove(player.getName());
                    Utils.heart.remove(player.getName());
                    Utils.slime.remove(player.getName());
                    Utils.smoke.remove(player.getName());
                    Utils.notes.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "critical")));
                } else {
                    Utils.critical.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "critical")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.notesTrail())) {
            if (player.hasPermission("simplecosmetics.trails.notes")) {
                if (!Utils.notes.contains(player.getName())) {
                    Utils.notes.add(player.getName());
                    Utils.flame.remove(player.getName());
                    Utils.heart.remove(player.getName());
                    Utils.slime.remove(player.getName());
                    Utils.smoke.remove(player.getName());
                    Utils.critical.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "notes")));
                } else {
                    Utils.notes.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "notes")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.removeTrailsItem())) {
            if (Utils.flame.contains(player.getName()) || Utils.heart.contains(player.getName()) || Utils.slime.contains(player.getName()) ||
                    Utils.smoke.contains(player.getName()) || Utils.critical.contains(player.getName()) || Utils.notes.contains(player.getName())) {
                Utils.flame.remove(player.getName());
                Utils.heart.remove(player.getName());
                Utils.slime.remove(player.getName());
                Utils.smoke.remove(player.getName());
                Utils.critical.remove(player.getName());
                Utils.notes.remove(player.getName());
                player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-ALL-TRAILS")));
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-ACTIVE-TRAIL")));
            }
        }
    }

}
