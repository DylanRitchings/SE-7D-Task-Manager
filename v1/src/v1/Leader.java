package v1;
import database_console.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        
        //OLD
//        String host = "jdbc:mysql://den1.mysql3.gear.host:3306/teammanagerdb";
//        String uName = "teammanagerdb";
//        String uPass = "Bc85NMS--V6h";
//        String deleteMemQ = "DELETE FROM user_in_group WHERE User_ID = " + memberID + " AND group_ID = " + groupID;
//        
//        try (Connection con = DriverManager.getConnection(host, uName, uPass);
//            PreparedStatement pst = con.prepareStatement(deleteMemQ)) {
//            // create the java statement
//            Statement stat = con.createStatement();
//            // execute the query, and get a java resultset
//            int rs;
//            rs = stat.executeUpdate(deleteMemQ);
//            
//            
//            System.out.println("A new user has been deleted");
//        stat.close();
//        } catch (SQLException ex) {
//
//            Logger lgr = Logger.getLogger(DBConnect.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
//
//        }
//    
//    }
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
        String host = "jdbc:mysql://den1.mysql3.gear.host:3306/teammanagerdb";
        String uName = "teammanagerdb";
        String uPass = "Bc85NMS--V6h";
        String assignToMemberQ = "INSERT INTO user_member_group(Task_ID,Group_ID,User_ID) "
                + "VALUES(?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(host, uName, uPass);
            PreparedStatement pst = con.prepareStatement(assignToMemberQ)) {
            pst.setInt(1, taskID);
            pst.setInt(2, groupID);
            pst.setInt(3, userID);
            pst.executeUpdate();
            pst.close();
            // create the java statement
    
            
            
            System.out.println("User: " + userID + " has been assigned to task: " + taskID);
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }
}
