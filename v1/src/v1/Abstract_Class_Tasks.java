/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import java.util.*;

/**
 *
 * @author up860271
 */
public class Abstract_Class_Tasks {
    protected String description; 
    private String title;
  /* private Date startTime ; 
    private Date finishTime; need to figure out correct data type */
    private int taskID;
    private boolean isComplete; 
    
public Abstract_Class_Tasks() {
    
}
public Abstract_Class_Tasks(String taskDescription, String taskTitle, int ID, boolean completed) {
    description = taskDescription;
    title = taskTitle;
    taskID = ID;
    isComplete = completed;
    
          
           
}

    
    
    
    
}
