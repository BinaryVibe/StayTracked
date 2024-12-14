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
import helper.CurrentSession;
import org.mariadb.jdbc.Statement;

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

    public static void setCurrentSession(String inputEmail) throws FailureException {

        int accountID = 0, teamID = 0;
        String firstName = "", lastName = "", userName = "", contact = "", accountType = "", teamName = "Not Joined yet";
        Boolean isPartOfTeam = false;
        if (con == null) {
            throw new FailureException("Database connection failed!");
        }
        String query = "SELECT * FROM accounts WHERE email = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, inputEmail);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    accountID = rs.getInt("account_id");
                    firstName = rs.getString("first_name");
                    lastName = rs.getString("last_name");
                    userName = rs.getString("username");
                    contact = rs.getString("contact_num");
                    accountType = rs.getString("account_type");

                    
                    //FOR MANAGER ACCOUNTS
                    if (accountType.equalsIgnoreCase("MANAGER")) {
                        isPartOfTeam = true;

                        String query2 = "SELECT * FROM teams WHERE manager_id = ?";

                        try (PreparedStatement ps2 = con.prepareStatement(query2)) {
                            ps2.setInt(1, accountID);
                            try (ResultSet rs2 = ps2.executeQuery()) {

                                if (rs2.next()) {
                                    teamName = rs2.getString("team_name");
                                    teamID = rs2.getInt("team_id");
                                    
                                }
                            }
                        }
                        
                        
                        //FOR NORMAL ACCOUNTS
                    } else if (accountType.equalsIgnoreCase("NORMAL")) {
                        //logic to get team name is account is a team member of any team.
                        String query2 = "SELECT * FROM team_members WHERE account_id = ?";

                        try (PreparedStatement ps2 = con.prepareStatement(query2)) {
                            ps2.setInt(1, accountID);
                            try (ResultSet rs2 = ps2.executeQuery()) {

                                if (rs2.next()) {
                                    teamID = rs2.getInt("team_id");
                                    isPartOfTeam = true;

                                    //get name of team 
                                    String query3 = "SELECT * FROM teams WHERE team_id = ?";
                                    try (PreparedStatement ps3 = con.prepareStatement(query3)) {
                                        ps3.setInt(1, teamID);
                                        try (ResultSet rs3 = ps3.executeQuery()) {

                                            if (rs3.next()) {
                                                teamName = rs3.getString("team_name");
                                            }
                                        }

                                    }

                                }
                            }
                        }
                    }
                }
            }

            //Put values in CurrentSession
            CurrentSession.setAccountID(accountID);
            CurrentSession.setAccountType(accountType);
            CurrentSession.setContact(contact);
            CurrentSession.setEmail(inputEmail);
            CurrentSession.setFirstName(firstName);
            CurrentSession.setLastName(lastName);
            CurrentSession.setUserName(userName);
            CurrentSession.setTeamID(teamID);
            CurrentSession.setTeamName(teamName);
            CurrentSession.setIsPartOfTeam(isPartOfTeam);
            
            
        } catch (SQLException e) {
            throw new FailureException(e.getMessage());
        }

    }
    //method to add a new Normal account in database

    public static void addNormalAccount(NormalAccount account) throws FailureException {
        if (con == null) {
            throw new FailureException("Database connection failed!");
        }

        //add a logic to insert Account Details in database
        String insertAccountQuery = "INSERT INTO accounts (first_name, last_name, username, contact_num, email, password, account_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(insertAccountQuery, Statement.RETURN_GENERATED_KEYS)) {
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
            } else if (affectedRows > 0) {
                con.commit();// Commit transaction if both inserts are successful
            }

        } catch (SQLException e) {
            throw new FailureException(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }

            } catch (SQLException e) {
                throw new FailureException(e.getMessage());
            }

        }
    }

    //method to add a new Normal account in database
    public static void addManagerAccount(ManagerAccount account) throws FailureException {
        if (con == null) {
            throw new FailureException("Database connection failed!");
        }

        //add a logic to insert Account Details in database
        String insertAccountQuery = "INSERT INTO accounts (first_name, last_name, username, contact_num, email, password, account_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(insertAccountQuery, Statement.RETURN_GENERATED_KEYS)) {
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
                PreparedStatement ps2 = con.prepareStatement(insertTeamQuery, Statement.RETURN_GENERATED_KEYS);
                ps2.setString(1, account.getManagedTeam().getTeamName());
                ps2.setInt(2, managerID);

                int rowsInserted = ps2.executeUpdate();
                if (rowsInserted > 0) {
                    con.commit();

                } else {
                    con.rollback(); //incase of managerAccounts insertion failed
                    throw new FailureException("Insertion into Database Failed");
                }

            } else {
                con.rollback(); //Rollback if account_id couldn't be generated
                throw new FailureException("Manager ID could not be generated");
            }

        } catch (SQLException e) {
            throw new FailureException(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }

            } catch (SQLException e) {
                throw new FailureException(e.getMessage());
            }

        }
    }
    
    //Method to update userName
    public static void updateUserName(int accountID, String newUserName) throws FailureException {
        if (con == null) {
            throw new FailureException("Database connection failed!");
        }
        
        //logic to update username in database
        String query= "UPDATE accounts SET username = ? WHERE account_id = ?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, newUserName);
            ps.setInt(2, accountID);
            int rowsUpdated = ps.executeUpdate();
                
                if(rowsUpdated > 0){
                    CurrentSession.setUserName(newUserName);
                }
                else{
                    throw new FailureException("Failed to update username");
                    
                }
                
            
            
        }catch(SQLException e){
             throw new FailureException(e.getMessage());
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
