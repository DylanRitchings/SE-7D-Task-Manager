/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    /*
    *  Remove a member from a group
    * @param memberID, groupID
    * @return 
    * @throw 
    * @pre 
    * @modifies 
    * @post 
    * @bound 
    */
    public void DeleteMember(int memberID, int groupID){
        String host = "jdbc:mysql://den1.mysql3.gear.host:3306/teammanagerdb";
        String uName = "teammanagerdb";
        String uPass = "Bc85NMS--V6h";
        String deleteMemQ = "DELETE FROM user_in_group WHERE User_ID = " + memberID + " AND group_ID = " + groupID;
        
        try (Connection con = DriverManager.getConnection(host, uName, uPass);
            PreparedStatement pst = con.prepareStatement(deleteMemQ)) {
            // create the java statement
            Statement stat = con.createStatement();
            // execute the query, and get a java resultset
            int rs;
            rs = stat.executeUpdate(deleteMemQ);
            
            
            System.out.println("A new user has been deleted");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    
    }
}
