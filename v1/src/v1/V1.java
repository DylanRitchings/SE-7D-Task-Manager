/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import group_page.GroupPageLeader;
import java.sql.SQLException;

/**
 *
 * @author Dylan Ritchings
 */
public class V1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Login_Interface page = new Login_Interface ();
        page.setVisible(true);

        
    }
    
}
