/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author samtheradiant
 */
public class DashboardData {
    private String title;
    private int totalTasks;
    private int doneTasks;
    private int percentage;

    public DashboardData(String title, int totalTasks, int doneTasks, int percentage) {
        this.title = title;
        this.totalTasks = totalTasks;
        this.doneTasks = doneTasks;
        this.percentage = percentage;
    }  

    public String getTitle() {
        return title;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public int getDoneTasks() {
        return doneTasks;
    }

    public int getPercentage() {
        return percentage;
    }
    
    
}
