/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_page;
import database_console.DBConnect;
import java.awt.BorderLayout;
import java.util.ArrayList;
import v1.Group_utils;
import javax.swing.DefaultListModel;
import static v1.Group_utils.getMemDetails;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import v1.Leader;
/**
 *
 * @author Dylan Ritchings
 */
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import v1.Group_utils;
import v1.Leader;
import v1.Task_Create;
import v1.Task_View;

/**
 *
 * @author Dylan Ritchings
 */
public final class GroupPageLeader extends javax.swing.JFrame {
    int groupID;
            

    ArrayList<String> id;
    ArrayList<String> forename;
    ArrayList<String> surname;
    ArrayList<String> email;
    ArrayList<String> tasksDone;
    ArrayList<ArrayList<String>> memDetails;

    DefaultListModel memberLm;

    ArrayList<String> taskID;
    ArrayList<String> taskTitle;
    ArrayList<String> taskStart;
    ArrayList<String> taskEnd;
    ArrayList<String> taskDesc;
    ArrayList<String> taskComp;
    
    
    
    
    /**
     * Creates new form GroupPage
     * @param currentGroupID
     * @throws java.sql.SQLException
     */
    public GroupPageLeader(int currentGroupID) throws SQLException {
        this.groupID = currentGroupID;
        this.memDetails = Group_utils.getMemDetails(groupID);
        this.memberLm = new DefaultListModel();

        this.id = memDetails.get(0);
        this.forename = memDetails.get(1);
        this.surname = memDetails.get(2);
        this.email = memDetails.get(3);
        this.tasksDone = memDetails.get(4);
        
        ArrayList<ArrayList<String>> taskDetails = Group_utils.getTaskDetails(groupID);
        this.taskID = taskDetails.get(0);
        this.taskTitle = taskDetails.get(1);
        this.taskStart = taskDetails.get(2);
        this.taskEnd = taskDetails.get(3);
        this.taskDesc = taskDetails.get(4);
        this.taskComp = taskDetails.get(5);
        
        initComponents();
        fillMemDetails();
        try {
            fillTaskDetails();
        } catch (ParseException ex) {
            Logger.getLogger(GroupPageLeader.class.getName()).log(Level.SEVERE, null, ex);
        }
        groupName();
    }

    /**
     *
     * @throws SQLException
     */
    public void groupName() throws SQLException{
        String query = "SELECT Group_Name FROM groups WHERE Group_ID="+ groupID +";";
        ResultSet groupNamers = DBConnect.databaseSelect(query);
        while (groupNamers.next()) {
            String groupName = groupNamers.getString("Group_Name");
            nameLabel.setText("Group: " + groupName);
 
        }
    }
    /**
     * Fill each task into the taskPanel
     * @throws ParseException 
     */
    public void fillTaskDetails() throws ParseException{
        Container cont = new Container();
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        //BoxLayout taskLayout = new BoxLayout (taskPane,BoxLayout.Y_AXIS);
        taskPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        for (int count = 0; count < taskID.size(); count++){
            JPanel taskPanel  = new TaskViewLeader(taskID.get(count), taskTitle.get(count), taskStart.get(count), taskEnd.get(count), taskDesc.get(count), taskComp.get(count));
            cont.add(taskPanel, BorderLayout.LINE_START);

           }
        taskPane.getViewport().setView(cont);
        //taskPane.add(cont);
        //taskPane.setVisible(true);
        taskPane.revalidate();
        taskPane.repaint();
    }
    /**
     * Fills member names of the current group into the members list.
     */
    public void fillMemDetails(){
        String [] members = getMemNames(groupID);
        for (String member : members) {

            memberLm.addElement(member);
            
        }
        
        memberList.setModel(memberLm);
        removeMember.setEnabled(false); 
        viewProfile.setEnabled(false);
    }
    /**
     * Creates an array containing names of people in a group.
     * @param groupID
     * @return memNames
     */
     public String[] getMemNames(int groupID)
    {
        
        //ArrayList<String> memNames = new ArrayList<>();
       
        String memNames[] = new String[forename.size()];
        for (int x = 0; x < forename.size(); x++)
        {
            String fName = forename.get(x);
            String sName = surname.get(x);
            //MemberList.addElement(fName + " " + sName);
            memNames[x]=(fName + " " + sName);
            
        }
        return memNames;
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberList = new javax.swing.JList<String>();
        removeMember = new javax.swing.JToggleButton();
        addMember = new javax.swing.JButton();
        taskPane = new javax.swing.JScrollPane();
        viewProfile = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        createTaskButton = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        memberList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                memberListFocusGained(evt);
            }
        });
        memberList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memberList);

        removeMember.setText("Remove member");
        removeMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMemberActionPerformed(evt);
            }
        });

        addMember.setText("Add Member");
        addMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberActionPerformed(evt);
            }
        });

        taskPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        taskPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        viewProfile.setText("View Profile");
        viewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfileActionPerformed(evt);
            }
        });

        nameLabel.setText("jLabel1");

        jLabel1.setText("Users:");

        createTaskButton.setText("Create Task");
        createTaskButton.setActionCommand("createTaskButton");
        createTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(taskPane, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createTaskButton))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removeMember)
                                    .addComponent(jLabel1))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewProfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMember, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(nameLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMember)
                    .addComponent(viewProfile)
                    .addComponent(createTaskButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskPane, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeMember)))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Removes a member from a group
     * @param evt 
     */
    private void removeMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMemberActionPerformed
        int memIndex = memberList.getSelectedIndex();
        Integer memID = Integer.valueOf(id.get(memIndex));
        Leader.deleteMember(memID, groupID);
        id.remove(memIndex);
        forename.remove(memIndex);
        surname.remove(memIndex); 
        email.remove(memIndex);
        tasksDone.remove(memIndex);
        memberLm.removeElement(memIndex);
        ((DefaultListModel) memberList.getModel()).remove(memIndex);
        
    }//GEN-LAST:event_removeMemberActionPerformed

   
    /**
     * Opens AddMember.java
     * @param evt 
     */
    
    private void addMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberActionPerformed
         AddMember addMember = new AddMember(groupID);
         addMember.setVisible(true);
         this.setVisible(false);
         
    }//GEN-LAST:event_addMemberActionPerformed

    private void memberListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_memberListFocusGained
        removeMember.setEnabled(true); 
        viewProfile.setEnabled(true);
    }//GEN-LAST:event_memberListFocusGained

    private void memberListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberListMouseClicked

    }//GEN-LAST:event_memberListMouseClicked

    private void viewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProfileActionPerformed
        int memIndex = memberList.getSelectedIndex();
        Integer memID = Integer.valueOf(id.get(memIndex));
        //CONNECT TO USER PROFILE
    }//GEN-LAST:event_viewProfileActionPerformed

    private void createTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTaskButtonActionPerformed
        JFrame taskCreate = new Task_Create(groupID);
        taskCreate.setVisible(true);
    }//GEN-LAST:event_createTaskButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GroupPageLeader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupPageLeader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupPageLeader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupPageLeader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GroupPageLeader(128).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GroupPageLeader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMember;
    private javax.swing.JButton createTaskButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> memberList;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JToggleButton removeMember;
    private javax.swing.JScrollPane taskPane;
    private javax.swing.JButton viewProfile;
    // End of variables declaration//GEN-END:variables
}
