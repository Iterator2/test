package org.coins.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coins.database.coins.Coins;

public class RemoveEpicCoins implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("repiccoins")){
            if (sender.isOp()) {
                if (args.length != 2) {
                    sender.sendMessage(ChatColor.RED + "Erreur : Vous devez spécifier un joueur ainsi qu'un nombre d'epic coins à enlever");
                    return false;
                }

                int epicoins = Integer.parseInt(args[0]);

                if (epicoins < 0) {
                    sender.sendMessage(ChatColor.RED + "Erreur : Vous ne pouvez pas enlever un nombre d'epic coins inférieur à 0");
                    return false;
                }

                Player target = Bukkit.getPlayer(args[1]);

                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "Erreur : Joueur non-connecté");
                    return false;
                }

                new Coins().removeEpicCoins(target, epicoins);
                sender.sendMessage(ChatColor.GREEN + "Le joueur s'est vu enlevé " + epicoins + " epic coins");

            }
        }
        return true;
    }
}
