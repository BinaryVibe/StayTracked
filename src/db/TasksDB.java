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
import java.time.LocalDate;
import java.util.ArrayList;
import model.DashboardData;
import model.Priority;
import model.Status;
import model.Task;

/**
 *
 * @author samtheradiant
 */
public class TasksDB {

    // ATTRIBUTES
    private static final Connection conn = DBConnectionManager.getConnection();

    // Queries
    private static final String insertTask = "INSERT INTO tasks (description, start_date, end_date, status, priority, project_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String dashboardDataQuery = "SELECT p.title AS 'project_title', COUNT(task_id) AS 'total_tasks', COUNT(CASE WHEN t.status = 'DONE' THEN 1 END) AS 'done_tasks' FROM projects p LEFT JOIN tasks t ON p.project_id = t.project_id WHERE p.project_id IN (SELECT project_id FROM assigned_to WHERE account_id = ?) GROUP BY t.project_id";
    private static final String getTasksQuery = "SELECT task_id, description, start_date, end_date, status, priority FROM tasks WHERE project_id = ?";
    private static final String getNewTaskQuery = "SELECT task_id, description, start_date, end_date, status, priority FROM tasks WHERE task_id = ?";
    private static final String deleteTasksQuery = "DELETE FROM tasks WHERE task_id = ?";
    private static final String updateDescQuery = "UPDATE tasks SET description = ? WHERE task_id = ?";
    private static final String updateStartDateQuery = "UPDATE tasks SET start_date = ? WHERE task_id = ?";
    private static final String updateEndDateQuery = "UPDATE tasks SET end_date = ? WHERE task_id = ?";
    private static final String updateStatusQuery = "UPDATE tasks SET status = ? WHERE task_id = ?";
    private static final String updatePriorityQuery = "UPDATE tasks SET priority = ? WHERE task_id = ?";
    private static final String countTasksQuery = "SELECT t.total, d.done FROM (SELECT COUNT(task_id) AS done FROM tasks WHERE status = 'DONE' AND project_id IN (SELECT project_id FROM assigned_to WHERE account_id = ?)) AS d, (SELECT COUNT(task_id) AS total FROM tasks WHERE project_id IN (SELECT project_id FROM assigned_to WHERE account_id = ?)) AS t";

    // For newly created tasks at runtime  
    private static ArrayList<Integer> newTaskIDs = new ArrayList<>();
    // For tasks extracted from database at runtime
    private static ArrayList<Integer> taskIDs = new ArrayList<>();

