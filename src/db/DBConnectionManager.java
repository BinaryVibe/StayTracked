
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    
    static String url = "jdbc:mysql://localhost:3306/staytracked";
    static String userName = "root";
    static String passWord = "ersatzSQL";
    
    static {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
        
    }
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, userName, passWord);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return conn;
    }
    
}
