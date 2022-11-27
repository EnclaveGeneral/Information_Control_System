/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author godpo
 */
public class VisualDisplay{
    
    public void VisualDisplay(){
        
    }
    
    public void displayImageFrame(int width, int height, String imagePath, JLabel label){
        
        
        
        ImageIcon icon = new ImageIcon(imagePath);
        //Shrink or Expand To Fit Accordingly
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        //Insert The Frame Into The JLabel
        label.setIcon(new ImageIcon(image));
    }
}
