package model;

public class NormalAccount extends Account {

    private boolean isPartOfTeam; //Delete this.
    private String role = "No team joined yet"; //Refractor Code according to  this as soon as possible

    
        //refractor BOTH constructors and other function which use this constructors 
    
    
    public NormalAccount(boolean isPartOfTeam, String firstName, String lastName, String userName, String contactNum, String email, String password) {
        super(firstName, lastName, userName, contactNum, email, password);
        this.isPartOfTeam = isPartOfTeam;
    }

        //This constructor will be used when we need to get or pass account without password

    public NormalAccount(boolean isPartOfTeam, String firstName, String lastName, String userName, String contactNum, String email) {
        super(firstName, lastName, userName, contactNum, email);
        this.isPartOfTeam = isPartOfTeam;
    }
    
    
    

    public void setIsPartOfTeam(boolean isPartOfTeam) {
        this.isPartOfTeam = isPartOfTeam;
    }

    public boolean isIsPartOfTeam() {
        return isPartOfTeam;
    }

    @Override
    public void viewDetails() {
        //Display Personal Account details
    }

}
