package model;

public class NormalAccount extends Account {

    
    private String role = "No team joined yet"; //Refractor Code according to  this as soon as possible

    
        //refractor BOTH constructors and other function which use this constructors 
    
    
    
    public NormalAccount(String role, String firstName, String lastName, String userName, String contactNum, String email, String password) {
        super(firstName, lastName, userName, contactNum, email, password);
        this.role = role;
    }

    public NormalAccount(String role, String firstName, String lastName, String userName, String contactNum, String email, int accountID) {
        super(firstName, lastName, userName, contactNum, email, accountID);
        this.role = role;
    }

    
    
        //This constructor will be used when we need to get or pass account without password

    public NormalAccount(String role, String firstName, String lastName, String userName, String contactNum, String email) {
        super(firstName, lastName, userName, contactNum, email);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    @Override
    public void viewDetails() {
        //Display Personal Account details
    }

}
