/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import database_console.DBConnect;
import group_page.TaskViewComplete;
import group_page.TaskViewLeader;
import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import v1.Group_utils;

/**
 *
 * @author up877962
 */
public class User_Interface extends javax.swing.JFrame {

    int user_id;
    String user_id_string;
    ArrayList taskIDs;
    ArrayList<ArrayList<String>> tDetails;
    ArrayList<String> tID;
    ArrayList<String> tTitle;
    ArrayList<String> tStart;
    ArrayList<String> tEnd;
    ArrayList<String> tDesc;
    ArrayList<String> tComp;
    String userEmail;
    /**
     *
     * @param userId the ID of the user which to look up in the database in int format
     * @return a string of the user ID
     */
    public static String getUserIdById(int userId) {
        int userID = 0;

//        //select from query
        String select = "SELECT User_ID FROM user WHERE User_ID = ? ";
        ResultSet rs;

        try (Connection con = DBConnect.databaseConnect();) {

            PreparedStatement pst = con.prepareStatement(select);
            pst.setInt(1, userId);

            rs = pst.executeQuery();
            while (rs.next()) {
                userID = rs.getInt("User_ID");

//                            System.out.format("%s,  \n", userID);
                System.out.print(userID);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }

        return Integer.toString(userID);
    }

    /**
     *
     * @param userId the ID of the user for whom to get the email from the database
     * @return the email of the specified user from the database
     */
    public static String getUserEmailById(int userId) {
        String userEmail = null;

//        //select from query
        String select = "SELECT User_Email FROM user WHERE User_ID = ? ";
        ResultSet rs;

        try (Connection con = DBConnect.databaseConnect();) {

            PreparedStatement pst = con.prepareStatement(select);
            pst.setInt(1, userId);

            rs = pst.executeQuery();
            if (rs.next()) {
                userEmail = rs.getString("User_Email");

                System.out.format("%s,  \n", userEmail);

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }

        return userEmail;
    }

    /**
     *
     * @param userId the ID of the user within the database
     * @return the username of the specified user within the database
     */
    public static String getUserNameById(int userId) {

        String userName = null;

//        //select from query
        String select = "SELECT DISTINCT User_Forename, User_Surname FROM user WHERE User_ID = ? ";
        ResultSet rs;

        try (Connection con = DBConnect.databaseConnect();) {

            PreparedStatement pst = con.prepareStatement(select);
            pst.setInt(1, userId);

            rs = pst.executeQuery();
            while (rs.next()) {
                String userFname = rs.getString("User_Forename");
                String userSname = rs.getString("User_Surname");

                userName = userFname + " " + userSname;

                // System.out.format("%s,  \n", userFname + " "+ userSname);
//                           System.out.print(userName);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        System.out.println(userName);
        return userName;
    }

    /**
     *
     * @param userId the ID of the user within the database
     * @return the group ID of the group that is displayed in String format
     */
    public static String getUserGroupById(int userId) {

        String groups = null;

//        //select from query
        String select = "SELECT Group_ID FROM user_in_group where User_ID = ?";
        ResultSet rs;

        try (Connection con = DBConnect.databaseConnect();) {

            PreparedStatement pst = con.prepareStatement(select);
            pst.setInt(1, userId);

            rs = pst.executeQuery();
            while (rs.next()) {

                groups = rs.getString("group_ID");

                System.out.format("%s,  \n", groups);

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }

        return groups;
    }

    
    

    /**
     *
     * @param userId the ID of the user within the database
     */
    public static void deleteUserById(int userId) {
        try {
            String statement = "DELETE FROM user WHERE User_ID = " + userId;
            DBConnect.databaseInput(statement);
            System.out.print("user" + userId + "deleted");

        } catch (Exception e) {

            System.out.print("user" + userId + "doesn not exist");
        }

    }

    /**
     *
     * @param pWord the new password to be set
     * @param eMail the email of the user within the database for which the password to be set
     */
    public static void updateUserPasswordByEmail(String pWord, String eMail) {

//        //select from query
        String select = "update User set User_Password = ? where User_Email = ?";
        try (Connection con = DBConnect.databaseConnect();) {

            PreparedStatement pst = con.prepareStatement(select);
            pst.setString(1, pWord);
            pst.setString(2, eMail);

            pst.executeUpdate();

            System.out.print("password changed");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }

    }
    
    public static int getUserMemberTasksId(int userId) {

        int tasks = 0;

//        //select from query
        String select = "SELECT Task_ID FROM user_member_group where User_ID = ?";
        ResultSet rs;

        try (Connection con = DBConnect.databaseConnect();) {

            PreparedStatement pst = con.prepareStatement(select);
            pst.setInt(1, userId);

            rs = pst.executeQuery();
            while (rs.next()) {

                tasks = rs.getInt("Task_ID");

                System.out.format("%s,  \n", tasks);

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }

        return tasks;
    }

    /**
     *
     * @param userId 
     * @return
     */
   
    
    public static ArrayList getUserMemberGroupIds(int userId){
        //ArrayList taskIDs = getTaskIDs(groupID);
       // ArrayList<ArrayList<String>> tIds = new ArrayList<>();
        ArrayList<String> tIds = new ArrayList<>();
//        ArrayList<String> tTitle = new ArrayList<>();
//        ArrayList<String> tStart = new ArrayList<>();
//        ArrayList<String> tEnd = new ArrayList<>();
//        ArrayList<String> tDesc = new ArrayList<>();
//        ArrayList<String> tComp = new ArrayList<>();
       // for (Object taskID :taskIDs){
            String query = "SELECT Task_ID FROM user_member_group where User_ID ="+ userId+";";
            ResultSet tDetailsrs = DBConnect.databaseSelect(query);
            try{
                while (tDetailsrs.next()) {
                    tIds.add(tDetailsrs.getString("Task_ID"));
//                    tTitle.add(tDetailsrs.getString("Task_Title"));
//                    tStart.add(tDetailsrs.getString("Task_Start"));
//                    tEnd.add(tDetailsrs.getString("Task_Deadline"));
//                    tDesc.add(tDetailsrs.getString("Task_Description"));
//                    tComp.add(tDetailsrs.getString("Is_Complete"));
                }
                tDetailsrs.close();

            }catch (SQLException ex) {
                    Logger.getLogger(Group_utils.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                    }
       // }
        //tIds.add(tID);
//        tDetails.add(tTitle);
//        tDetails.add(tStart);
//        tDetails.add(tEnd);
//        tDetails.add(tDesc);
//        tDetails.add(tComp);
            System.out.println(tIds);
            return tIds;
        
    }
    
   public static ArrayList getTaskDetails(ArrayList taskIDs){
        //ArrayList taskIDs = getTaskIDs(TaskIDs);
        ArrayList<ArrayList<String>> tDetails = new ArrayList<>();
       ArrayList<String> tID = new ArrayList<>();
        ArrayList<String> tTitle = new ArrayList<>();
        ArrayList<String> tStart = new ArrayList<>();
        ArrayList<String> tEnd = new ArrayList<>();
        ArrayList<String> tDesc = new ArrayList<>();
        ArrayList<String> tComp = new ArrayList<>();
        for (Object taskID :taskIDs){
            String query = "SELECT * FROM task where Task_ID ="+ taskID+";";
           //System.out.print(taskIDs); 
           ResultSet tDetailsrs = DBConnect.databaseSelect(query);
            try{
                while (tDetailsrs.next()) {
                    tID.add(tDetailsrs.getString("Task_ID"));
                    tTitle.add(tDetailsrs.getString("Task_Title"));
                    tStart.add(tDetailsrs.getString("Task_Start"));
                    tEnd.add(tDetailsrs.getString("Task_Deadline"));
                    tDesc.add(tDetailsrs.getString("Task_Description"));
                    tComp.add(tDetailsrs.getString("Is_Complete"));
                }
                tDetailsrs.close();

            }catch (SQLException ex) {
                    Logger.getLogger(Group_utils.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                    }
        }
        tDetails.add(tID);
        tDetails.add(tTitle);
        tDetails.add(tStart);
        tDetails.add(tEnd);
        tDetails.add(tDesc);
        tDetails.add(tComp);
        return tDetails;
    } 
   
    /**
     * Fill each task into the taskPanel
     * @throws ParseException 
     * @author Dylan Ritchings
     */
    private void fillTaskDetails() throws ParseException{
        Container cont = new Container();
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        //BoxLayout taskLayout = new BoxLayout (taskPane,BoxLayout.Y_AXIS);

        taskPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        for (int count = 0; count < tID.size(); count++){
            JPanel taskPanel  = new TaskViewComplete(tID.get(count), tTitle.get(count), tStart.get(count), tEnd.get(count), tDesc.get(count), tComp.get(count));
            cont.add(taskPanel, BorderLayout.LINE_START);
            

           }
        taskPane1.getViewport().setView(cont);
        //taskPane.add(cont);
        //taskPane.setVisible(true);
        taskPane1.revalidate();
        taskPane1.repaint();
    }

public User_Interface() {

        this.taskIDs = getUserMemberGroupIds(user_id);
        this.tDetails = getTaskDetails(taskIDs);
        this.tComp = tDetails.get(5);
        this.tDesc = tDetails.get(4);
        this.tEnd = tDetails.get(3);
        this.tStart = tDetails.get(2);
        this.tTitle = tDetails.get(1);
        this.tID = tDetails.get(0);
    initComponents();
}
    
public User_Interface(int profileUserId, String userEmail)
    {
        this.userEmail = userEmail;
        int userId = profileUserId;
        this.taskIDs = getUserMemberGroupIds(userId);
        this.tDetails = getTaskDetails(taskIDs);
        this.tComp = tDetails.get(5);
        this.tDesc = tDetails.get(4);
        this.tEnd = tDetails.get(3);
        this.tStart = tDetails.get(2);
        this.tTitle = tDetails.get(1);
        this.tID = tDetails.get(0);
        this.user_id = userId;
        this.user_id_string = Integer.toString(userId);
        
        initComponents();
        
        
        jButtonDeleteAccount.setVisible(false);
        jButtonPasswordChange.setVisible(false);

        String userIdbyId = getUserIdById(userId);
        jLabelTopLeftUserIOd.setText(userIdbyId);

        //String userEmail = getUserEmailById(1);
        jLabelEmailField.setText(userEmail);

        String name = getUserNameById(userId);
        jLabelNameField.setText(name);

        getUserGroupById(user_id);
        
        getUserMemberTasksId(user_id);
        
        
        
        try {
             fillTaskDetails();
//         updateUserPasswordByEmail("hello","@");
//deleteUserById(146);
         } catch (ParseException ex) {
             Logger.getLogger(User_Interface.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

public User_Interface(int profileUserId)
    {
        this.userEmail = getUserEmailById(user_id);
        int userId = profileUserId;
        this.taskIDs = getUserMemberGroupIds(userId);
        this.tDetails = getTaskDetails(taskIDs);
        this.tComp = tDetails.get(5);
        this.tDesc = tDetails.get(4);
        this.tEnd = tDetails.get(3);
        this.tStart = tDetails.get(2);
        this.tTitle = tDetails.get(1);
        this.tID = tDetails.get(0);
        this.user_id = userId;
        this.user_id_string = Integer.toString(userId);
        
        initComponents();
        
        
        jButtonDeleteAccount.setVisible(false);
        jButtonPasswordChange.setVisible(false);

        String userIdbyId = getUserIdById(userId);
        jLabelTopLeftUserIOd.setText(userIdbyId);

        //String userEmail = getUserEmailById(1);
        jLabelEmailField.setText(userEmail);

        String name = getUserNameById(userId);
        jLabelNameField.setText(name);

        getUserGroupById(user_id);
        
        getUserMemberTasksId(user_id);
        
        
        
        try {
             fillTaskDetails();
//         updateUserPasswordByEmail("hello","@");
//deleteUserById(146);
         } catch (ParseException ex) {
             Logger.getLogger(User_Interface.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
//    /**
//     * Creates new form User_Interface
//     *
//     * @param userId
//     * @throws java.sql.SQLException
//     */
//    public User_Interface(int userId) throws SQLException {
//        
//        initComponents();
//        
//        
//        jButtonDeleteAccount.setVisible(false);
//        jButtonPasswordChange.setVisible(false);
//
//        String userIdbyId = getUserIdById(1);
//        jLabelTopLeftUserIOd.setText(userIdbyId);
//
//        String userEmail = getUserEmailById(1);
//        jLabelEmailField.setText(userEmail);
//
//        String name = getUserNameById(1);
//        jLabelNameField.setText(name);
//
//        getUserGroupById(1);
//        
//        getUserMemberTasksId(1);
//        
//        ArrayList<ArrayList<String>> tDetails = getTaskDetails(getUserMemberGroupIds(userId));
//        ArrayList<String> tID = tDetails.get(0);
//        ArrayList<String> tTitle = tDetails.get(1);
//        ArrayList<String> tStart = tDetails.get(2);
//        ArrayList<String> tEnd = tDetails.get(3);
//        ArrayList<String> tDesc = tDetails.get(4);
//        ArrayList<String> tComp = tDetails.get(5);
//        System.out.println(tID);
//        System.out.println(tTitle);
//        System.out.println(tStart);
//        System.out.println(tEnd);
//        System.out.println(tDesc);
//        System.out.println(tComp);
//         try {
//             fillTaskDetails();
////         updateUserPasswordByEmail("hello","@");
////deleteUserById(146);
//         } catch (ParseException ex) {
//             Logger.getLogger(User_Interface.class.getName()).log(Level.SEVERE, null, ex);
//         }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        taskPane = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTopLeftUserIOd = new javax.swing.JLabel();
        jLabelEmailField = new javax.swing.JLabel();
        jLabelNameField = new javax.swing.JLabel();
        jToggleButtonEdit = new javax.swing.JToggleButton();
        jButtonPasswordChange = new javax.swing.JButton();
        jButtonDeleteAccount = new javax.swing.JButton();
        taskPane1 = new javax.swing.JScrollPane();

        jMenu1.setText("jMenu1");

        taskPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        taskPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Member");

        jLabel2.setText("'s profile");

        jLabel3.setText("Name:");

        jLabel4.setText("Email:");

        jLabelTopLeftUserIOd.setText("jLabel10");

        jLabelEmailField.setText("jLabel10");

        jLabelNameField.setText("jLabel10");

        jToggleButtonEdit.setText("edit");
        jToggleButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEditActionPerformed(evt);
            }
        });

        jButtonPasswordChange.setText("change password");
        jButtonPasswordChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasswordChangeActionPerformed(evt);
            }
        });

        jButtonDeleteAccount.setText("delete account");
        jButtonDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccountActionPerformed(evt);
            }
        });

        taskPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        taskPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jToggleButtonEdit)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonPasswordChange)
                                    .addComponent(jButtonDeleteAccount))
                                .addGap(0, 379, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEmailField)
                                .addGap(0, 767, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTopLeftUserIOd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNameField)))
                        .addGap(0, 651, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(taskPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabelTopLeftUserIOd))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelNameField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelEmailField))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPasswordChange)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButtonEdit)
                            .addComponent(jButtonDeleteAccount))))
                .addGap(18, 18, 18)
                .addComponent(taskPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEditActionPerformed
        // TODO add your handling code here:
        if (jToggleButtonEdit.isSelected()) {
            jButtonPasswordChange.setVisible(true);
        } else {
            jButtonPasswordChange.setVisible(false);
        }

        if (jToggleButtonEdit.isSelected()) {
            jButtonDeleteAccount.setVisible(true);
        } else {
            jButtonDeleteAccount.setVisible(false);
        }
    }//GEN-LAST:event_jToggleButtonEditActionPerformed

    private void jButtonDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccountActionPerformed
        // TODO add your handling code here:
        int yesOrNo = JOptionPane.showConfirmDialog(null, "are you sure you want to delete your account", "delete", JOptionPane.YES_NO_OPTION);
        if (yesOrNo == 0) {
            deleteUserById(145);
        } else {
            System.out.print("not deleted");
        }


    }//GEN-LAST:event_jButtonDeleteAccountActionPerformed

    private void jButtonPasswordChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasswordChangeActionPerformed
        // TODO add your handling code here:
        String newPword;
        newPword = JOptionPane.showInputDialog(null, "enter new password", "");
        System.out.println("Hello?" + newPword + " " + userEmail);
        if (newPword == null) {
            System.out.println("The user canceled");
        } else {
            updateUserPasswordByEmail(newPword, userEmail);

    }//GEN-LAST:event_jButtonPasswordChangeActionPerformed
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new User_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteAccount;
    private javax.swing.JButton jButtonPasswordChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelEmailField;
    private javax.swing.JLabel jLabelNameField;
    private javax.swing.JLabel jLabelTopLeftUserIOd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JToggleButton jToggleButtonEdit;
    private javax.swing.JScrollPane taskPane;
    private javax.swing.JScrollPane taskPane1;
    // End of variables declaration//GEN-END:variables

    private void getTaskDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
