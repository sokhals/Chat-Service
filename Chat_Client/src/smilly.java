
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GRE
 */
public class smilly extends JFrame implements ActionListener{
    JTabbedPane tp;
    int number;
    JScrollPane jsp[]=new JScrollPane[6];
    JPanel p[]=new JPanel[6];
    JButton dne;
    JButton faces[]=new JButton[15],heart[]=new JButton[9],item[]=new JButton[20],ptato[]=new JButton[9],smily[]=new JButton[41],joker[]=new JButton[6];
    smilly()
    {
       
        setSize(420,500);
       
       
        for(int i=0;i<6;i++)
        {
            
            jsp[i]=new JScrollPane();
            p[i]=new JPanel();
            p[i].setBackground(Color.WHITE);
            jsp[i].setViewportView(p[i]);
            
        }
        String address="/Users/surinder/Documents/workspace/Chat_Client/src/images";
        
        tp=new JTabbedPane();
        tp.setForeground(Color.WHITE);
        tp.insertTab(null, new ImageIcon(address+"/1.png"), jsp[0], null,tp.getTabCount());
        tp.insertTab(null, new ImageIcon(address+"/17.png"), jsp[1], null,tp.getTabCount());
        tp.insertTab(null, new ImageIcon(address+"/53.png"), jsp[2], null,tp.getTabCount());
        tp.insertTab(null, new ImageIcon(address+"/78.png"), jsp[3], null,tp.getTabCount());
        tp.insertTab(null, new ImageIcon(address+"/98.png"), jsp[4], null,tp.getTabCount());
        tp.insertTab(null, new ImageIcon(address+"/32.png"), jsp[5], null,tp.getTabCount());
//        for(int i=0;i<5;i++)
//        {
//            add(jsp[i]);
//        }
      
      
        for(int i=0;i<6;i++)
        {
        p[i].setLayout(new GridLayout(5,3, 5, 5));
        }
        for(int i=0;i<15;i++)
        {
            faces[i]=new JButton(":-"+String.valueOf(i+1));
            faces[i].setBackground(Color.LIGHT_GRAY);
            faces[i].setBorder(new BevelBorder(BevelBorder.RAISED));
            faces[i].setIcon(new ImageIcon(address+"/"+String.valueOf(i+1)+".png"));
            repaint();
            faces[i].addActionListener(this);
        p[0].add(faces[i]);    
            
        }
         for(int i=0;i<9;i++)
        {
            ptato[i]=new JButton(":-"+String.valueOf(16+i));
            ptato[i].setIcon(new ImageIcon(address+"/"+String.valueOf(i+16)+".png"));
            repaint();
            ptato[i].addActionListener(this);
        p[1].add(ptato[i]);    
            
        }
          for(int i=0;i<41;i++)
        {
            smily[i]=new JButton(":-"+String.valueOf(i+34));
            smily[i].setIcon(new ImageIcon(address+"/"+String.valueOf(i+34)+".png"));
            repaint();
            smily[i].addActionListener(this);
        p[2].add(smily[i]);    
            
        }
           for(int i=0;i<6;i++)
        {
            joker[i]=new JButton(":-"+String.valueOf(75+i));
            joker[i].setIcon(new ImageIcon(address+"/"+String.valueOf(i+75)+".png"));
            joker[i].setBorderPainted(true);
           // joker[i].setContentAreaFilled(false);
            joker[i].setOpaque(false);
            repaint();
            joker[i].addActionListener(this);
        p[3].add(joker[i]);    
            
        }
            for(int i=0;i<20;i++)
        {
            item[i]=new JButton(":-"+String.valueOf(i+81));
            item[i].setIcon(new ImageIcon(address+"/"+String.valueOf(i+81)+".png"));
            repaint();
            item[i].addActionListener(this);
        p[4].add(item[i]);    
            
        }
             for(int i=0;i<9;i++)
        {
            heart[i]=new JButton(":-"+String.valueOf(25+i));
            heart[i].setIcon(new ImageIcon(address+"/"+String.valueOf(i+25)+".png"));
            repaint();
            //heart[i].addActionListener(this);
        p[5].add(heart[i]);    
            
        }
        
       add(tp);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
       //System.out.println(s);
        for(int i=1;i<101;i++)
        {
            if(s.equals(":-"+String.valueOf(i)))
            {
                number=i;
                setVisible(false);
                dispose();
                break;
            }
        }
        
    }
    
}
