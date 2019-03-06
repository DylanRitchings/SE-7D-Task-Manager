/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;
import java.util.*;

/**
 *
 * @author up877962
 */
public class Chat {
     protected String  messages;
     protected ArrayList activeUsers;
     protected int membersOnline;
     protected boolean isOnline;
     
     public Chat() {   /*  Creates a new instance of groups_utils */
    }
    public Chat(String liveMessages, ArrayList<String> usersOnline, int numberOnline, boolean online){
       messages = liveMessages;
       activeUsers = usersOnline;
       membersOnline = numberOnline;
       isOnline = online;
       
       
    }
     
    
}
