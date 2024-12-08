/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author samtheradiant
 */
public enum Status {
    PENDING,
    IN_PROGRESS,
    DONE;
    
    public static Status getEnum(String value) {
        switch (value) {
            case "PENDING":
                return PENDING;
            case "IN_PROGRESS":
                return IN_PROGRESS;
            case "DONE":
                return DONE;
        }
        return PENDING;
    }
}
