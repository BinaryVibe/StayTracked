/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author samtheradiant
 */
public class Project {

    // ATTRIBUTES
    // TODO: Decide whether assignedTo should be added
    private int projectID;
    private String title, desc;
    private ArrayList<Task> tasks;
    private Status projectStatus;
    private LocalDate startDate, endDate;
    private Priority projectPriority;

    // METHODS
    public Project() {
        this.title = "Untitled";
        this.desc = "";
        this.projectStatus = Status.PENDING;
        this.startDate = LocalDate.now();
        this.projectPriority = Priority.NONE;
    }

    public Project(String title, String description, ArrayList<Task> tasks, Status projectStatus, LocalDate startDate, LocalDate endDate, Priority projectPriority) {
        this.title = title;
        this.desc = description;
        this.tasks = tasks;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectPriority = projectPriority;
    }

    public Project(String title, String desc, Status projectStatus, LocalDate startDate, LocalDate endDate, Priority projectPriority) {
        this.title = title;
        this.desc = desc;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectPriority = projectPriority;
    }

    public Project(String title, String desc, Status projectStatus, LocalDate startDate, Priority projectPriority) {
        this.title = title;
        this.desc = desc;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.projectPriority = projectPriority;
    }

    public Project(String title, LocalDate startDate, LocalDate endDate, Status projectStatus, Priority projectPriority) {
        this.title = title;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectPriority = projectPriority;
    }
    
    

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Status getProjectStatus() {
        return projectStatus;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Priority getProjectPriority() {
        return projectPriority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setProjectStatus(Status projectStatus) {
        this.projectStatus = projectStatus;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setProjectPriority(Priority projectPriority) {
        this.projectPriority = projectPriority;
    }

    public void setStatus(Status projectStatus) {
        this.projectStatus = projectStatus;
    }
    
    public String getStatus() {
        return projectStatus.name();
    }
    
    public String getPriority() {
        return projectPriority.name();
    }
    
}
