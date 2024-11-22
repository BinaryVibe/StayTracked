/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author samtheradiant
 */
public class Project {

    // ATTRIBUTES
    // TODO: Decide whether projectID and assignedTo should be added
    private String title, description;
    private ArrayList<Task> tasks;
    private Status projectStatus;
    private Date startDate, endDate;
    private Priority projectPriority;

    // METHODS
    public Project() {
        this.title = "Untitled";
        this.description = "";
        this.projectStatus = Status.PENDING;
        this.startDate = new Date();
        this.projectPriority = Priority.LOW;
    }

    public Project(String title, String description, ArrayList<Task> tasks, Status projectStatus, Date startDate, Date endDate, Priority projectPriority) {
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectPriority = projectPriority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Status getProjectStatus() {
        return projectStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Priority getProjectPriority() {
        return projectPriority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setProjectStatus(Status projectStatus) {
        this.projectStatus = projectStatus;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        // TODO: Add comparison here or in gui code
        this.endDate = endDate;
    }

    public void setProjectPriority(Priority projectPriority) {
        this.projectPriority = projectPriority;
    }

}
