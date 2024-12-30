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
public class Project extends WorkItem {

    // ATTRIBUTES
    // TODO: Decide whether assignedTo should be added
    private String title;
    private ArrayList<Integer> assignedTo;

    // METHODS
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
