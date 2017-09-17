package org.coins.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coins.database.coins.Coins;

public class RemoveLabCoins implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("rlabcoins")){
            if (sender.isOp()) {
                if (args.length != 2) {
                    sender.sendMessage(ChatColor.RED + "Erreur : Vous devez spécifier un joueur ainsi qu'un nombre de lab coins à enlever");
                    return false;
                }

                int labcoins = Integer.parseInt(args[0]);

                if (labcoins < 0) {
                    sender.sendMessage(ChatColor.RED + "Erreur : Vous ne pouvez pas enlever un nombre de lab coins inférieur à 0");
                    return false;
                }

                Player target = Bukkit.getPlayer(args[1]);

                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "Erreur : Joueur non-connecté");
                    return false;
                }

                new Coins().removeLabCoins(target, labcoins);
                sender.sendMessage(ChatColor.GREEN + "Le joueur s'est vu enlevé " + labcoins + " lab coins");
            }
        }
        return true;
    }
}
