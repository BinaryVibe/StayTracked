
package model;

import java.util.ArrayList;

public class TeamAccount extends Account {
    private String teamName;
    ArrayList<UserAccount> teamMembers = new ArrayList<>();
    

    @Override
    protected void viewDetails() {
     //View Details of Team Account.   
    }
    
    public void addTeamMember(UserAccount member){
        //add a member
    }
    public void removeTeamMember(UserAccount member){
        //remove members
    }
    public void showTeamMembers(){
        // shows a list of All existing team members
    }
    
}
