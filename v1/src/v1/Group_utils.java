/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

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
//    protected String  groupName;
//    protected ArrayList<String> memberList;
//    protected String groupDescription;
//    protected int groupId;
//    protected ArrayList<String> groupTasks;
//    protected ArrayList<String> groupSkills;
//    
//    public Group_utils() {   /*  Creates a new instance of groups_utils */
//    }
//    public Group_utils(String name, ArrayList<String> members, String description, int Id, ArrayList<String> tasks, ArrayList<String> skills){
//       groupName = name;
//       memberList = members;
//       groupId = Id;
//       groupTasks = tasks;
//       groupSkills = skills;
//       
//    }
    
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

    private static ArrayList getMemberIDs(int groupID)
    {
        String query = "SELECT User_ID FROM user_in_group WHERE Group_ID =" + groupID+";";
        
        //Send query to DBConnect
        ResultSet userIDrs = DBConnect.databaseSelect(query);
        ArrayList<String> userIDList;
        userIDList = new ArrayList<>();
        
        try {
            //Iterate through userID result set and input user IDs into array list
            while (userIDrs.next()) {
                userIDList.add(userIDrs.getString("User_ID"));
            }
            userIDrs.close();
            return userIDList;
        } catch (SQLException ex) {
            Logger.getLogger(Group_utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Creates and array list of array lists each containing information about members in a specified group.
     * @param groupID
     * @return memDetails
     * @throw SQLException
     * 
     */
    public static ArrayList getMemberDetails(int groupID)
    {
        ArrayList<String> userIDList = getMemberIDs(groupID);
        ArrayList<ArrayList<String>> memDetails = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> forename = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> tasksDone = new ArrayList<>();
       
        
       //Iterate through each user ID in userIDList
        for (int user = 0; user <= userIDList.size()-1; user++)
        {        
            String query ;
            query = "SELECT User_ID, User_Forename, User_Surname, User_Email, User_NumTasksDone FROM user WHERE User_ID =" + userIDList.get(user) + ";";
            ResultSet userDetails = DBConnect.databaseSelect(query);
            try {
                // iterate through the java resultset
                while (userDetails.next()) {
                    id.add(userDetails.getString("User_ID"));
                    forename.add(userDetails.getString("User_Forename"));
                    surname.add(userDetails.getString("User_Surname"));
                    email.add(userDetails.getString("User_Email"));
                    tasksDone.add(userDetails.getString("User_NumTasksDone"));                    
                }
                userDetails.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Group_utils.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        memDetails.add(id);
        memDetails.add(forename);
        memDetails.add(surname);
        memDetails.add(email);
        memDetails.add(tasksDone);
        return memDetails;
            //Split user details up and input into lists
        }
    public static String createGroup(String name, String description){
            String insertGroup = "INSERT INTO Groups Group_Name,Group_Description VALUES("+name+ "," + description +");";
            try{
                DBConnect.databaseInput(insertGroup);
                return "Group created sucessfully";
                
            } catch (Exception ex){
                return "Error in creating group";
            }
            
            
    }
}

