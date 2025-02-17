
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    
   
    
    //Your Personal Connection to Stay Tracked DB
    static String url = "jdbc:mysql://localhost:3306/staytracked";
    static String userName = "root"; //If your sql client userName is different then change it respectively
    static String passWord = ""; //enter your sql client password here
    static private Connection con;
//    
    public static void setConnection(){
        con = null;
        try{
            con = DriverManager.getConnection(url, userName, passWord);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        //return con;
    }
    
    public static Connection getConnection(){
        return con;
    }
    
    public static void closeConnection() {
    try {
        if (con != null && !con.isClosed()) {
            con.close();
            System.out.println("Connection closed successfully.");
        }
    } catch (SQLException e) {
        System.out.println("Failed to close connection: " + e.getMessage());
    }
}

    
}
