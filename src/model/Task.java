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
    
    private int projectID;
    private String description;
    private Status taskStatus;
    private LocalDate startDate, endDate;
    private Priority taskPriority;

    public Task() {
        this.description = "";
        this.startDate = LocalDate.now();
        this.taskStatus = Status.PENDING;
        this.taskPriority = Priority.NONE;
    }

    public Task(String description, Status taskStatus, LocalDate startDate, LocalDate endDate, Priority taskPriority) {
        this.description = description;
        this.taskStatus = taskStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskPriority = taskPriority;
    }

    public Task(String description, Status taskStatus, LocalDate startDate, Priority taskPriority) {
        this.description = description;
        this.taskStatus = taskStatus;
        this.startDate = startDate;
        this.taskPriority = taskPriority;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    
    

    public String getDescription() {
        return description;
    }

    public String getTaskStatus() {
        return taskStatus.name();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTaskPriority() {
        return taskPriority.name();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setTaskPriority(Priority taskPriority) {
        this.taskPriority = taskPriority;
    }

}
