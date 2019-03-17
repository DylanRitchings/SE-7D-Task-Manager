/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_console;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import v1.User;

/**
 *
 * @author Dylan Ritchings
 */
public class DBConnect {

    public static void main(String[] args) {

        String host = "jdbc:mysql://den1.mysql3.gear.host:3306/teammanagerdb";
        String uName = "teammanagerdb";
        String uPass = "Bc85NMS--V6h";
        
        

//        //insert into query
//        
//                
//        String insert = "INSERT INTO member(Member_ForeName, Member_SurName, Member_email) VALUES('ddfgdsf','f', 'twady@nmail.com')";
//
//        try (Connection con = DriverManager.getConnection(host, uName, uPass);
//                PreparedStatement pst = con.prepareStatement(insert)) {
//            // create the java statement
//            Statement stat = con.createStatement();
//            // execute the query, and get a java resultset
//            int rs;
//            rs = stat.executeUpdate(insert);
//            
////            String firstName = ("roger");
////            String lastName = ("rabbit");
////            String email = ("carrots@nmail.com");
//            
//                
////            pst.setString(1,"roger");
////            pst.setString(2,"rabbit");
////            pst.setString(3,"carrots@nmail.com");
////            pst.executeUpdate();
//            
//            System.out.println("A new member has been inserted");
//
//        } catch (SQLException ex) {
//
//            Logger lgr = Logger.getLogger(DBConnect.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
////needs stat.close();
//        }
//        
  


       //call to user
        
        User.insert();
        
        
        


        //insert into query       
                
        String insert = "INSERT INTO member(Member_ForeName, Member_SurName, Member_email) VALUES('Chuck','Norris', 'ChuckNorris@gnmail.com')";

        try (Connection con = DriverManager.getConnection(host, uName, uPass);
                PreparedStatement pst = con.prepareStatement(insert)) {
            // create the java statement
            Statement stat = con.createStatement();
            // execute the query, and get a java resultset
            int rs;
            rs = stat.executeUpdate(insert);
            
            String firstName = ("roger");
            String lastName = ("rabbit");
            String email = ("carrots@nmail.com");
            
                
            pst.setString(1,"roger");
            pst.setString(2,"rabbit");
            pst.setString(3,"carrots@nmail.com");
            pst.executeUpdate();
            
            System.out.println("A new member has been inserted");





//select from query

        }
        catch (Exception e) {
            
        }
        
        
        //delete from query        
        
        String delete = "DELETE FROM member WHERE Member_ID = 20";

        try (Connection con = DriverManager.getConnection(host, uName, uPass);
                PreparedStatement pst = con.prepareStatement(delete)) {
            // create the java statement
            Statement stat = con.createStatement();
            // execute the query, and get a java resultset
            int rs;
            rs = stat.executeUpdate(delete);
            
            
            System.out.println("A new member has been deleted");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        
        
        
        //select from query
        

        
        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);

            
            String query = "SELECT * FROM User";

            // create the java statement
            Statement st = con.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset

            while (rs.next()) {
                int id = rs.getInt("User_ID");
                String firstName = rs.getString("User_Forename");
                String lastName = rs.getString("User_Surname");
                String email = rs.getString("User_Email");
                String password = rs.getString("User_Password");
                String userName = rs.getString("User_Username");
                String numTasksDone;
                numTasksDone = rs.getString("" + "User_NumTasksDone");
                
                System.out.format("%s, %s, %s, %s, %s, %s, %s  \n", id, firstName, lastName, email, password, userName, numTasksDone);

            }
            st.close();
            }catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            }       
        }
    }
