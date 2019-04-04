/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_page;


import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.UIManager;
import v1.*;

/**
 *
 * @author Dylan Ritchings
 */
public class TaskViewLeader extends javax.swing.JPanel {
    String id;
    String title;
    String start;
    String end;
    String desc;
    Boolean comp;
    /**
     * Creates new form TaskView
     * @param tId ID of the task within the database
     * @param tTitle title of the task within the database
     * @param tStart start time of the task within the database
     * @param tEnd end time of the task within the database
     * @param tDesc description of the task within the database
     * @param tComp whether the task is marked 
     * @throws java.text.ParseException Exception if a problem occurs
     */
    public TaskViewLeader(String tId, String tTitle, String tStart, String tEnd, String tDesc, String tComp) throws ParseException {
        id = tId;
        title = tTitle;
        start = tStart;
        end = tEnd;
        desc = tDesc;
        if ( Integer.valueOf(tComp) == 1){
            comp = true;
        }
        else{
            comp = false;
        }
        initComponents();
        titleLabel.setText("Task: "+title);
        descLabel.setText(desc);
        startLabel.setText("Start: "+start);
        endLabel.setText("Deadline: "+end);
        timeLeft.setStringPainted(true);
        
        timeLeftPb();
    }
/**
 * Sets the values for the timeLeft ProgressBar
 * @throws ParseException 
 */
    private void timeLeftPb() throws ParseException{
        
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat(pattern);

        String current = simpleDateFormat.format(new Date());
        
        Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(current);
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
        int currentTime = (int) (currentDate.getTime() / (24 * 60 * 60 * 1000));
        int startTime = (int) (startDate.getTime() / (24 * 60 * 60 * 1000));
        
        int endTime = (int) (endDate.getTime() / (24 * 60 * 60 * 1000));
        
        int progressMax = endTime - startTime;
        int progressPoint = currentTime - startTime;
        int daysLeft = progressMax - progressPoint;
        timeLeft.setString("Time left: "+ daysLeft + " days");
        if (progressMax < progressPoint && comp == false) {
            //UIManager.put("timeLeft.selectionForeground",Color.RED);
            //UIManager.put("timeLeft.selectionBackground",Color.RED);
            //timeLeft.setForeground(Color.red);
            timeLeft.setString("Overdue");  
        }
        else if (comp == true){
            timeLeft.setString("Complete");
        }
        timeLeft.setMaximum(progressMax);
        timeLeft.setValue(progressPoint);
        timeLeft.setVisible(true);
        
        
             
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        taskViewButton = new javax.swing.JButton();
        taskEditButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descLabel = new javax.swing.JTextPane();
        timeLeft = new javax.swing.JProgressBar();

        titleLabel.setText("jLabel1");

        startLabel.setText("jLabel3");

        endLabel.setText("jLabel4");

        taskViewButton.setText("View");
        taskViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskViewButtonActionPerformed(evt);
            }
        });

        taskEditButton.setText("Edit");
        taskEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskEditButtonActionPerformed(evt);
            }
        });

        descLabel.setCaretColor(new java.awt.Color(204, 204, 255));
        descLabel.setFocusable(false);
        descLabel.setOpaque(false);
        descLabel.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(descLabel);

        timeLeft.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(taskViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endLabel))
                    .addComponent(timeLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(startLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(taskViewButton)
                        .addComponent(endLabel)
                        .addComponent(taskEditButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void taskViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskViewButtonActionPerformed
        JFrame taskView = new Task_View(Integer.parseInt(id));
        taskView.setVisible(true);
    }//GEN-LAST:event_taskViewButtonActionPerformed

    private void taskEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskEditButtonActionPerformed
        JFrame taskEdit = new Task_Edit(Integer.parseInt(id));
        taskEdit.setVisible(true);
    }//GEN-LAST:event_taskEditButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane descLabel;
    private javax.swing.JLabel endLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel startLabel;
    private javax.swing.JButton taskEditButton;
    private javax.swing.JButton taskViewButton;
    private javax.swing.JProgressBar timeLeft;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
