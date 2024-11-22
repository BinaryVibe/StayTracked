/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author samtheradiant
 */
public class Task {

    private String title, description;
    private Status taskStatus;
    private Date startDate, endDate;
    private Priority taskPriority;

    public Task() {
        this.title = "Untitled";
        this.description = "";
        this.startDate = new Date();
        this.taskStatus = Status.PENDING;
        this.taskPriority = Priority.NONE;
    }

    public Task(String title, String description, Status taskStatus, Date startDate, Date endDate, Priority taskPriority) {
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskPriority = taskPriority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Priority getTaskPriority() {
        return taskPriority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTaskPriority(Priority taskPriority) {
        this.taskPriority = taskPriority;
    }

}
