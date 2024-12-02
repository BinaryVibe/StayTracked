package model;

public abstract class Account {
    protected String firstName, lastName, userName;
    protected String contactNum, email, password;
    protected int accountID;

    public Account(String firstName, String lastName, String userName, String contactNum, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contactNum = contactNum;
        this.email = email;
        this.password = password;
    }
    
    protected void logIn(){
        
    }
    protected void logOut(){
        
    }
    protected void resetPass(){
        
    }
    protected abstract void viewDetails();
}
