package org.coins.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    public static String host;
    public static String password;
    public static String user;
    public static String database;
    public static int port;

    public void openConnection() {
        try {
            if ((connection != null) && (!connection.isClosed())) {
                return;
            }
            synchronized (this) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.user, this.password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void removeConnection() {
        try {
            if ((connection == null) || (connection.isClosed())) {
                return;
            }
            synchronized (this) {
                connection.close();
            }
            } catch(SQLException e){
                e.printStackTrace();
            }
    }

    public static Connection getConnection(){
        return connection;
    }


}
