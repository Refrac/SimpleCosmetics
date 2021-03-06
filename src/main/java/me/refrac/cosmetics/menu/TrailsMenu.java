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
public class TrailsMenu implements Listener {

    public static String getTitle() {
        return Utils.getColor(Cosmetics.getInstance().getConfig().getString("TrailsMenu.TITLE"));
    }

    public static int getSize() {
        return 36;
    }

    public static void openMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, getSize(), getTitle());

        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.FLAME.ENABLED")) {
            inv.setItem(0, Trails.flameTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.HEART.ENABLED")) {
            inv.setItem(1, Trails.heartTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.SLIME.ENABLED")) {
            inv.setItem(2, Trails.slimeTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.SMOKE.ENABLED")) {
            inv.setItem(3, Trails.smokeTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.CRITICAL.ENABLED")) {
            inv.setItem(4, Trails.criticalTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.NOTES.ENABLED")) {
            inv.setItem(5, Trails.notesTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.LAVA.ENABLED")) {
            inv.setItem(6, Trails.lavaTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.WATER.ENABLED")) {
            inv.setItem(7, Trails.waterTrail());
        }
        if (Cosmetics.getInstance().getConfig().getBoolean("TrailsMenu.CLOUD.ENABLED")) {
            inv.setItem(8, Trails.cloudTrail());
        }

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
        if (!event.getView().getTitle().equals(getTitle())) return;

        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getType() == Material.AIR) return;

        event.setCancelled(true);
        if (event.getCurrentItem().isSimilar(Trails.flameTrail())) {
            if (player.hasPermission("simplecosmetics.trails.flame")) {
                if (!Utils.flame.contains(player.getName())) {
                    Utils.removeTrails(player);
                    Utils.flame.add(player.getName());
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
                    Utils.removeTrails(player);
                    Utils.heart.add(player.getName());
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
                    Utils.removeTrails(player);
                    Utils.slime.add(player.getName());
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
                    Utils.removeTrails(player);
                    Utils.smoke.add(player.getName());
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
                    Utils.removeTrails(player);
                    Utils.critical.add(player.getName());
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
                    Utils.removeTrails(player);
                    Utils.notes.add(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "notes")));
                } else {
                    Utils.notes.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "notes")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.lavaTrail())) {
            if (player.hasPermission("simplecosmetics.trails.lava")) {
                if (!Utils.lava.contains(player.getName())) {
                    Utils.removeTrails(player);
                    Utils.lava.add(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "lava")));
                } else {
                    Utils.lava.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "lava")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.waterTrail())) {
            if (player.hasPermission("simplecosmetics.trails.water")) {
                if (!Utils.water.contains(player.getName())) {
                    Utils.removeTrails(player);
                    Utils.water.add(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "water")));
                } else {
                    Utils.water.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "water")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.cloudTrail())) {
            if (player.hasPermission("simplecosmetics.trails.cloud")) {
                if (!Utils.cloud.contains(player.getName())) {
                    Utils.removeTrails(player);
                    Utils.cloud.add(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.APPLY-TRAIL").replace("{trail}", "cloud")));
                } else {
                    Utils.cloud.remove(player.getName());
                    player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-TRAIL").replace("{trail}", "cloud")));
                }
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-PERMISSION")));
            }
        } else if (event.getCurrentItem().isSimilar(Trails.removeTrailsItem())) {
            if (Utils.flame.contains(player.getName()) || Utils.heart.contains(player.getName()) || Utils.slime.contains(player.getName()) ||
                    Utils.smoke.contains(player.getName()) || Utils.critical.contains(player.getName()) || Utils.notes.contains(player.getName()) ||
                    Utils.lava.contains(player.getName()) || Utils.water.contains(player.getName()) || Utils.cloud.contains(player.getName())) {
                Utils.removeTrails(player);
                player.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.REMOVE-ALL-TRAILS")));
            } else {
                player.sendMessage(Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.NO-ACTIVE-TRAIL")));
            }
        }
    }
}
