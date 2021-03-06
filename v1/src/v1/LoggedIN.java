/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import database_console.DBConnect;
import database_console.loginConnect;
import group_page.GroupPageLeader;
import group_page.GroupPageMember;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import v1.Login_Interface;

/**
 *
 * @author 818044
 */
public class LoggedIN extends javax.swing.JFrame {

    /**
     * Creates new form LoggedIN
     */
    public LoggedIN() {

        initComponents();
        
        // call findYourGroups function
        findYourGroups();
        
        // call searchGroup function
        searchGroup();
        
        //Sets the form in the centre
        this.setLocationRelativeTo(null);
    }
    
 // function to return users arraylist with particular data 
    public ArrayList<Group_utils> ListUsers()
    {
        ArrayList<Group_utils> groupList = new ArrayList<Group_utils>();
        
        Statement st;
        ResultSet rs;
        
        try{            
            String searchQuery = "SELECT * FROM `user_in_group` WHERE `User_ID` = "+jLabel_displayuserID.getText()+"";
            st = loginConnect.getConnection().prepareStatement(searchQuery);
            rs = st.executeQuery(searchQuery);
            
            Group_utils groups;
            
            while(rs.next())
            {
                groups = new Group_utils(
                                 rs.getInt("User_ID"),
                                 rs.getInt("Group_ID"),
                                 rs.getBoolean("Is_Leader")
                                );
                groupList.add(groups);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return groupList;
    }
    
    // function to display data in jtable
    public final void findYourGroups()
    {
        ArrayList<Group_utils> users = ListUsers();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"User_ID","Group_ID","Is_Leader"});
        Object[] row = new Object[4];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getgroupId();
            row[2] = users.get(i).getIsleader();
            model.addRow(row);
        }
        jTable_YourGroup.setModel(model);
       
    }
    
    
    // function to return users arraylist with particular data 
    public ArrayList<SearchGroup> GroupList(String ValToSearch)
    {
        ArrayList<SearchGroup> searchlist = new ArrayList<SearchGroup>();
        
        Statement st;
        ResultSet rs;
        
        try{            
            String searchQuery = "SELECT * FROM `groups` WHERE CONCAT(`Group_ID`, `Group_Name`, `Group_Description`) LIKE '%"+ValToSearch+"%'";
            st = loginConnect.getConnection().prepareStatement(searchQuery);
            rs = st.executeQuery(searchQuery);
            
            SearchGroup groups;
            
            while(rs.next())
            {
                groups = new SearchGroup(
                                 rs.getInt("Group_ID"),
                                 rs.getString("Group_Name"),
                                 rs.getString("Group_Description")
                                );
                searchlist.add(groups);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return searchlist;
    }
    
    // function to display data in jtable
    public final void searchGroup()
    {
        ArrayList<SearchGroup> users = GroupList("");
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Group ID","Group Name","Group Description"});
        Object[] row = new Object[4];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getgroupId();
            row[1] = users.get(i).getgroupName();
            row[2] = users.get(i).getgroupDescription();
            model.addRow(row);
        }
        jTable_FindGroup.setModel(model);
       
    }
    
    public void JoinGroup()
    {
        PreparedStatement ss;

            int ID = Integer.parseInt(jLabel_displayuserID.getText());

            int row = jTable_FindGroup.getSelectedRow();
            String Table_click = (jTable_FindGroup.getModel().getValueAt(row, 0).toString());
            int gID = Integer.parseInt(Table_click);       

            boolean leader = false;

            try{     
                String insertQuery = "INSERT INTO user_in_group(User_ID, Group_ID, Is_Leader) VALUES(?, ?, ?)";
                ss = loginConnect.getConnection().prepareStatement(insertQuery);                               

                ss.setInt(1, ID);
                ss.setInt(2, gID);
                ss.setBoolean(3, leader);

                ss.executeUpdate();    
                
                JOptionPane.showMessageDialog(null, "You have Joined the Group", "Group Joined",2);
                
                findYourGroups();
           
            } catch (SQLException ex) {

                Logger.getLogger(loginConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel_sidePanel = new javax.swing.JPanel();
        jLabel_close_side_panel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_CreateGroup = new javax.swing.JButton();
        jButton_EnterGroup = new javax.swing.JButton();
        jButton_logout1 = new javax.swing.JButton();
        jButton_Profile = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_YourGroup = new javax.swing.JTable();
        jButton_LeaveGroup = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton_JoinGroup = new javax.swing.JButton();
        jButton_logout2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton_show_side_Panel = new javax.swing.JButton();
        jLabel_displayEmail = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_FindGroup = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel_displayuserID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel_sidePanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_sidePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jLabel_close_side_panel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_close_side_panel.setText("X");
        jLabel_close_side_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_close_side_panelMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Your Groups");

        jButton_CreateGroup.setText("Create Group");
        jButton_CreateGroup.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_CreateGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_CreateGroupMouseClicked(evt);
            }
        });
        jButton_CreateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateGroupActionPerformed(evt);
            }
        });

        jButton_EnterGroup.setText("Enter Group");
        jButton_EnterGroup.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_EnterGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnterGroupActionPerformed(evt);
            }
        });

        jButton_logout1.setText("Log out");
        jButton_logout1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logout1ActionPerformed(evt);
            }
        });

        jButton_Profile.setText("Profile");
        jButton_Profile.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ProfileActionPerformed(evt);
            }
        });

        jTable_YourGroup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Group ID", "Is Leader"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_YourGroup.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable_YourGroup);

        jButton_LeaveGroup.setText("Leave Group");
        jButton_LeaveGroup.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_LeaveGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LeaveGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_sidePanelLayout = new javax.swing.GroupLayout(jPanel_sidePanel);
        jPanel_sidePanel.setLayout(jPanel_sidePanelLayout);
        jPanel_sidePanelLayout.setHorizontalGroup(
            jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_sidePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel_close_side_panel))
                    .addGroup(jPanel_sidePanelLayout.createSequentialGroup()
                        .addGroup(jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_sidePanelLayout.createSequentialGroup()
                                .addGroup(jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton_CreateGroup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(jButton_logout1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_EnterGroup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_LeaveGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 205, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_sidePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        jPanel_sidePanelLayout.setVerticalGroup(
            jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_close_side_panel)
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(234, 234, 234)
                .addGroup(jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_CreateGroup)
                    .addComponent(jButton_LeaveGroup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_EnterGroup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Profile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_logout1)
                .addContainerGap())
            .addGroup(jPanel_sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_sidePanelLayout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(335, Short.MAX_VALUE)))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Search Group");

        jButton_JoinGroup.setText("Join Group");
        jButton_JoinGroup.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_JoinGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_JoinGroupMouseClicked(evt);
            }
        });

        jButton_logout2.setText("Log out");
        jButton_logout2.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logout2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("User's email:");

        jButton_show_side_Panel.setText("Show Side Panel");
        jButton_show_side_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton_show_side_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_show_side_PanelMouseClicked(evt);
            }
        });

        jLabel_displayEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTable_FindGroup.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jTable_FindGroup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Group ID", "Group Name", "Group Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_FindGroup.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable_FindGroup);

        jLabel1.setText("User's ID:");

        jLabel_displayuserID.setText("####");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel_sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_displayEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_displayuserID, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton_JoinGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_show_side_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_logout2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_displayEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_displayuserID))
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_logout2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_show_side_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_JoinGroup)))
                .addGap(45, 45, 45))
            .addComponent(jPanel_sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateGroupActionPerformed
        Create_Group g_form = new Create_Group();
        g_form.setVisible(true);
        g_form.pack();
        
        g_form.jLabel_Email.setText(jLabel_displayEmail.getText());
        g_form.jLabel_ID.setText(jLabel_displayuserID.getText());
        
        this.dispose();
        
    }//GEN-LAST:event_jButton_CreateGroupActionPerformed

    private void jButton_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ProfileActionPerformed
        //Shows the User interface
        int user_idx = Integer.parseInt(jLabel_displayuserID.getText());
        String user_emailx = jLabel_displayEmail.getText();
        User_Interface profile_form = new User_Interface(user_idx, user_emailx);
        profile_form.setVisible(true);       
    }//GEN-LAST:event_jButton_ProfileActionPerformed

    private void jButton_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logout1ActionPerformed
        //Log Out and Show the log in form
        Login_Interface log_form = new Login_Interface();
        log_form.setVisible(true);
        log_form.pack();
        
        this.dispose();
    }//GEN-LAST:event_jButton_logout1ActionPerformed

    private void jButton_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logout2ActionPerformed
        //Log Out and Show the log in form
        Login_Interface log_form = new Login_Interface();
        log_form.setVisible(true);
        log_form.pack();
        
        this.dispose();
    }//GEN-LAST:event_jButton_logout2ActionPerformed

    private void jLabel_close_side_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_close_side_panelMouseClicked
        //Closes the side panel
        jPanel_sidePanel.setVisible(false);
    }//GEN-LAST:event_jLabel_close_side_panelMouseClicked

    private void jButton_show_side_PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_show_side_PanelMouseClicked
        //Opens up the side panel
        jPanel_sidePanel.setVisible(true);
    }//GEN-LAST:event_jButton_show_side_PanelMouseClicked

    private void jButton_LeaveGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LeaveGroupActionPerformed
        PreparedStatement st;
        PreparedStatement rt;
        
        //This function will get the group id
        int group_id = jTable_YourGroup.getSelectedRow();
        String Table_click_For_Group = (jTable_YourGroup.getModel().getValueAt(group_id, 1).toString());
        
        //This function will get if the user is leader or not
        int row = jTable_YourGroup.getSelectedRow();
        String Table_click = (jTable_YourGroup.getModel().getValueAt(row, 2).toString());
        boolean isleader;
        if(Table_click == "true")
        {
            isleader = true;
        }
        else 
        {
            isleader = false;
        }       
        
        try {
            if(isleader)
            {                        
                //Delete the selected group id
                String Del_user_in_group = "DELETE FROM user_in_group WHERE Group_ID = '"+Table_click_For_Group+"'";
                String Del_groups = "DELETE FROM groups WHERE Group_ID = '"+Table_click_For_Group+"'";    
                st = loginConnect.getConnection().prepareStatement(Del_user_in_group);
                rt = loginConnect.getConnection().prepareStatement(Del_groups);
                st.executeUpdate();
                rt.executeUpdate();
                JOptionPane.showMessageDialog(null, "You have left the Group " + Table_click_For_Group + "and Group " + Table_click_For_Group + " has been deleted", "Group Deletion",2); 

                findYourGroups();
                searchGroup();
            }
            else
            {       
                //Delete the selected group id
                String Del_user_in_group = "DELETE FROM user_in_group WHERE Group_ID = '"+Table_click_For_Group+"'";
                st = loginConnect.getConnection().prepareStatement(Del_user_in_group);
                st.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "You have left the Group " + Table_click_For_Group , "Group Deletion",2);
                
                findYourGroups();
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //
    }//GEN-LAST:event_jButton_LeaveGroupActionPerformed

    private void jButton_EnterGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnterGroupActionPerformed
        //Finding the selected group
        PreparedStatement ss;
        ResultSet rs;       
        int user_idx = Integer.parseInt(jLabel_displayuserID.getText());
        //This function will get the group id
        int group_id = jTable_YourGroup.getSelectedRow();
        String Table_click_For_Group = (jTable_YourGroup.getModel().getValueAt(group_id, 1).toString());
        String GroupID = Table_click_For_Group;
        
        //This function will get if the user is leader or not
        int row = jTable_YourGroup.getSelectedRow();
        String Table_click = (jTable_YourGroup.getModel().getValueAt(row, 2).toString());
        boolean isleader;
        if(Table_click == "true")
        {
            isleader = true;
        }
        else 
        {
            isleader = false;
        }
        
        try{                                                                     
            String searchQuery = "SELECT * FROM user_in_group WHERE Is_Leader ='"+Table_click+"' AND User_ID = "+jLabel_displayuserID.getText()+" ";
            ss = loginConnect.getConnection().prepareStatement(searchQuery);
            rs = ss.executeQuery();                       
            String email = jLabel_displayEmail.getText();
            if(rs.next()) {
                if(isleader)
                {     
                    //Dylan's user interface for when they are a leader
                    System.out.println(GroupID);
                    GroupPageLeader leader_form = new GroupPageLeader(Integer.parseInt(GroupID),user_idx,email);
                    leader_form.setVisible(true);
                    leader_form.pack();
                    
                    JOptionPane.showMessageDialog(null, "You are in the Group " + GroupID + " and you are the leader", "Group Interface",2);
                    
                }
                else 
                    {
                        //Dylan's user interface for when they are not a leader
                        GroupPageMember member_form = new GroupPageMember(Integer.parseInt(GroupID),user_idx,email);
                        member_form.setVisible(true);
                        member_form.pack();
                        
                        JOptionPane.showMessageDialog(null, "You are in the Group " + GroupID, "Group Interface",2);
                    }
            }
        }       
        catch(Exception e){        
        JOptionPane.showMessageDialog(null, e);        
        }        
    }//GEN-LAST:event_jButton_EnterGroupActionPerformed

    private void jButton_JoinGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_JoinGroupMouseClicked
        
        PreparedStatement st;
        ResultSet rs;
        
        int group_id = jTable_FindGroup.getSelectedRow();
        String Table_click_For_Group = (jTable_FindGroup.getModel().getValueAt(group_id, 0).toString());
        String GroupID = Table_click_For_Group;
        
        boolean already_in_group = false;
        
        String searchQuery = "SELECT * FROM user_in_group WHERE Group_ID = ?";
        
        try {
            st = loginConnect.getConnection().prepareStatement(searchQuery);
            
            st.setString(1, GroupID);
            rs = st.executeQuery();
            
            if(rs.next())
            {
                already_in_group = true;
                JOptionPane.showMessageDialog(null, "You are already in the group", "Error", 2);
            }      
            else
            {
                JoinGroup();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_JoinGroupMouseClicked

    private void jButton_CreateGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CreateGroupMouseClicked
        //Shows the Create Group interface
        Create_Group create_group_form = new Create_Group();
        create_group_form.setVisible(true);
        create_group_form.pack();
    }//GEN-LAST:event_jButton_CreateGroupMouseClicked
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
            java.util.logging.Logger.getLogger(LoggedIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoggedIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoggedIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoggedIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoggedIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CreateGroup;
    private javax.swing.JButton jButton_EnterGroup;
    private javax.swing.JButton jButton_JoinGroup;
    private javax.swing.JButton jButton_LeaveGroup;
    private javax.swing.JButton jButton_Profile;
    private javax.swing.JButton jButton_logout1;
    private javax.swing.JButton jButton_logout2;
    private javax.swing.JButton jButton_show_side_Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_close_side_panel;
    public javax.swing.JLabel jLabel_displayEmail;
    public javax.swing.JLabel jLabel_displayuserID;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_sidePanel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable_FindGroup;
    private javax.swing.JTable jTable_YourGroup;
    // End of variables declaration//GEN-END:variables
}
