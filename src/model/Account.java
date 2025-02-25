package model;

import java.util.ArrayList;

public abstract class Account {
    protected String firstName, lastName, userName;
    protected String contactNum, email, password;
    protected int accountID;

    public Account(String firstName, String lastName, String userName, String contactNum, String email, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contactNum = contactNum;
        this.email = email;
        this.accountID = accountID;
    }
   
    
    
    
    public Account(String firstName, String lastName, String userName, String contactNum, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contactNum = contactNum;
        this.email = email;
        this.password = password;
    }

    
    //This constructor will be used when we need to get or pass account without password

    public Account(String firstName, String lastName, String userName, String contactNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contactNum = contactNum;
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getContactNum() {
        return contactNum;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountID() {
        return accountID;
    }
    
    
    
    
    protected void logIn(){
        
    }
    protected void logOut(){
        
    }
    protected void resetPass(){
        
    }
    protected abstract void viewDetails();
}
