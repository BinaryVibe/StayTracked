
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    
    //Connection for hostel internet host:haris
    /*
    static String url = "jdbc:mariadb://192.168.1.9:3306/StayTracked";
    static String userName = "Ayaan";
    static String passWord = "123Password";
    static Connection con; */
    
    //Connection details for Talal
    static String url = "jdbc:mysql://localhost:3306/StayTracked";
    static String userName = "root";;
    static String passWord = "bythebandit@028";
    static Connection con;
    
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
