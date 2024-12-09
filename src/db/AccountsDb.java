package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.*;
import customexceptions.InvalidInputException;
import model.Account;

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
            System.out.println(e.getMessage());
        }
    }

    //method to add a new account in database
    public static void addAccount(Account account) {
        try(Connection c = DBConnectionManager.getConnection()) {
            if (c == null) {
                String error = "Database connection failed!";
            }
            
            //add a logic to insert Account Details in database

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void validateUserName(String userName) throws InvalidInputException {
        try(Connection c = DBConnectionManager.getConnection()) {
            if (c == null) {
                throw new InvalidInputException("Database connection failed!");
            }
            
            if (userName.isEmpty()){
                throw new InvalidInputException("Enter user name!");
            }
            
            //add a logic to check if userName is already taken

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void validatePassword(String password) throws InvalidInputException {
        
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        boolean validPass = m.matches();
        
        if(password.isEmpty()){
            throw new InvalidInputException("Enter password!");
        }
        if(!validPass){
             throw new InvalidInputException("Password is not strong enough! ");
        }
        
    }
    
    public static void validateEmail (String email) throws InvalidInputException{
        // Regex to check valid email
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean validEmail = m.matches();
        
        if(email.isEmpty()){
            throw new InvalidInputException("Enter Email!");
        }
        if(!validEmail){
             throw new InvalidInputException("Email s not valid! ");
        }

    }

}
