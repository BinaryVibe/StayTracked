/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import customexceptions.FailureException;
import helper.CurrentSession;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import model.Task;

/**
 *
 * @author samtheradiant
 */
public class TasksDB {

    // ATTRIBUTES
    
    private static final Connection conn = DBConnectionManager.con;
    
    // Queries
    private static final String insertTask = "INSERT INTO tasks (description, start_date, end_date, status, priority, project_id) VALUES (?, ?, ?, ?, ?, ?)";

    // METHODS
    public static void save(Task task) throws FailureException {
        try (PreparedStatement saveStmnt = conn.prepareStatement(insertTask, Statement.RETURN_GENERATED_KEYS)) {
            conn.setAutoCommit(false);
            saveStmnt.setString(1, task.getDescription());
            saveStmnt.setDate(2, Date.valueOf(task.getStartDate()));
            saveStmnt.setDate(3, Date.valueOf(task.getEndDate()));
            saveStmnt.setString(4, task.getTaskStatus());
            saveStmnt.setString(5, task.getTaskPriority());
            saveStmnt.setInt(6, task.getProjectID());

            int affectedRows = saveStmnt.executeUpdate();
            // int projectId = 0;
            if (affectedRows > 0) {
                // pass for now
            } else {
                conn.rollback();
                throw new FailureException("Insert did not work in projects table!");
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
}
