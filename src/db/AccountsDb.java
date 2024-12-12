package db;

import customexceptions.FailureException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.regex.*;
import customexceptions.InvalidInputException;
import model.Account;
import model.ManagerAccount;
import model.NormalAccount;

public class AccountsDb {

    //static Connection con = DBConnectionManager.getConnection();
   static Connection con = DBConnectionManager.con;

    //method to validate Input
    public static void validateUser(String email, String password) throws InvalidInputException {
        if (con == null) {
            throw new InvalidInputException("Database connection failed!");
        }

        String query = "SELECT password FROM accounts WHERE email = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //method to add a new Normal account in database
    public static void addNormalAccount(NormalAccount account) throws FailureException {
        if (con == null) {
            String error = "Database connection failed!";
        }

        //add a logic to insert Account Details in database
        String insertAccountQuery = "INSERT INTO accounts (first_name, last_name, username, contact_num, email, password, account_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(insertAccountQuery)) {
            con.setAutoCommit(false);
            ps.setString(1, account.getFirstName());
            ps.setString(2, account.getLastName());
            ps.setString(3, account.getUserName());
            ps.setString(4, account.getContactNum());
            ps.setString(5, account.getEmail());
            ps.setString(6, account.getPassword());
            ps.setString(7, "Normal");

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                con.rollback(); // Rollback transaction in case of failure
                throw new FailureException("Insertion into Database Failed");
            }

            //Get generated keys
            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                int accountID = generatedKeys.getInt(1);

                //Insert into Normal Accounts Table
                String insertNormalAccountQuery = "INSERT INTO normal_accounts (account_id, is_part_of_team, team_id) VALUES (?, ?, ?)";
                PreparedStatement ps2 = con.prepareStatement(insertNormalAccountQuery);
                ps2.setInt(1, accountID);
                ps2.setBoolean(2, account.isIsPartOfTeam());
                ps2.setNull(1, Types.INTEGER); //No team assigned yet
                int rowsInserted = ps2.executeUpdate();

                if (rowsInserted > 0) {
                    con.commit();// Commit transaction if both inserts are successful
                } else {
                    con.rollback(); //rollback if insertion is unsuccessfull
                    throw new FailureException("Insertion into Database Failed");
                }
            } else {
                con.rollback(); //Rollback if account_id couldn't be generated
                throw new FailureException("AccountID could not be generated");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
    
    //method to add a new Normal account in database
    public static void addManagerAccount(ManagerAccount account) throws FailureException {
        if (con == null) {
            String error = "Database connection failed!";
        }

        //add a logic to insert Account Details in database
        String insertAccountQuery = "INSERT INTO accounts (first_name, last_name, username, contact_num, email, password, account_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(insertAccountQuery)) {
            con.setAutoCommit(false);
            ps.setString(1, account.getFirstName());
            ps.setString(2, account.getLastName());
            ps.setString(3, account.getUserName());
            ps.setString(4, account.getContactNum());
            ps.setString(5, account.getEmail());
            ps.setString(6, account.getPassword());
            ps.setString(7, "Manager");

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                con.rollback(); // Rollback transaction in case of failure
                throw new FailureException("Insertion into Database Failed");
            }

            //Get generated keys
            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                int managerID = generatedKeys.getInt(1);

                //Insert Team into Teams Table
                String insertTeamQuery = "INSERT INTO teams (team_name, manager_id) VALUES (?,?)";
                PreparedStatement ps2 = con.prepareStatement(insertTeamQuery);
              
            } else {
                con.rollback(); //Rollback if account_id couldn't be generated
                throw new FailureException("AccountID could not be generated");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void validateUserName(String userName) throws InvalidInputException {

        if (con == null) {
            throw new InvalidInputException("Database connection failed!");
        }

        if (userName.isEmpty()) {
            throw new InvalidInputException("Enter user name!");
        }

        //add a logic to check if userName is already taken
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

        if (password.isEmpty()) {
            throw new InvalidInputException("Enter password!");
        }
        if (!validPass) {
            throw new InvalidInputException("Password is not strong enough! ");
        }

    }

    public static void validateEmail(String email) throws InvalidInputException {
        // Regex to check valid email
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean validEmail = m.matches();

        if (email.isEmpty()) {
            throw new InvalidInputException("Enter Email!");
        }
        if (!validEmail) {
            throw new InvalidInputException("Email s not valid! ");
        }

    }

}
