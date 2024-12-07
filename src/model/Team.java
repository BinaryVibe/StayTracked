
package model;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private int teamID;
    
    ArrayList<NormalAccount> teamMembers = new ArrayList<>();
    

   
    public void viewDetails() {
     //View Details of Team Account.   
    }
    
    public void addTeamMember(NormalAccount member){
        //add a member
    }
    public void removeTeamMember(NormalAccount member){
        //remove members
    }
    public void showTeamMembers(){
        // shows a list of All existing team members
    }
    
}
