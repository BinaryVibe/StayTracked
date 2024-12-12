
package model;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private int teamID;
    
    ArrayList<NormalAccount> teamMembers = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }
    

   
    public void viewDetails() {
     //View Details of Team Account.   
    }
    //getters 

    public String getTeamName() {
        return teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public ArrayList<NormalAccount> getTeamMembers() {
        return teamMembers;
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
