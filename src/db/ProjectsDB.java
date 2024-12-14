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
import java.time.LocalDate;
import java.util.ArrayList;
import model.Priority;
import model.Status;
import helper.CurrentSession;

/**
 *
 * @author samtheradiant
 */
public class ProjectsDB {

    // TODO: Decide whether to add static initialization blocks or not
    static Connection conn = DBConnectionManager.con;

    // Queries
    private static final String insertProject = "INSERT INTO projects (title, description, status, priority, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String assignUserID = "INSERT INTO assigned_to VALUES (?, ?)";
    private static final String getProjectList = "SELECT project_id, title, start_date, end_date, status, priority FROM projects WHERE project_id IN (SELECT project_id FROM assigned_to WHERE account_id = ?);";
    private static final String getNewProject = "SELECT title, start_date, end_date, status, priority FROM projects WHERE project_id = ?";

    // For newly created projects at runtime  
    private static ArrayList<Integer> newProjectIDs = new ArrayList<>();
    // For projects extracted at runtime
    private static ArrayList<Integer> projectIDs = new ArrayList<>();

    public static void save(Project project) throws FailureException {
        try (PreparedStatement saveStmnt = conn.prepareStatement(insertProject, Statement.RETURN_GENERATED_KEYS); PreparedStatement assignStmnt = conn.prepareStatement(assignUserID)) {
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
            } else {
                conn.rollback();
                throw new FailureException("Insert did not work in projects table!");
            }
            newProjectIDs.add(projectId);

            assignStmnt.setInt(1, CurrentSession.getAccountID());
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

    public static ArrayList<Project> getProjects() throws FailureException {
        ArrayList<Project> projects = new ArrayList<>();
        try (PreparedStatement listProjectsStmnt = conn.prepareStatement(getProjectList)) {
            //conn.setAutoCommit(false);
            listProjectsStmnt.setInt(1, CurrentSession.getAccountID());
            try (ResultSet list = listProjectsStmnt.executeQuery()) {
                if (!list.isBeforeFirst()) {
                    throw new FailureException("Error: No data");
                }
                while (list.next()) {
                    int project_id = list.getInt(1);
                    String title = list.getString(2);
                    LocalDate startDate = list.getDate(3).toLocalDate();
                    LocalDate endDate = list.getDate(4).toLocalDate();
                    Status projectStatus = Status.getEnum(list.getString(5));
                    Priority projectPriority = Priority.getEnum(list.getString(6));
                    
                    
                    projects.add(new Project(title, startDate, endDate, projectStatus, projectPriority));
                    projectIDs.add(project_id);
                }
            } catch (SQLException sqle) {
                //conn.rollback();
                System.err.print(sqle.getMessage());
            }

        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
            if (conn != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    conn.rollback();
                } catch (SQLException sqlexcep) {
                    System.err.print(sqlexcep.getMessage());
                }
            }
        }
        return projects;
    }

    public static ArrayList<Project> getNewProjects() throws FailureException {
        ArrayList<Project> projects = new ArrayList<>();
        ArrayList<Integer> tempIDs = new ArrayList<>();
        if (newProjectIDs.isEmpty()) {
            throw new FailureException("Already updated to latest project");
        }
        try (PreparedStatement newProjectStmnt = conn.prepareStatement(getNewProject)) {
            for (int id : newProjectIDs) {
                newProjectStmnt.setInt(1, id);
                try (ResultSet list = newProjectStmnt.executeQuery()) {
                    while (list.next()) {
                        String title = list.getString(1);
                        LocalDate startDate = list.getDate(2).toLocalDate();
                        LocalDate endDate = list.getDate(3).toLocalDate();
                        Status projectStatus = Status.getEnum(list.getString(4));
                        Priority projectPriority = Priority.getEnum(list.getString(5));

                        projects.add(new Project(title, startDate, endDate, projectStatus, projectPriority));
                        tempIDs.add(id);
                    }
                } catch (SQLException ex) {
                    throw new FailureException(ex.getMessage());
                }
            }
            for (int id : tempIDs) {
                projectIDs.add(newProjectIDs.remove(newProjectIDs.indexOf(id)));
            }
        } catch (SQLException ex) {
            throw new FailureException(ex.getMessage());
        }
        return projects;
    }

    public static int getTotalProjects() {
        return 10;
    }

    public static int getDoneProjects() {
        return 7;
    }
}
