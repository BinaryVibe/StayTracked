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

    // Attributes
    private static Connection conn = DBConnectionManager.getConnection();

    // Queries
    private static final String insertProjectQuery = "INSERT INTO projects (title, description, status, priority, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String assignUserIDQuery = "INSERT INTO assigned_to VALUES (?, ?)";
    private static final String getProjectsQuery = "SELECT project_id, title, start_date, end_date, status, priority FROM projects WHERE project_id IN (SELECT project_id FROM assigned_to WHERE account_id = ?);";
    private static final String getNewProjectQuery = "SELECT project_id, title, start_date, end_date, status, priority FROM projects WHERE project_id = ?";
    private static final String countProjectsQuery = "SELECT t.total, d.done FROM (SELECT COUNT(project_id) AS total FROM projects WHERE project_id IN (SELECT project_id FROM assigned_to WHERE account_id =  ?)) AS t, (SELECT COUNT(project_id) AS done FROM projects WHERE status = 'DONE' AND project_id IN (SELECT project_id FROM assigned_to WHERE account_id = ?)) AS d";
    // private static final String searchTitlesQuery = "SELECT title FROM projects WHERE project_id IN (?)";
    private static final String deleteProjectsQuery = "DELETE FROM projects WHERE project_id = ?";

    // For newly created projects at runtime  
    private static ArrayList<Integer> newProjectIDs = new ArrayList<>();
    // For projects extracted from database at runtime
    private static ArrayList<Integer> projectIDs = new ArrayList<>();

    // METHODS
    public static void save(Project project) throws FailureException {
        try (PreparedStatement saveStmnt = conn.prepareStatement(insertProjectQuery, Statement.RETURN_GENERATED_KEYS); PreparedStatement assignStmnt = conn.prepareStatement(assignUserIDQuery)) {
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
                conn.rollback();
                throw new FailureException("Insert did not work in assigned_to table");
            }
            conn.commit();
        } catch (SQLException sqle) {
            throw new FailureException(sqle.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                throw new FailureException(e.getMessage());
            }
        }
    }

    public static ArrayList<Project> getProjects() throws FailureException {
        if (conn == null) {
            throw new FailureException("Database connection is null");
        }
        ArrayList<Project> projects = new ArrayList<>();
        try (PreparedStatement listProjectsStmnt = conn.prepareStatement(getProjectsQuery)) {
            listProjectsStmnt.setInt(1, CurrentSession.getAccountID());
            try (ResultSet list = listProjectsStmnt.executeQuery()) {
                if (!list.isBeforeFirst()) {
                    return null;
                }
                while (list.next()) {
                    int project_id = list.getInt(1);
                    String title = list.getString(2);
                    LocalDate startDate = list.getDate(3).toLocalDate();
                    LocalDate endDate = list.getDate(4).toLocalDate();
                    Status projectStatus = Status.getEnum(list.getString(5));
                    Priority projectPriority = Priority.getEnum(list.getString(6));

                    projects.add(new Project(project_id, title, startDate, endDate, projectStatus, projectPriority));
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
        try (PreparedStatement newProjectStmnt = conn.prepareStatement(getNewProjectQuery)) {
            for (int id : newProjectIDs) {
                newProjectStmnt.setInt(1, id);
                try (ResultSet list = newProjectStmnt.executeQuery()) {
                    while (list.next()) {
                        int projectID = list.getInt(1);
                        String title = list.getString(2);
                        LocalDate startDate = list.getDate(3).toLocalDate();
                        LocalDate endDate = list.getDate(4).toLocalDate();
                        Status projectStatus = Status.getEnum(list.getString(5));
                        Priority projectPriority = Priority.getEnum(list.getString(6));

                        projects.add(new Project(projectID, title, startDate, endDate, projectStatus, projectPriority));
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

    public static int getProjectCompletion() throws FailureException {
        if (conn == null) {
            throw new FailureException("Database connection is null");
        }
        double percentage;
        percentage = 0;
        double done = 0, total = 0;
        try (PreparedStatement completionStmnt = conn.prepareStatement(countProjectsQuery)) {
            completionStmnt.setInt(1, CurrentSession.getAccountID());
            completionStmnt.setInt(2, CurrentSession.getAccountID());
            try (ResultSet projectsData = completionStmnt.executeQuery()) {
                projectsData.next();
                total = projectsData.getInt(1);
                done = projectsData.getInt(2);
            } catch (SQLException ex) {
                throw new FailureException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new FailureException(ex.getMessage());
        }
        percentage = (done / total) * 100;
//        System.out.println(total);
//        System.out.println(done);
//        System.out.println(percentage);
        return (int) percentage;
    }

    public static void deleteProjects(ArrayList<Integer> trashProjectIDs) throws FailureException {
        for (int id : trashProjectIDs) {
            try (PreparedStatement deleteStmnt = conn.prepareStatement(deleteProjectsQuery)) {
                conn.setAutoCommit(false);
                deleteStmnt.setInt(1, id);
                int affectedRows = deleteStmnt.executeUpdate();
                if (!(affectedRows > 0)) {
                    conn.rollback();
                    throw new FailureException("Could not delete project. (ID: " + id + ")");
                }
            } catch (SQLException ex) {
                throw new FailureException(ex.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.setAutoCommit(true);
                    }
                } catch (SQLException e) {
                    throw new FailureException(e.getMessage());
                }
            }
        }
    }

//    public static boolean searchDuplicateTitle(String title) throws FailureException {
//        boolean found = false;
//        try (PreparedStatement searchStmnt = conn.prepareStatement(searchTitles)) {
//            for (int id : projectIDs) {
//                searchStmnt.setInt(1, id);
//                try (ResultSet result = searchStmnt.executeQuery()) {
//                    result.next();
//                    if (title.equalsIgnoreCase(result.getString(1))) {
//                        found = true;
//                    }
//                }
//                catch (SQLException ex) {
//                    throw new FailureException(ex.getMessage());
//                }
//            }
//            
//        } catch (SQLException ex) {
//            throw new FailureException(ex.getMessage());
//        }
//        return found;
//    }
}
