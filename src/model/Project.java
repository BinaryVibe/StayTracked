/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

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
    
    // METHODS

    public Project(String title, String description, ArrayList<Task> tasks, Status projectStatus) {
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.projectStatus = projectStatus;
    }
    
    
}
