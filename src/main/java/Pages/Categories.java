/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author godpo
 */
public class Categories {
    
    private String id;
    private String name;
    
    public Categories(){
        
    }
    
    public Categories(String name, String id){
        this.id = id;
        this.name = name;
    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setID(String id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int count(){
        ResultSet rs;
        PreparedStatement ps;
        
        String query = "SELECT COUNT(name) as 'Count' FROM Categories";
        
        try {
            ps = DataLink.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer count = rs.getInt("Count");
                return count;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean addCategory(){
        String query = "INSERT INTO Categories VALUES (?, ?)";
        
        
        try {
            PreparedStatement ps = DataLink.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public boolean checkExistence(){
        ResultSet rs;
        PreparedStatement ps;
        
        String validateQuery = "SELECT * FROM Categories WHERE name = ? AND id = ?";
        try {
            ps = DataLink.getConnection().prepareStatement(validateQuery);
            ps.setString(1, name);
            ps.setString(2, id);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    
    public boolean removeCategory(){
        
        String query = "DELETE FROM Categories WHERE name = ? AND id = ?";
        
        //Performing the action
        try {
            PreparedStatement ps = DataLink.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Categories> getCategoryList(){
        ArrayList<Categories> list  = new ArrayList<>();
        
        String selectQuery = "SELECT * FROM Categories";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = DataLink.getConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            Categories category;
            while(rs.next()){
                category = new Categories(rs.getString("name"), rs.getString("id"));
                list.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean purge(){
        Component parentComponent = null;
        int result = JOptionPane.showConfirmDialog(parentComponent, "Confirm To Purge All Contents Within This Table?", "Purge Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if(result == JOptionPane.OK_OPTION){
            String purgeQuery = "DELETE FROM Categories";
            try {
                PreparedStatement ps = DataLink.getConnection().prepareStatement(purgeQuery);
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "Purge Failed! Possible Database errors and/or corruption!", "Process Failure!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        return false; 
        
    }
}
