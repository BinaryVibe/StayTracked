/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author samtheradiant
 */
public enum Priority {
    NONE,
    LOW,
    MEDIUM,
    HIGH;
    
    public static Priority getEnum(String value) {
        switch (value) {
            case "NONE":
                return NONE;
            case "LOW":
                return LOW;
            case "MEDIUM":
                return MEDIUM;
            case "HIGH":
                return HIGH;
        }
        return NONE;
    }
}
