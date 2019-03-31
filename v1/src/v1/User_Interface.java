/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import database_console.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    /**
     * Creates new form User_Interface
     *
     * @throws java.sql.SQLException
     */
    public User_Interface() throws SQLException {
        initComponents();
        jButtonDeleteAccount.setVisible(false);
        jButtonPasswordChange.setVisible(false);

        String userId = getUserIdById(1);
        jLabelTopLeftUserIOd.setText(userId);

        String userEmail = getUserEmailById(1);
        jLabelEmailField.setText(userEmail);

        String name = getUserNameById(1);
        jLabelNameField.setText(name);

        getUserGroupById(1);

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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelTopLeftUserIOd = new javax.swing.JLabel();
        jLabelEmailField = new javax.swing.JLabel();
        jLabelNameField = new javax.swing.JLabel();
        jToggleButtonEdit = new javax.swing.JToggleButton();
        jButtonPasswordChange = new javax.swing.JButton();
        jButtonDeleteAccount = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Invite");

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

        jLabel5.setText("Member");

        jLabel6.setText("Member");

        jLabel7.setText("profile");

        jTextField4.setText("jTextField4");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jToggleButtonEdit)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(199, 199, 199)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButtonPasswordChange)
                                                    .addComponent(jButtonDeleteAccount))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelEmailField)
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
                        .addGap(45, 45, 45)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jButton1)
                            .addComponent(jLabel5)
                            .addComponent(jLabelTopLeftUserIOd))
                        .addGap(22, 22, 22)
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
                                    .addComponent(jButtonDeleteAccount)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(331, Short.MAX_VALUE))
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
                    new User_Interface().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(User_Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDeleteAccount;
    private javax.swing.JButton jButtonPasswordChange;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmailField;
    private javax.swing.JLabel jLabelNameField;
    private javax.swing.JLabel jLabelTopLeftUserIOd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton jToggleButtonEdit;
    // End of variables declaration//GEN-END:variables
}
