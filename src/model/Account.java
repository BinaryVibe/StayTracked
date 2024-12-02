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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    
    
    
    protected void logIn(){
        
    }
    protected void logOut(){
        
    }
    protected void resetPass(){
        
    }
    protected abstract void viewDetails();
}
