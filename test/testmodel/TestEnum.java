/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testmodel;

import model.Project;
import model.Status;

/**
 *
 * @author samtheradiant
 */
public class TestEnum {
    public static void main(String[] args) {
        Project test = new Project();
        test.setStatus(Status.PENDING);
        System.out.println(test.getStatus());
    }
}
