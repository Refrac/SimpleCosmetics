package me.refrac.cosmetics.commands;

import me.refrac.cosmetics.Cosmetics;
import me.refrac.cosmetics.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CosmeticsReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (!sender.hasPermission("simplecosmetics.admin")) {
                sender.sendMessage(Utils.getColor("&cYou don't have permission to execute this command."));
                return false;
            }
            Cosmetics.getInstance().reloadConfig();
            sender.sendMessage(Utils.PREFIX + Utils.getColor(Cosmetics.getInstance().getConfig().getString("Messages.RELOAD")));
            return true;
        }
        return false;
    }
}
