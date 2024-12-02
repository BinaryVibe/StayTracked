
package customExceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message){
        super(message);
    }
    
     public static void checkInput(String email, String password) throws InvalidInputException {
         
       /* if () {
            throw new InvalidInputException(" Incorrect email OR passwrod! ");
        }*/
    }
}
