/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package customexceptions;

/**
 *
 * @author samtheradiant
 */
public class InvalidDateException extends Exception {

    /**
     * Creates a new instance of <code>InvalidDateException</code> without detail message.
     */
    public InvalidDateException() {
    }

    /**
     * Constructs an instance of <code>InvalidDateException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDateException(String msg) {
        super(msg);
    }
}
