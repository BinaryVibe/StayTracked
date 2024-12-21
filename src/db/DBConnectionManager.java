
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    
    static String url = "jdbc:mariadb://localhost:3306/StayTracked";
    static String userName = "mysql";
    static String passWord = "dustrunner42";
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
