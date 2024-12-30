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
public class Task extends WorkItem {

    private int projectID;

    public Task(int taskID, String description, Status taskStatus, LocalDate startDate, LocalDate endDate, Priority taskPriority, int projectID) {
        super(taskID, taskStatus, startDate, endDate, taskPriority);
        this.projectID = projectID;
    }

    public Task(String description, Status taskStatus, LocalDate startDate, LocalDate endDate, Priority taskPriority, int projectID) {
        super(description, taskStatus, startDate, endDate, taskPriority);
        this.projectID = projectID;
    }

    public Task(String description, Status taskStatus, LocalDate startDate, Priority taskPriority, int projectID) {
        super(description, taskStatus, startDate, taskPriority);
        this.projectID = projectID;
    }

    public Task(int taskID, String description, Status taskStatus, LocalDate startDate, LocalDate endDate, Priority taskPriority) {
        super(taskID, description, taskStatus, startDate, endDate, taskPriority);
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

}
