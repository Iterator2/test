package org.coins.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.coins.database.coins.Coins;

public class PlayerJoin implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        new Coins().createAccount(player, 1000, 0);
    }

}
