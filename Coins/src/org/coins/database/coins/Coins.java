package org.coins.database.coins;

import org.bukkit.entity.Player;
import org.coins.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coins {

    public void createAccount(Player player, long epicCoins, long labCoins){
        try {
            PreparedStatement sts = Database.getConnection().prepareStatement("SELECT epicoins AND labcoins FROM coins WHERE uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            if(!rs.next()){
                sts.close();
                sts = Database.getConnection().prepareStatement("INSERT INTO coins(uuid, epicoins, labcoins) VALUES(?, ?, ?)");
                sts.setString(1, player.getUniqueId().toString());
                sts.setLong(2, epicCoins);
                sts.setLong(3, labCoins);
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getLabCoins(Player player){
        try {
            PreparedStatement sts = Database.getConnection().prepareStatement("SELECT labcoins FROM coins WHERE uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            while(rs.next()){
                return rs.getLong("labcoins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long getEpicCoins(Player player){
        try {
            PreparedStatement sts = Database.getConnection().prepareStatement("SELECT epicoins FROM coins WHERE uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            while(rs.next()){
                return rs.getLong("epicoins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addLabCoins(Player player, long labCoins){
        if(labCoins < 0) return;
        try {
            PreparedStatement sts = Database.getConnection().prepareStatement("SELECT labcoins FROM coins WHERE uuid=? ");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()){
                long money = rs.getLong("labcoins");
                sts.close();
                sts = Database.getConnection().prepareStatement("UPDATE coins SET labcoins=? WHERE uuid=?");
                sts.setLong(1, (money + labCoins));
                sts.setString(2, player.getUniqueId().toString());
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEpicCoins(Player player, long epicCoins) {
        if(epicCoins < 0) return;
        try {
            PreparedStatement sts = Database.getConnection().prepareStatement("SELECT epicoins FROM coins WHERE uuid=? ");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()) {
                long money = rs.getLong("epicoins");
                sts.close();
                sts = Database.getConnection().prepareStatement("UPDATE coins SET epicoins=? WHERE uuid=?");
                sts.setLong(1, (money + epicCoins));
                sts.setString(2, player.getUniqueId().toString());
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeLabCoins(Player player, long labCoins){
        if(labCoins < 0) return;
        try {
            PreparedStatement sts = Database.getConnection().prepareStatement("SELECT labcoins FROM coins WHERE uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()){
                long money = rs.getLong("labcoins");
                sts.close();
                sts = Database.getConnection().prepareStatement("UPDATE coins SET labcoins=? WHERE uuid=?");
                sts.setLong(1, (money - labCoins));
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEpicCoins(Player player, long epicCoins){
        if(epicCoins < 0) return;
        try {
            PreparedStatement sts = Database.getConnection().prepareStatement("SELECT epicoins FROM coins WHERE uuid=? ");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()) {
                long money = rs.getLong("epicoins");
                sts.close();
                sts = Database.getConnection().prepareStatement("UPDATE coins SET epicoins=? WHERE uuid=?");
                sts.setLong(1, (money - epicCoins));
                sts.setString(2, player.getUniqueId().toString());
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
