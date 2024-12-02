
package model;

public class NormalAccount extends Account {
    private boolean isPartOfTeam;

    public NormalAccount(boolean isPartOfTeam, String firstName, String lastName, String userName, String contactNum, String email, String password) {
        super(firstName, lastName, userName, contactNum, email, password);
        this.isPartOfTeam = isPartOfTeam;
    }
    
    
    
    @Override
    public void viewDetails() {
       //Display Personal Account details
    }
    
    
    
}
