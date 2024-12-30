/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a project in the app.
 * While tasks are related to a project, this class
 * does not hold any variable to store them.
 *
 * @author samtheradiant
 */
public class Project extends WorkItem {

    // ATTRIBUTES
    private String title;
    // Holds ids of team members if project is assigned to anyone at creation.
    // These ids are primary keys of team members in the database
    private ArrayList<Integer> assignedTo;

    // METHODS
    /**
     * T
     * 
     * @param title The title of the project
     * @param desc The description of the project
     * @param projectStatus The completion status of the project
     * @param startDate The start date of the project
     * @param endDate The end date of the project
     * @param projectPriority The priority level of the project
     * @param assignedTo The ids, which were taken from database, of team members 
     */
    public Project(String title, String desc, Status projectStatus, LocalDate startDate, LocalDate endDate, Priority projectPriority, ArrayList<Integer> assignedTo) {
        super(desc, projectStatus, startDate, endDate, projectPriority);
        this.title = title;
        this.assignedTo = assignedTo;
    }

    public Project(String title, String desc, Status projectStatus, LocalDate startDate, LocalDate endDate, Priority projectPriority) {
        super(desc, projectStatus, startDate, endDate, projectPriority);
        this.title = title;
    }

    public Project(String title, String desc, Status projectStatus, LocalDate startDate, Priority projectPriority) {
        super(desc, projectStatus, startDate, projectPriority);
        this.title = title;
    }

    public Project(int projectID, String title, LocalDate startDate, LocalDate endDate, Status projectStatus, Priority projectPriority) {
        super(projectID, projectStatus, startDate, endDate, projectPriority);
        this.title = title;
        
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Integer> getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(ArrayList<Integer> assignedTo) {
        this.assignedTo = assignedTo;
    }

}
