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
    private static final String dashboardDataQuery = "SELECT p.title AS 'project_title', COUNT(task_id) AS 'total_tasks', COUNT(CASE WHEN t.status = 'DONE' THEN 1 END) AS 'done_tasks' FROM projects p LEFT JOIN tasks t ON p.project_id = t.project_id WHERE p.project_id IN (SELECT project_id FROM assigned_to WHERE account_id = ?) GROUP BY p.project_id, p.title";
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
            saveStmnt.setString(1, task.getDesc());
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
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                throw ex;
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
            }
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
                }
            }
            for (int id : tempIDs) {
                taskIDs.add(newTaskIDs.remove(newTaskIDs.indexOf(id)));
            }
        }
        return tasks;
    }

    public static void deleteTasks(ArrayList<Integer> trashTasksQuery) throws SQLException {
        DatabaseUtils.deleteRows(deleteTasksQuery, trashTasksQuery);
    }

    public static void updateDesc(int targetTaskID, String desc) throws SQLException {
        DatabaseUtils.updateStringValue(updateDescQuery, targetTaskID, desc, "description");
    }

    public static void updateStartDate(int targetProjectID, LocalDate startDate) throws SQLException {
        DatabaseUtils.updateDateValue(updateStartDateQuery, targetProjectID, startDate, "start");
    }

    public static void updateEndDate(int targetProjectID, LocalDate endDate) throws SQLException {
        DatabaseUtils.updateDateValue(updateEndDateQuery, targetProjectID, endDate, "end");
    }

    public static void updateStatus(int targetTaskID, Status newStatus) throws SQLException {
        DatabaseUtils.updateEnumValue(updateStatusQuery, targetTaskID, newStatus, "status");
    }

    public static void updatePriority(int targetTaskID, Priority newPriority) throws SQLException {
        DatabaseUtils.updateEnumValue(updatePriorityQuery, targetTaskID, newPriority, "priority");
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
            }
        }
        percentage = (done / total) * 100;
        return (int) percentage;
    }
}
