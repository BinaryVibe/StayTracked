
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    
    static String url = "jdbc:mariadb://192.168.1.14:3306/StayTracked";
    static String userName = "Ayaan";
    static String passWord = "123Password";
    static Connection con;
    
    static {
        try {
        Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
        
    }
    public static void setConnection(){
        con = null;
        try{
            con = DriverManager.getConnection(url, userName, passWord);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        //return con;
    }
    
}
