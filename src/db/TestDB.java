
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
    public static void main(String[] args) {
		
		Connection c = DBConnectionManager.getConnection();
		
		 if (c != null) {
            System.out.println("Connection Successful");
            
            try (Statement stmt = c.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM accounts")) {
                
                // Process the ResultSet
                while (rs.next()) {
                    int id = rs.getInt("account_id"); // Assuming 'id' is a column in 'accounts'
                    String name = rs.getString("first_name"); // Assuming 'name' is a column in 'accounts'
                    String email = rs.getString("email"); // Assuming 'email' is a column in 'accounts'
                    
                    System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    c.close();
                    System.out.println("Connection Closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Connection Failed");
        }
    }
}
