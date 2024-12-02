
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import customExceptions.InvalidInputException;

public class AccountsDb {
    
    
    //method to validate Input
     public static void validateUser(String email, String password) throws InvalidInputException {
        try (Connection c = DBConnectionManager.getConnection()) {
            if (c == null) {
                throw new InvalidInputException("Database connection failed!");
            }

            String query = "SELECT password FROM accounts WHERE email = ?";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String passDb = rs.getString("password");
                        if (!passDb.equals(password)) {
                            throw new InvalidInputException("Incorrect email or password!");
                        }
                    } else {
                        throw new InvalidInputException("Email not found!");
                    }
                }
            }
        } catch (SQLException e) {
            throw new InvalidInputException("Database error occurred: " + e.getMessage());
        }
    }
     
}
