package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

class Database{
    Logger l = Logger.getLogger("com.api.jar");
    static Database d = null;
    Connection con;
    private Database(){
    }
    public static Database getInstance(){
        if(d == null)
            d = new Database();
        return d;
    }
    void openCon(String url, String user, String pass){
        try {
            con = DriverManager.getConnection(url, user, pass);
            l.info("New Connection connected Successfully.");
        }
        catch (SQLException e){
            l.info(String.valueOf(e));
        }
    }
    void closeCon(){
        try {
            con.close();
            l.info("All Connection Closed Successfully.");
        }catch (SQLException e){
            l.info(String.valueOf(e));
        }

    }
}
