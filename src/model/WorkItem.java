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
public class WorkItem {

    private int id;
    private String desc;
    private Status status;
    private LocalDate startDate, endDate;
    private Priority priority;

    public WorkItem(int id, String desc, Status status, LocalDate startDate, LocalDate endDate, Priority priority) {
        this.id = id;
        this.desc = desc;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
    }

    public WorkItem(String desc, Status status, LocalDate startDate, Priority priority) {
        this.desc = desc;
        this.status = status;
        this.startDate = startDate;
        this.priority = priority;
    }

    public WorkItem(String desc, Status status, LocalDate startDate, LocalDate endDate, Priority priority) {
        this.desc = desc;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
    }

    public WorkItem(int id, Status status, LocalDate startDate, LocalDate endDate, Priority priority) {
        this.id = id;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPriority() {
        return priority.name();
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

}
