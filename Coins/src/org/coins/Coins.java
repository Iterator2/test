package org.coins;

import org.bukkit.plugin.java.JavaPlugin;
import org.coins.database.Database;
import org.coins.manager.CommandsManager;
import org.coins.manager.EventsManager;

public class Coins extends JavaPlugin{

    private static Coins instance;

    private Database database;

    @Override
    public void onEnable(){
        instance = this;
        database = new Database();

        Database.host = "localhost";
        Database.database = "selano";
        Database.password = "";
        Database.port = 3306;
        Database.user = "root";

        database.openConnection();

        new EventsManager().register(this);
        new CommandsManager().register(this);

    }

    @Override
    public void onDisable() {
        database.removeConnection();
    }

    public static Coins get(){
        return instance;
    }

}
