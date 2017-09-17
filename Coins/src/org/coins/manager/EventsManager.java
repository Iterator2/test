package org.coins.manager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.coins.Coins;
import org.coins.event.PlayerJoin;

public class EventsManager {

    public void register(Coins coins){
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(), coins);
    }

}
