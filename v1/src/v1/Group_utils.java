/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.util.*;
import database_console.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dylan Ritchings
 */
public class Group_utils {
    protected String  groupName;
    protected ArrayList<String> memberList;
    protected String groupDescription;
    protected int groupId;
    protected ArrayList<String> groupTasks;
    protected ArrayList<String> groupSkills;
    
    public Group_utils() {   /*  Creates a new instance of groups_utils */
    }
    public Group_utils(String name, ArrayList<String> members, String description, int Id, ArrayList<String> tasks, ArrayList<String> skills){
       groupName = name;
       memberList = members;
       groupId = Id;
       groupTasks = tasks;
       groupSkills = skills;
       
    }
    
    /**
     * Creates an ArrayList of memberIDs that are in a group.
     * @param groupID
     * @return ArrayList
     * @throw Exception
     * @pre 
     * @modifies 
     * @post 
     * @bound 
     *
     */

    public static ArrayList getMemberIDs(int groupID)
    {
        String query = "SELECT User_ID FROM user_in_group WHERE Group_ID =" + groupID+";";
        
        //Send query to DBConnect
        ResultSet userIDrs = DBConnect.databaseSelect(query);
        ArrayList<String> userIDList;
        userIDList = new ArrayList<>();
        
        try {
            //Loop through userID result set and input user IDs into array list
            while (userIDrs.next()) {
                userIDList.add(userIDrs.getString("User_ID"));
            }
            return userIDList;
        } catch (Exception ex) {
            Logger.getLogger(Group_utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        

        
    }
}
