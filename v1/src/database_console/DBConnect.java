/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_console;

import java.sql.*;

/**
 *
 * @author Dylan Ritchings
 */
public class DBConnect {
    public static void main (String[] args){
        
        String host = "den1.mysql3.gear.host";
        String uName = "teammanagerdb";
        String uPass = "Bc85NMS--V6h";
        String test = "test"; 
       
        try {
            Connection con = DriverManager.getConnection( host,uName,uPass);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
