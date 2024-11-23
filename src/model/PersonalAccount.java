
package model;

public class PersonalAccount extends Account {
    
    private String contactNum;
    private UserAccount User = new UserAccount();
    
    @Override
    protected void viewDetails() {
       //Display Personal Account details
    }
    
    
    
}
