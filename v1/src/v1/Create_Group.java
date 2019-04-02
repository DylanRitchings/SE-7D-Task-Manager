/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import database_console.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author up849492
 */
public class Create_Group extends javax.swing.JFrame {

    /**
     * Creates new form Create_Group
     */
    public Create_Group() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel2Title = new javax.swing.JLabel();
        jTextField1GroupName = new javax.swing.JTextField();
        jLabel3GroupName = new javax.swing.JLabel();
        jLabel4GroupDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1GroupDesc = new javax.swing.JTextArea();
        jButton1Done = new javax.swing.JButton();
        jButton2Cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_Email = new javax.swing.JLabel();
        jLabel_ID = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2Title.setText("Create a new group");

        jTextField1GroupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1GroupNameActionPerformed(evt);
            }
        });

        jLabel3GroupName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3GroupName.setText("Group name:");

        jLabel4GroupDesc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4GroupDesc.setText("Group description:");

        jTextArea1GroupDesc.setColumns(20);
        jTextArea1GroupDesc.setRows(5);
        jScrollPane1.setViewportView(jTextArea1GroupDesc);

        jButton1Done.setText("Done");
        jButton1Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1DoneActionPerformed(evt);
            }
        });

        jButton2Cancel.setText("Cancel");
        jButton2Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2CancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("User's Email: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("User's ID: ");

        jLabel_Email.setText("jLabel4");

        jLabel_ID.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3GroupName)
                    .addComponent(jLabel4GroupDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton1Done, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2Title)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Email, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2Title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel4GroupDesc))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2Cancel)
                            .addComponent(jButton1Done)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_ID)
                            .addComponent(jLabel3))))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1GroupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1GroupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1GroupNameActionPerformed

    private void jButton2CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2CancelActionPerformed
        //Show a new form
        LoggedIN form = new LoggedIN();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        //Passes the email to the LoggedIN interface
        form.jLabel_displayEmail.setText(jLabel_Email.getText());
        form.jLabel_displayuserID.setText(jLabel_ID.getText());
        form.findYourGroups();
        form.searchGroup();
        this.dispose();
    }//GEN-LAST:event_jButton2CancelActionPerformed

    private void jButton1DoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1DoneActionPerformed
        if (validate_Inputs()) {
            create_group();
            
//            group_creator();
            
            //Show a new form
            LoggedIN form = new LoggedIN();
            form.setVisible(true);
            form.pack();
            form.setLocationRelativeTo(null);
            //Passes the email to the LoggedIN interface
            form.jLabel_displayEmail.setText(jLabel_Email.getText());
            form.jLabel_displayuserID.setText(jLabel_ID.getText());
            form.findYourGroups();
            form.searchGroup();
            
            
        }
    }//GEN-LAST:event_jButton1DoneActionPerformed
 
    
    /**
     * 
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
            java.util.logging.Logger.getLogger(Create_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_Group().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Done;
    private javax.swing.JButton jButton2Cancel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2Title;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3GroupName;
    private javax.swing.JLabel jLabel4GroupDesc;
    public javax.swing.JLabel jLabel_Email;
    public javax.swing.JLabel jLabel_ID;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1GroupDesc;
    private javax.swing.JTextField jTextField1GroupName;
    // End of variables declaration//GEN-END:variables

    
     private void create_group () {
        String group_name = jTextField1GroupName.getText();
        String group_desc = jTextArea1GroupDesc.getText();
       
        String insert = "INSERT INTO groups(Group_Name,Group_Description) "
                + "VALUES(?, ?)";
        
        try (Connection con = DBConnect.databaseConnect();) {
            
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, group_name);
            pst.setString(2, group_desc);           
            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Group creation successful", "Group created", 1);
            this.dispose();
            
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }  
     
//     private void group_creator()
//     {
//         int userID = Integer.valueOf(jLabel_Email.getText());
//         Boolean isleader = true;
//
//         String select = "SELECT Group_ID FROM groups WHERE Group_Name = bob";
//
//         String insertGroup = "INSERT INTO user_in_group(User_ID, Group_ID, Is_Leader) "
//                    + "VALUES(?, ?, ?)";
//
//         try (Connection con = DBConnect.databaseConnect();) {
//
//                PreparedStatement pst = con.prepareStatement(select);
//
//                int g_ID = pst.executeUpdate();
//
//                System.out.println(g_ID);
//
//                PreparedStatement st = con.prepareStatement(insertGroup);
//                st.setInt(1, userID);
//                st.setInt(2, g_ID); 
//                st.setBoolean(2, isleader); 
//                st.executeUpdate();
//                st.close();
//
//            } catch (SQLException ex) {
//
//                Logger lgr = Logger.getLogger(DBConnect.class.getName());
//                lgr.log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//     }
    
private boolean validate_Inputs () {
    
      if (jTextField1GroupName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Group name field cannot be empty.", "Input Error", 2);
            return false;
        }
      else if (jTextArea1GroupDesc.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Group description cannot be empty.", "Input Error", 2);
            return false;
        }
      else{
          return true;
      }
}

}
