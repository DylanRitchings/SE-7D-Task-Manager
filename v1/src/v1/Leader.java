package v1;
import database_console.DBConnect;
import java.util.*;

/**
 * @author up818044, Dylan Ritchings
 * @version 1
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
    * @param memberID the ID of the member within the database to be removed
    * @param groupID the ID of the group within the database from which the member is getting removed
    */
    public static void deleteMember(int memberID, int groupID){
        
        String statement = "DELETE FROM user_in_group WHERE User_ID = " + memberID + " AND group_ID = " + groupID;
        DBConnect.databaseInput(statement);
    }
        
    /**
    *  Assign a task to a member
    * @param taskID ID of the task within the database which is to be assigned
    * @param groupID ID of the group within the database which the task is going to be in
    * @param userID ID of the user within the database to who the task is going to be assigned
    */

    public static void assignTaskToMember(int taskID, int groupID, int userID)
    {
        String statement = "INSERT INTO User_Member_Group VALUES("+ taskID + "," +groupID+ "," +userID+");";

        DBConnect.databaseInput(statement);
    }
}

