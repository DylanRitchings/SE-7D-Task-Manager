/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import database_console.DBConnect;
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

    /**
     *
     * @param userId
     * @return
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
     * @param userId
     * @return
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
     * @param userId
     * @return
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

        return userName;
    }

    /**
     *
     * @param userId
     * @return
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

    
    
    //NEEDS A LITTLE BIT OF WORK 

    /**
     *
     * @param userId
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
     * @param pWord
     * @param eMail
     */
    public static void updateUserPasswordByEmail(String pWord, String eMail) {

//        //select from query
        String select = "update User set User_Password = ? where User_Email = ?";
        int rs;

        try (Connection con = DBConnect.databaseConnect();) {

            PreparedStatement pst = con.prepareStatement(select);
            pst.setString(1, pWord);
            pst.setString(2, eMail);

            rs = pst.executeUpdate();

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
     */
//    public void fillTaskDetails() throws ParseException{
//        Container cont = new Container();
//        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
//        //BoxLayout taskLayout = new BoxLayout (taskPane,BoxLayout.Y_AXIS);
//        taskPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        for (int count = 0; count < taskID.size(); count++){
//            JPanel taskPanel  = new TaskViewLeader(taskID.get(count), taskTitle.get(count), taskStart.get(count), taskEnd.get(count), taskDesc.get(count), taskComp.get(count));
//            cont.add(taskPanel, BorderLayout.LINE_START);
//
//           }
//        taskPane.getViewport().setView(cont);
//        //taskPane.add(cont);
//        //taskPane.setVisible(true);
//        taskPane.revalidate();
//        taskPane.repaint();
//    }
    
    
    
    /**
     * Creates new form User_Interface
     *
     * @throws java.sql.SQLException
     */
    public User_Interface(int userId) throws SQLException {
        initComponents();
        
        ArrayList<String> tID = new ArrayList<>();
        ArrayList<String> tTitle = new ArrayList<>();
        ArrayList<String> tStart = new ArrayList<>();
        ArrayList<String> tEnd = new ArrayList<>();
        ArrayList<String> tDesc = new ArrayList<>();
        ArrayList<String> tComp = new ArrayList<>();
        jButtonDeleteAccount.setVisible(false);
        jButtonPasswordChange.setVisible(false);

        String userIdbyId = getUserIdById(1);
        jLabelTopLeftUserIOd.setText(userIdbyId);

        String userEmail = getUserEmailById(1);
        jLabelEmailField.setText(userEmail);

        String name = getUserNameById(1);
        jLabelNameField.setText(name);

        getUserGroupById(1);
        
        getUserMemberTasksId(1);
        
        getTaskDetails(getUserMemberGroupIds(userId));
        
        getUserMemberGroupIds(1);

//         updateUserPasswordByEmail("hello","@");
        //deleteUserById(146);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelTopLeftUserIOd = new javax.swing.JLabel();
        jLabelEmailField = new javax.swing.JLabel();
        jLabelNameField = new javax.swing.JLabel();
        jToggleButtonEdit = new javax.swing.JToggleButton();
        jButtonPasswordChange = new javax.swing.JButton();
        jButtonDeleteAccount = new javax.swing.JButton();
        taskPane = new javax.swing.JScrollPane();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Member");

        jLabel2.setText("'s profile");

        jLabel3.setText("Name:");

        jLabel4.setText("Email:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tasks for ");

        jLabel9.setText("Skills for");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jToggleButtonEdit))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonPasswordChange)
                                            .addComponent(jButtonDeleteAccount))
                                        .addGap(0, 355, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(taskPane, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelEmailField))
                                .addGap(0, 0, Short.MAX_VALUE))))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addComponent(taskPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

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
        String newPword = JOptionPane.showInputDialog(null, "enter new password", "");
        if (newPword == null) {
            System.out.println("The user canceled");
        } else {
            updateUserPasswordByEmail(newPword, "@");

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
                try {
                    new User_Interface(1).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(User_Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteAccount;
    private javax.swing.JButton jButtonPasswordChange;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmailField;
    private javax.swing.JLabel jLabelNameField;
    private javax.swing.JLabel jLabelTopLeftUserIOd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JToggleButton jToggleButtonEdit;
    private javax.swing.JScrollPane taskPane;
    // End of variables declaration//GEN-END:variables

    private void getTaskDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
