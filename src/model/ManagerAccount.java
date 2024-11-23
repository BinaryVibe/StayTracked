
package model;

public class ManagerAccount extends Account {
    private String managerName;
    private Team managedTeam;
    
    
    @Override
    public void viewDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void addMembers(NormalAccount member){
        //Check is that account already exist in the list of teamMembers.
        //Check if normalAccount with that ID exist.
        //Check if it's already part of some team.
        //Then add it to team.
    }
    
    public void removeMembers(NormalAccount member){
        //Check is that account already exist in the list of teamMembers.
        //Set isPartOfTeam to False for that accountID.
        //Then add it to team.
    }
    
    private void createTeam(String teamName, String teamID){
        //Check if Manager is already managing any team.
        //Then create a team.
    }
}
