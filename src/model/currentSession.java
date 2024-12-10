
package model;

public class currentSession {
    private static int accountID = 0;
    private static String userName = "Ayaan123";
    private static String firstName = "Ayaan";
    private static String lastName = "Ahmed";
    private static String email = "ayaanahmed@gmail.com";
    private static String contact = "03002455678";
    

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
