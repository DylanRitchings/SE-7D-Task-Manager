/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import database_console.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Creates a form which is used to specify a task that the user wants to delete.
 * 
 * @author Konstantin Georgiev
 */
public class Task_Delete extends javax.swing.JFrame {

    /**
     * Creates new form Task_Delete
     */
    public Task_Delete() {
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

        jLabel_heading = new javax.swing.JLabel();
        jLabel_assignee_email = new javax.swing.JLabel();
        jLabel_title = new javax.swing.JLabel();
        jTextField_assignee_email = new javax.swing.JTextField();
        jTextField_title = new javax.swing.JTextField();
        jButton_delete_task = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_heading.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_heading.setText("Delete task");

        jLabel_assignee_email.setText("Task assignee email");

        jLabel_title.setText("Task title");

        jTextField_assignee_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_assignee_emailActionPerformed(evt);
            }
        });

        jButton_delete_task.setText("Delete task");
        jButton_delete_task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_delete_taskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_assignee_email)
                                    .addComponent(jLabel_title))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_assignee_email)
                                    .addComponent(jTextField_title, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                            .addComponent(jLabel_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton_delete_task)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel_heading)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_assignee_email)
                    .addComponent(jTextField_assignee_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_title)
                    .addComponent(jTextField_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_delete_task)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Validate whether the input fields were left empty upon submission.
     * 
     * @return whether validations were successful
     */
    private boolean validate_Inputs() {
        if (jTextField_assignee_email.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Assignee email field cannot be empty.", "Input Error", 2);
            return false;
        }
        else if (jTextField_title.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Task title field cannot be empty.", "Input Error", 2);
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * Validates whether the entered email of the user to which the task is to
     * be assigned to is actually a registered member in the database.
     * 
     * @return whether the validation was successful or not.
     */
    private boolean validate_Email() {
        String user_email = jTextField_assignee_email.getText();

        String select = "SELECT * FROM `user` WHERE `User_Email` = ? ";
        ResultSet rs;
        
        try (Connection con = DBConnect.databaseConnect();) {
            
            PreparedStatement pst = con.prepareStatement(select);
            pst.setString(1, user_email);
            
            rs = pst.executeQuery();
            
            
            if (!rs.next()) {

                JOptionPane.showMessageDialog(null, "No user registered with this email", "Input Error", 2);
                return false;
            }
            else {
                return true;
            }
            

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return false;
    }
    
    /**
     * Validates whether the specified task to be deleted actually exists in the
     * database.
     * 
     * @return whether validation was successful.
     */
    private boolean validate_task_exists () {
        String assignee_email = jTextField_assignee_email.getText();
        String task_title = jTextField_title.getText();

        String select = "SELECT * FROM `task` WHERE `assignee_email` = ? AND `Task_Title` = ?";
        ResultSet rs;
        
        try (Connection con = DBConnect.databaseConnect();) {
            
            PreparedStatement pst = con.prepareStatement(select);
            pst.setString(1, assignee_email);
            pst.setString(2, task_title);
            
            rs = pst.executeQuery();
            
            
            if (!rs.next()) {

                JOptionPane.showMessageDialog(null, "No such task exists assigned to this user", "Input Error", 2);
                return false;
            }
            else {
                return true;
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return false;
    }
    
    /**
     * Takes the inputs from the form fields and uses them in an SQL query to
     * delete the task from the database.
     */
    private void delete_task () {
        String assignee_email = jTextField_assignee_email.getText();
        String task_title = jTextField_title.getText();

        String delete = "Delete FROM `task` WHERE `assignee_email` = ? AND `Task_Title` = ?";
        
        try (Connection con = DBConnect.databaseConnect();) {
            
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1, assignee_email);
            pst.setString(2, task_title);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Task deleted succsessfully", "Delete successful", 1);
            this.dispose();
            
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }
    
    private void jTextField_assignee_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_assignee_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_assignee_emailActionPerformed

    /**
     * When the button is pressed it calls all of the validation functions and 
     * if they all pass it calls the delete_task function to delete the task 
     * from the database.
     * 
     * @param evt when the button is pressed.
     */
    private void jButton_delete_taskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_delete_taskActionPerformed
        if (validate_Inputs() && validate_Email() && validate_task_exists()) {
            delete_task();
        }
    }//GEN-LAST:event_jButton_delete_taskActionPerformed

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
            java.util.logging.Logger.getLogger(Task_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task_Delete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_delete_task;
    private javax.swing.JLabel jLabel_assignee_email;
    private javax.swing.JLabel jLabel_heading;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JTextField jTextField_assignee_email;
    private javax.swing.JTextField jTextField_title;
    // End of variables declaration//GEN-END:variables
}
