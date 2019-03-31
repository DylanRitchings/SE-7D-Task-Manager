/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

/**
 *
 * @author up818044
 */
public class SearchGroup {
    /**
     * @param Group_ID
     * @param Group_Name
     * @param Group_Description
     */
    
    private int Group_ID;
    private String Group_Name;
    private String Group_Description;
    
    public SearchGroup(int Group_ID, String Group_Name ,String Group_Description)
    {
        this.Group_ID = Group_ID;
        this.Group_Name = Group_Name;
        this.Group_Description = Group_Description;
    }
    
    public int getgroupId()
    {
        return Group_ID;
    }
    
    public String getgroupName()
    {
        return Group_Name;
    }
    
    public String getgroupDescription()
    {
        return Group_Description;
    }
}
