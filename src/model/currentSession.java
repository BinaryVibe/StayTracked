
package model;

public class currentSession {
    private static String accountID;
    private static String userName;
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String contact;
    

    public static String getAccountID() {
        return accountID;
    }

    public static void setAccountID(String accountID) {
        currentSession.accountID = accountID;
    }
    
    
}
