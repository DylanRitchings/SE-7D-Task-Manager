package v1;
import database_console.DBConnect;
import java.util.*;

/**
 * @since 
 * @author up818044, Dylan Ritchings
 * @version 1
 * @see

 */
public class Leader 
{
    private ArrayList<String> groupList;
    
    public Leader (ArrayList<String> list_of_group)
    {
        groupList = list_of_group;
    }
    
    /**
    *  Remove a member from a group
    * @param memberID
    * @param groupID
    * @throw 
    * @pre 
    * @modifies 
    * @post 
    * @bound 
    */
    public void deleteMember(int memberID, int groupID){
        
        String statement = "DELETE FROM user_in_group WHERE User_ID = " + memberID + " AND group_ID = " + groupID;
        DBConnect.databaseInput(statement);
    }
        
    /**
    *  Assign a task to a member
    * @param taskID
    * @param groupID
    * @param userID
    * @throw 
    * @pre 
    * @modifies 
    * @post 
    * @bound 
    */

    public static void assignTaskToMember(int taskID, int groupID, int userID)
    {
        String statement = "INSERT INTO User_Member_Group VALUES("+ taskID + "," +groupID+ "," +userID+");";

        DBConnect.databaseInput(statement);
    }
}

