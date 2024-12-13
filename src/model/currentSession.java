
package model;

public class currentSession {
    
    private static int accountID = 0;
    private static int teamID = 0;
    
    private static String userName = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String email = "";
    private static String contact = "";
    private static String accountType = ""; 
    private static String teamName = "Not joined ";
    
    private static Boolean isPartOfTeam = false;

    
    //getters
    public static int getTeamID() {
        return teamID;
    }

    public static String getAccountType() {
        return accountType;
    }

    public static String getTeamName() {
        return teamName;
    }

    public static Boolean getIsPartOfTeam() {
        return isPartOfTeam;
    }
   
    public static int getAccountID() {
        return accountID;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getContact() {
        return contact;
    }

    public static void setTeamID(int teamID) {
        currentSession.teamID = teamID;
    }

    public static void setAccountType(String accountType) {
        currentSession.accountType = accountType;
    }

    public static void setTeamName(String teamName) {
        currentSession.teamName = teamName;
    }

    public static void setIsPartOfTeam(Boolean isPartOfTeam) {
        currentSession.isPartOfTeam = isPartOfTeam;
    }
    
    public static void setAccountID(int accountID) {
        currentSession.accountID = accountID;
    }

    public static void setUserName(String userName) {
        currentSession.userName = userName;
    }

    public static void setFirstName(String firstName) {
        currentSession.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        currentSession.lastName = lastName;
    }

    public static void setEmail(String email) {
        currentSession.email = email;
    }

    public static void setContact(String contact) {
        currentSession.contact = contact;
    }
    
    
    
}
