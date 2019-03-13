/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;
import java.util.ArrayList;

/**
 *
 * @author Zatte
 */
public class Login {
     protected String  email;
     protected String password;
     protected boolean isLeader;



     public Login(String u_Email, String u_Password, boolean u_IsLeader){

     email = u_Email;
     password = u_Password;
     isLeader = u_IsLeader;

}

}
