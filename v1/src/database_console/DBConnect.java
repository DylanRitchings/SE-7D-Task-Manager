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

    String host = "jdbc:mysql://den1.mysql3.gear.host:3306/teammanagerdb";
    String uName = "teammanagerdb";
    String uPass = "Bc85NMS--V6h";
    private Connection con;
    private Statement st;

    public ResultSet getMembers() {
        try {
            con = DriverManager.getConnection(host, uName, uPass);

            String query = "SELECT * FROM member";

            // create the java statement
            Statement st = con.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("Member_ID");
                String firstName = rs.getString("Member_Forename");
                String lastName = rs.getString("Member_Surname");
                String email = rs.getString("Member_Email");

                // print the results
                System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, email);
            }
            st.close();
        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return (rs);
    }
}
