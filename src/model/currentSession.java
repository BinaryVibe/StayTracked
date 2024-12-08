
package model;

public class currentSession {
    private static String accountID;

    public static String getAccountID() {
        return accountID;
    }

    public static void setAccountID(String accountID) {
        currentSession.accountID = accountID;
    }
    
    
}
