/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import customexceptions.FailureException;
import model.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import model.currentSession;

/**
 *
 * @author samtheradiant
 */
public class ProjectsDB {

    // TODO: Decide whether to add static initialization blocks or not
    static Connection conn = DBConnectionManager.con;
    private static final String insertProject = "INSERT INTO projects (title, description, status, priority, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String assignUserID = "INSERT INTO assigned_to VALUES (?, ?)";

    public static void save(Project project) throws FailureException {
        try (PreparedStatement saveStmnt = conn.prepareStatement(insertProject, Statement.RETURN_GENERATED_KEYS); 
                PreparedStatement assignStmnt = conn.prepareStatement(assignUserID)) {
            conn.setAutoCommit(false);
            saveStmnt.setString(1, project.getTitle());
            saveStmnt.setString(2, project.getDesc());
            saveStmnt.setString(3, project.getStatus());
            saveStmnt.setString(4, project.getPriority());
            saveStmnt.setDate(5, Date.valueOf(project.getStartDate()));
            saveStmnt.setDate(6, Date.valueOf(project.getEndDate()));

            int affectedRows = saveStmnt.executeUpdate();
            int projectId = 0;
            if (affectedRows > 0) {
                try (ResultSet keys = saveStmnt.getGeneratedKeys()) {
                    if (keys.next()) {
                        projectId = keys.getInt(1);
                    }
                } catch (SQLException keyExcep) {
                    System.err.print(keyExcep.getMessage());
                }
            }
            else {
                conn.rollback();
                throw new FailureException("Insert did not work in projects table!");
            }
            
            assignStmnt.setInt(1, currentSession.getAccountID());
            assignStmnt.setInt(2, projectId);
             
            // FK: Foriegn Keys
            int affectedFKRows = assignStmnt.executeUpdate();
            if (!(affectedFKRows > 0)) {
                throw new FailureException("Insert did not work in assigned_to table");
            }
            conn.commit();
        } catch (SQLException sqle) {
            System.err.print(sqle.getMessage());
            if (conn != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    conn.rollback();
                } catch (SQLException sqlexcep) {
                    System.err.print(sqlexcep.getMessage());
                }
            }
        }
    }

    public static Project getProjects() {
        // Add code
        return new Project();
    }

    public static int getTotalProjects() {
        return 10;
    }

    public static int getDoneProjects() {
        return 7;
    }
}
