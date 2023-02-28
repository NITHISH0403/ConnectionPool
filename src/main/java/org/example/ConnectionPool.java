package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Database{
    Logger l = Logger.getLogger("My Logger");
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
class ConnectionPool{
    public static void main(String[] args) {
        Logger l = Logger.getLogger("My Logger");
        Scanner s = new Scanner(System.in);
        String  url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String pass = "root";

        Database d1 = Database.getInstance();

        l.info("Enter Your Choice \n 1.open \n 2.close");
        int ch = s.nextInt();
        if (ch == 1) {
             d1.OpenCon(url, user, pass);
        }else{
             d1.closeCon();
        }
    }
}
