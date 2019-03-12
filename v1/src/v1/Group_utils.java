/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;
import java.util.*;
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
       ///////
    }
}
