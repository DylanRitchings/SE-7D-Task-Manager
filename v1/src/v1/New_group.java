package v1;
import database_console.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author up818044,up849492
 */
public class New_group 
{
    private String newGroupName;
    private String newGroupDescription;
    private ArrayList<String> newSkillsRequest;
    
    public New_group() 
    {        
    }
    public New_group(String name, String description, ArrayList<String> requestedskills)
    {
        newGroupName = name;
        newGroupDescription = description;
        newSkillsRequest = requestedskills;
    }
    
    
    public static void insert(String name, String description, ArrayList<String> requestedskills) {

        String host = "jdbc:mysql://den1.mysql3.gear.host:3306/teammanagerdb";
        String uName = "teammanagerdb";
        String uPass = "Bc85NMS--V6h";

        // The question marks in the values brackets are SQL's equivalent to 
        // variables.
        String insert = "INSERT INTO groups(Group_Name,Group_Description) "
                + "VALUES(?, ?)";
    
    
            try (Connection con = DriverManager.getConnection(host, uName, uPass);) {

            // A prepared statement is created and values are assigned to the 
            // question marks in the values brackets.
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, name);
            pst.setString(2, description);

            pst.executeUpdate();
            pst.close();

            System.out.println("The group has been created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    
    
    
    public void setGroupName()
    {
        System.out.println(newGroupName);
    }
    
    public void setGroupDescription()
    {
        System.out.println(newGroupDescription);
    }
    
    public void setRequestedSkills()
    {
        System.out.println(newSkillsRequest);
    }
}
