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
