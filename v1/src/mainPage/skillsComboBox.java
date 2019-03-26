/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPage;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import v1.Group_utils;

/**
 *
 * @author Dylan Ritchings
 */
public class skillsComboBox extends JComboBox{
    int groupID = 123;
    ArrayList skillsal = Group_utils.getSkills(groupID);
    String[] skills = (String[]) skillsal.toArray(new String[skillsal.size()]);
    JComboBox skillList = new JComboBox(skills);
    //skillList.addActionListener(this);
}
