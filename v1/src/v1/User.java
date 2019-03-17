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
 *
 * @author Konstantin Georgiev
 */
public class User {
    private static String firstName;
    private static String lastName;
    private static String email;
    private Integer userID;
    private String userName;
    private String password;
    private Integer numTasksDone;
    private ArrayList<String> bestSkills;
    private Integer a;
    
    public User (String u_FName, String u_LName, String u_Email, 
                 Integer u_UserID, String u_UserName, String u_Password, 
                 Integer u_NumTasksDone, ArrayList<String> u_BestSkills) {
        
        firstName = u_FName;
        lastName = u_LName;
        email = u_Email;
        userID = u_UserID;
        userName = u_UserName;
        password = u_Password;
        numTasksDone = u_NumTasksDone;
        bestSkills = u_BestSkills;
        
        
       //insert into query
    }
        
       public static void insert () {
//           
        String host = "jdbc:mysql://den1.mysql3.gear.host:3306/teammanagerdb";
        String uName = "teammanagerdb";
        String uPass = "Bc85NMS--V6h";
        
        String uFName = "Obi-Wan";
        String uSName = "Kenobi";
        String uEmail = "obiWanKenobi@general.com";
        String uPassword = "highGround";
        String uUsername = "GeneralKenobi";
        Integer numTasksDone = 66;
        
        
        
        String insert = "INSERT INTO user(User_Forename, User_Surname, User_Email, User_Password, User_Username, User_NumTasksDone) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, uName, uPass);) {
            
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, uFName);
            pst.setString(2, uSName);
            pst.setString(3, uEmail);
            pst.setString(4, uPassword);
            pst.setString(5, uUsername);
            pst.setInt(6, numTasksDone);
            
            pst.executeUpdate();
            pst.close();
            
            // create the java statement
            //Statement stat = con.createStatement();
            // execute the query, and get a java resultset
            //int rs;
            //rs = stat.executeUpdate(insert);
            
//            String firstName = ("roger");
//            String lastName = ("rabbit");
//            String email = ("carrots@nmail.com");
            
                
//            pst.setString(1,"roger");
//            pst.setString(2,"rabbit");
//            pst.setString(3,"carrots@nmail.com");
//            pst.executeUpdate();
            
            System.out.println("A new member has been inserted");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
//needs stat.close();

        }
        }
       
       
    }
    
  

