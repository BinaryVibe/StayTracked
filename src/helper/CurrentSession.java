
package helper;

public class CurrentSession {
    
    private static int accountID = 0;
    private static int teamID = 0;
    
    private static String userName = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String email = "";
    private static String contact = "";
    private static String accountType = ""; 
    private static String teamName = "Not joined ";
    
    private static String role;

    
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

    public static String getRole() {
        return role;
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

    
    //setters
    public static void setTeamID(int teamID) {
        CurrentSession.teamID = teamID;
    }

    public static void setAccountType(String accountType) {
        CurrentSession.accountType = accountType;
    }

    public static void setTeamName(String teamName) {
        CurrentSession.teamName = teamName;
    }

    public static void setRole(String role) {
        CurrentSession.role = role;
    }
    
    public static void setAccountID(int accountID) {
        CurrentSession.accountID = accountID;
    }

    public static void setUserName(String userName) {
        CurrentSession.userName = userName;
    }

    public static void setFirstName(String firstName) {
        CurrentSession.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        CurrentSession.lastName = lastName;
    }

    public static void setEmail(String email) {
        CurrentSession.email = email;
    }

    public static void setContact(String contact) {
        CurrentSession.contact = contact;
    }
    
    
    
}
