package v1;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author up818044
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
        String insert = "INSERT INTO user(User_Forename, User_Surname, User_Email, User_Password, User_Username, User_NumTasksDone) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