    // METHODS
    public static void save(Task task) throws SQLException {
        try (PreparedStatement saveStmnt = conn.prepareStatement(insertTask, Statement.RETURN_GENERATED_KEYS)) {
            conn.setAutoCommit(false);
            saveStmnt.setString(1, task.getDescription());
            saveStmnt.setDate(2, Date.valueOf(task.getStartDate()));
            saveStmnt.setDate(3, Date.valueOf(task.getEndDate()));
            saveStmnt.setString(4, task.getStatus());
            saveStmnt.setString(5, task.getPriority());
            saveStmnt.setInt(6, task.getProjectID());

            int affectedRows = saveStmnt.executeUpdate();
            int taskId = 0;
            if (affectedRows > 0) {
                try (ResultSet keys = saveStmnt.getGeneratedKeys()) {
                    if (keys.next()) {
                        taskId = keys.getInt(1);
                    }
                } catch (SQLException keyExcep) {
                    System.err.print(keyExcep.getMessage());
                }
            } else {
                conn.rollback();
                throw new SQLException("Insert did not work in projects table!");
            }
            newTaskIDs.add(taskId);

            conn.commit();
        } catch (SQLException sqle) {
            throw new SQLException(sqle.getMessage());
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new SQLException(e.getMessage());
            }
        }
    }

    public static ArrayList<DashboardData> getDashboardData() throws FailureException {
        if (conn == null) {
            throw new FailureException("Database connection is null");
        }
        ArrayList<DashboardData> data = new ArrayList<>();
        try (PreparedStatement dataStmnt = conn.prepareStatement(dashboardDataQuery)) {
            dataStmnt.setInt(1, CurrentSession.getAccountID());
            try (ResultSet result = dataStmnt.executeQuery()) {
                while (result.next()) {
                    String title = result.getString(1);
                    int totalTasks = result.getInt(2);
                    int doneTasks = result.getInt(3);
                    double percentage = 0.0;
                    if (totalTasks > 0) {
                        percentage = (doneTasks / totalTasks) * 100;
                    }
                    data.add(new DashboardData(title, totalTasks, doneTasks, (int) percentage));
                }
            }

        } catch (SQLException ex) {
            throw new FailureException(ex.getMessage());
        }
        return data;
    }

    public static ArrayList<Task> getTasks(int projectID) throws SQLException {
        if (conn == null) {
            throw new SQLException("Database connection is null");
        }
        ArrayList<Task> tasks = new ArrayList<>();
        try (PreparedStatement getTasksStmnt = conn.prepareStatement(getTasksQuery)) {
            getTasksStmnt.setInt(1, projectID);
            try (ResultSet result = getTasksStmnt.executeQuery()) {
                if (!result.isBeforeFirst()) {
                    return null;
                }
                while (result.next()) {
                    int task_id = result.getInt(1);
                    String desc = result.getString(2);
                    LocalDate startDate = result.getDate(3).toLocalDate();
                    LocalDate endDate = result.getDate(4).toLocalDate();
                    Status taskStatus = Status.getEnum(result.getString(5));
                    Priority taskPriority = Priority.getEnum(result.getString(6));

                    tasks.add(new Task(task_id, desc, taskStatus, startDate, endDate, taskPriority));
                    taskIDs.add(task_id);
                }
            } catch (SQLException sqle) {
                throw new SQLException(sqle.getMessage());
            }

        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return tasks;
    }

    public static ArrayList<Task> getNewTasks() throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Integer> tempIDs = new ArrayList<>();
        if (newTaskIDs.isEmpty()) {
            throw new SQLException("Already updated to latest task");
        }
        try (PreparedStatement newProjectStmnt = conn.prepareStatement(getNewTaskQuery)) {
            for (int id : newTaskIDs) {
                newProjectStmnt.setInt(1, id);
                try (ResultSet list = newProjectStmnt.executeQuery()) {
                    while (list.next()) {
                        int taskID = list.getInt(1);
                        String desc = list.getString(2);
                        LocalDate startDate = list.getDate(3).toLocalDate();
                        LocalDate endDate = list.getDate(4).toLocalDate();
                        Status status = Status.getEnum(list.getString(5));
                        Priority priority = Priority.getEnum(list.getString(6));

                        tasks.add(new Task(taskID, desc, status, startDate, endDate, priority));
                        tempIDs.add(id);
                    }
                } catch (SQLException ex) {
                    throw new SQLException(ex.getMessage());
                }
            }
            for (int id : tempIDs) {
                taskIDs.add(newTaskIDs.remove(newTaskIDs.indexOf(id)));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return tasks;
    }

    public static void deleteTasks(ArrayList<Integer> trashProjectIDs) throws FailureException {
        for (int id : trashProjectIDs) {
            try (PreparedStatement deleteStmnt = conn.prepareStatement(deleteTasksQuery)) {
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
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    throw new FailureException(e.getMessage());
                }
            }
        }
    }

    public static void updateDesc(int targetTaskID, String desc) throws SQLException {
        try (PreparedStatement updateStmnt = conn.prepareStatement(updateDescQuery)) {
            conn.setAutoCommit(false);
            updateStmnt.setString(1, desc);
            updateStmnt.setInt(2, targetTaskID);
            int affectedRows = updateStmnt.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating description failed, no rows affected.");
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

    public static void updateStartDate(int targetProjectID, LocalDate startDate) throws SQLException {
        try (PreparedStatement updateStmnt = conn.prepareStatement(updateStartDateQuery)) {
            conn.setAutoCommit(false);
            updateStmnt.setDate(1, Date.valueOf(startDate));
            updateStmnt.setInt(2, targetProjectID);
            int affectedRows = updateStmnt.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating start date failed, no rows affected.");
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

    public static void updateEndDate(int targetProjectID, LocalDate endDate) throws SQLException {
        try (PreparedStatement updateStmnt = conn.prepareStatement(updateEndDateQuery)) {
            conn.setAutoCommit(false);
            updateStmnt.setDate(1, Date.valueOf(endDate));
            updateStmnt.setInt(2, targetProjectID);
            int affectedRows = updateStmnt.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating end date failed, no rows affected.");
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

    public static void updateStatus(int targetProjectID, Status newStatus) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(updateStatusQuery)) {
            conn.setAutoCommit(false);
            pstmt.setString(1, newStatus.name());
            pstmt.setInt(2, targetProjectID);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating status failed, no rows affected.");
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

    public static void updatePriority(int targetProjectID, Priority newPriority) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(updatePriorityQuery)) {
            conn.setAutoCommit(false);
            pstmt.setString(1, newPriority.name());
            pstmt.setInt(2, targetProjectID);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("Updating priority failed, no rows affected.");
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

    public static int getTasksCompletion() throws SQLException {
        if (conn == null) {
            throw new SQLException("Database connection is null");
        }
        double percentage;
        percentage = 0;
        double done = 0, total = 0;
        try (PreparedStatement completionStmnt = conn.prepareStatement(countTasksQuery)) {
            completionStmnt.setInt(1, CurrentSession.getAccountID());
            completionStmnt.setInt(2, CurrentSession.getAccountID());
            try (ResultSet projectsData = completionStmnt.executeQuery()) {
                projectsData.next();
                total = projectsData.getInt(1);
                done = projectsData.getInt(2);
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        percentage = (done / total) * 100;
        return (int) percentage;
    }
}
