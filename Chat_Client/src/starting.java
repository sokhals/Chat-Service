
import java.awt.BorderLayout;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GRE
 */
public class starting extends JFrame 
{
    JProgressBar pb;
    JLabel pics;
    starting()
    {
        setSize(500,350);
        setLocation(300,90);
        setLayout(null);
        pics=new JLabel();
       // pics.setIcon(new ImageIcon("D:\\start.png"));
        pics.setBounds(0,0,500,300);
        add(pics);
        
        
        
      
       
    }
    public static void main(String arg[]) 
    {
         starting obk =new starting();
         
         obk.setVisible(true);
         
         
    }
    
    
}
