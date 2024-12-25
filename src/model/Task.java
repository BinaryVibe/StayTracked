/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author samtheradiant
 */
public class Task {
    
    private int taskID;
    private int projectID;
    private String description;
    private Status status;
    private LocalDate startDate, endDate;
    private Priority priority;

    public Task() {
        this.description = "";
        this.startDate = LocalDate.now();
        this.status = Status.PENDING;
        this.priority = Priority.NONE;
    }

    public Task(int taskID, String description, Status taskStatus, LocalDate startDate, LocalDate endDate, Priority taskPriority, int projectID) {
        this.description = description;
        this.status = taskStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = taskPriority;
        this.projectID = projectID;
    }

    public Task(String description, Status taskStatus, LocalDate startDate, LocalDate endDate, Priority taskPriority, int projectID) {
        this.projectID = projectID;
        this.description = description;
        this.status = taskStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = taskPriority;
    }
    
    

    public Task(String description, Status taskStatus, LocalDate startDate, Priority taskPriority, int projectID) {
        this.description = description;
        this.status = taskStatus;
        this.startDate = startDate;
        this.priority = taskPriority;
        this.projectID = projectID;
    }

    public Task(int taskID, String description, Status taskStatus, LocalDate startDate, LocalDate endDate, Priority taskPriority) {
        this.taskID = taskID;
        this.description = description;
        this.status = taskStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = taskPriority;
    }
    
    

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    
    
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    
    

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status.name();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getPriority() {
        return priority.name();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

}
