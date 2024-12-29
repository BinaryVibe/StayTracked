/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import helper.CurrentSession;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author samtheradiant
 */
public class DatabaseUtils {

    protected static Connection conn = DBConnectionManager.getConnection();
    private static final String getAccountType = "SELECT account_type FROM accounts WHERE account_id IN (SELECT account_id FROM assigned_to WHERE project_id = ?) AND account_type = 'Manager'";

    /**
     *
     * @param query The DML query to update a value
     * @param targetID The primary key of the database entity in which the Enum is in
     * @param newValue The new Enum value
     * @param enumName The name of the Enum e.g, priority, task
     * @throws SQLException
     */
    public static void updateEnumValue(String query, int targetID, Enum newValue, String enumName) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);
            ps.setString(1, newValue.name());
            ps.setInt(2, targetID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating " + enumName + " failed, no rows affected.");
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
        }
    }

    /**
     *
     * @param query The DML query to update a value
     * @param targetID The primary key of the database entity in which the String is in
     * @param newValue The new String value
     * @param stringName The name of the String e.g, title, description
     * @throws SQLException
     */
    public static void updateStringValue(String query, int targetID, String newValue, String stringName) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);
            ps.setString(1, newValue);
            ps.setInt(2, targetID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating " + stringName + " failed, no rows affected.");
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
        }
    }

    /**
     *
     * @param query The DML query to update a value
     * @param targetID The primary key of the database entity in which the Date is in
     * @param newValue The new Date value
     * @param dateName The name of the Date e.g, start, end, deadline
     * @throws SQLException
     */
    public static void updateDateValue(String query, int targetID, LocalDate newValue, String dateName) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);
            ps.setDate(1, Date.valueOf(newValue));
            ps.setInt(2, targetID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating " + dateName + " date failed, no rows affected.");
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
        }
    }

    public static int getWorkCompletion(String query) throws SQLException {
        if (conn == null) {
            throw new SQLException("Database connection is null");
        }
        double percentage;
        percentage = 0;
        double done = 0, total = 0;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, CurrentSession.getAccountID());
            ps.setInt(2, CurrentSession.getAccountID());
            try (ResultSet projectsData = ps.executeQuery()) {
                projectsData.next();
                total = projectsData.getInt(1);
                done = projectsData.getInt(2);
            }
        }
        percentage = (done / total) * 100;
        return (int) percentage;
    }

    public static void deleteRows(String query, ArrayList<Integer> ids) throws SQLException {
        for (int id : ids) {
            try (PreparedStatement deleteStmnt = conn.prepareStatement(query)) {
                conn.setAutoCommit(false);
                deleteStmnt.setInt(1, id);
                int affectedRows = deleteStmnt.executeUpdate();
                if (!(affectedRows > 0)) {
                    conn.rollback();
                    throw new SQLException("Could not delete project. (ID: " + id + ")");
                }
            } finally {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    throw new SQLException(e.getMessage());
                }
            }
        }
    }

    public static boolean checkPermission(int projectID) throws SQLException {
        try (PreparedStatement checkStmnt = conn.prepareStatement(getAccountType)) {
            checkStmnt.setInt(1, projectID);
            try (ResultSet result = checkStmnt.executeQuery()) {
                if (!(result.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
