package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

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
             d1.openCon(url, user, pass);
        }else{
             d1.closeCon();
        }
    }
}
