package model;

public abstract class Account {
    protected String firstName, lastName, userName;
    protected String accountID, contactNum, email, password;
    
    protected void logIn(){
        
    }
    protected void logOut(){
        
    }
    protected void resetPass(){
        
    }
    protected abstract void viewDetails();
}
