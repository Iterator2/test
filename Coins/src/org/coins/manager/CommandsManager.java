package org.coins.manager;

import org.coins.Coins;
import org.coins.commands.AddEpicCoins;
import org.coins.commands.AddLabCoins;
import org.coins.commands.RemoveEpicCoins;
import org.coins.commands.RemoveLabCoins;

public class CommandsManager {

    public void register(Coins coins){
        coins.getCommand("aepiccoins").setExecutor(new AddEpicCoins());
        coins.getCommand("alabcoins").setExecutor(new AddLabCoins());
        coins.getCommand("repiccoins").setExecutor(new RemoveEpicCoins());
        coins.getCommand("rlabcoins").setExecutor(new RemoveLabCoins());
    }

}
