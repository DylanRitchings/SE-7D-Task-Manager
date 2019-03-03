package v1;

import java.util.*;

/**
 *
 * @author Konstantin Georgiev
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Integer userID;
    private String userName;
    private String password;
    private Integer numTasksDone;
    private ArrayList<String> bestSkills;
    
    public User (String u_FName, String u_LName, String u_Email, 
                 Integer u_UserID, String u_UserName, String u_Password, 
                 Integer u_NumTasksDone, ArrayList<String> u_BestSkills) {
        
        firstName = u_FName;
        lastName = u_LName;
        email = u_Email;
        userID = u_UserID;
        userName = u_UserName;
        password = u_Password;
        numTasksDone = u_NumTasksDone;
        bestSkills = u_BestSkills;
    }
}
