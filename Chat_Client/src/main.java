
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.EditorKit;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author GRE
 */
public class main extends JFrame implements KeyListener, Runnable, ActionListener, WindowListener {

    layout l;
    smilly sda;
    priv prii;
    Image img[] = new Image[50];
    Image ii;
    Toolkit toolkit;
    Color cc;
    Boolean check = false, windowchk = false;
    JButton b[] = new JButton[100];
    BufferedReader bf;
    Socket skt;
    int primsgcounter = 0;
    JLabel primsg[] = new JLabel[5000];
    JButton nmlk[] = new JButton[15];
    PrintStream ps;
    Thread t;
    int locx = 1600, locy = 600;
    String name;
    int i = 0, x = 10, y = 10;
    JLabel message[] = new JLabel[1000];
    int messagecnter = 0;
    String list[] = new String[100];
    ImageIcon img1;
    Boolean bg = false;
    String nm[] = new String[100];
    int counter = 0;
    String ar;
    int r, g, blu, iimg;
    Random rnm;
    File f;
    String allmsg = "";
    int no = -1;
    String Messg = "";
    String servername="";
    main(String tt) {

        name = tt;
servername="GRE-PC";
        rnm = new Random();
        r = rnm.nextInt(255);
        g = rnm.nextInt(255);
        blu = rnm.nextInt(255);
        iimg = rnm.nextInt(20);
        img1 = new ImageIcon("src\\seticon\\" + String.valueOf(iimg) + ".png");

        //ystem.out.println(String.valueOf(c));

        try {
            try {

               // toolkit = Toolkit.getDefaultToolkit();
try
{
                InetAddress ip = InetAddress.getByName(servername);

                skt = new Socket(ip, 1001);
                ps = new PrintStream(skt.getOutputStream());
                bf = new BufferedReader(new InputStreamReader(skt.getInputStream()));
}catch(Exception ee)
{
    JOptionPane.showMessageDialog(null,ee);
}
                f = new File("D:\\images\\logo.png");
                ii = ImageIO.read(f);
                ps.println("NM" + name);
            } catch (Exception e) {
                
            }
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 100; i++) {
            nm[i] = "";

        }
        l = new layout();
        l.setVisible(true);
        l.setLocation(320, 150);
        l.jLabel3.setText(null);
        l.jLabel3.setText(name);
        l.jLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        //l.jLabel3.setForeground(new Color(r, g, blu));
        l.jLabel3.setIcon(new ImageIcon(String.valueOf(img1)));
        //l.setUndecorated(true);
        l.isAlwaysOnTopSupported();
        l.isAutoRequestFocus();
        l.isAlwaysOnTop();
        l.jEditorPane1.setEditable(false);
        l.jTextField1.requestFocus();
        l.jEditorPane1.setBackground(Color.GRAY);


        repaint();

        repaint();
        l.setTitle("CHAT");
        // l.setSize(600,500);
        l.setIconImage(ii);
        l.setResizable(false);
        // l.jTextField1.setText("");
        // l.jTextField1.setFocusable(true);
        // l.jTextPane1.setEditable(false);
        sda = new smilly();



        l.jButton1.addActionListener(this);
        l.jButton2.addActionListener(this);

        for (int i = 0; i < 9; i++) {
            sda.heart[i].addActionListener(this);

        }
        for (int i = 0; i < 15; i++) {
            sda.faces[i].addActionListener(this);

        }
        for (int i = 0; i < 9; i++) {
            sda.ptato[i].addActionListener(this);

        }
        for (int i = 0; i < 41; i++) {
            sda.smily[i].addActionListener(this);

        }
        for (int i = 0; i < 6; i++) {
            sda.joker[i].addActionListener(this);

        }
        for (int i = 0; i < 20; i++) {
            sda.item[i].addActionListener(this);

        }



        l.jTextField1.addKeyListener(this);
        l.addWindowListener(this);
        l.jPanel2.setLayout(new GridLayout(40, 1));
        t = new Thread(this);
        t.start();

    }

    public void run() {
        JLabel l1[] = new JLabel[100];
        String total = "";
        int iii = 0;

        try {

            while (true) {
                String temp = null;

                while ((temp = bf.readLine()) != null) {


                    if (temp.startsWith("MESS")) {
                        System.out.println(temp);
                        String readd = "", sdd = "";
                        String jk[] = temp.substring(temp.indexOf(">") + 1, temp.indexOf(";")).split(" ");
                        for (int i = 0; i < jk.length; i++) {


                            if (jk[i].startsWith(":-")) {
                                sdd = "<img src=\"" + this.getClass().getClassLoader().getResource("images/" + jk[i].substring(jk[i].indexOf("-") + 1) + ".png").toString() + "\" />";

                                readd = readd + " " + sdd;
                                System.out.println(sdd);

                            } else {
                                readd = readd + " " + jk[i];

                            }

                        }
                        String rang[] = temp.substring(temp.indexOf("{") + 1).split(" ");
                        for (int i = 0; i < rang.length; i++) {
                            System.out.println(rang[i]);
                        }


                        String imass = temp.substring(temp.indexOf(";") + 1);
                        System.out.println(imass);
                        readd = "<img src=\"" + this.getClass().getClassLoader().getResource("seticon/" + imass.substring(imass.indexOf("n") + 2, imass.indexOf("{"))).toString() + "\" /> <B>" + temp.substring(temp.indexOf("<") - 1, temp.indexOf(">") + 1) + "</FONT></B> " + readd;
                        total = readd + "\n \n" + total;
                        //System.out.println(readd);


                        if (sdd.equals("")) {
                            String tobeset = readd + l.jEditorPane1.getText();
                            l.jEditorPane1.setText(tobeset);
                        } else {
                            String tobeset = readd + l.jEditorPane1.getText();
                            l.jEditorPane1.setText(tobeset);
                        }

                        // System.out.println(tobeset);


                        l.jEditorPane1.repaint();

                    }

                    if (temp.startsWith("NLIST")) {
                        System.out.println(messagecnter);
                        for (int i = 0; i < messagecnter; i++) {
                            l.jPanel2.remove(nmlk[i]);

                        }
                        messagecnter = 0;

                        //l.jTextPane2.setText("      Welcome to chat box."+"\n       Please wait while it loads all images.\n"+"\t Enjoy the chat!!!");
                        String temp1[] = temp.substring(temp.indexOf(" ") + 1).split(";");



                        for (int k = 0; k < temp1.length; k++) {

                            System.out.println(temp1[k]);

                            nmlk[k] = new JButton(temp1[k]);
                            nmlk[k].setText(temp1[k]);
                            nmlk[k].setContentAreaFilled(false);

                            l.jPanel2.add(nmlk[k]);
                            nm[k] = temp1[k];
                            nmlk[k].setBorderPainted(false);
                            nmlk[k].addActionListener(this);
                            messagecnter++;

                        }

                        l.jPanel2.updateUI();
                    }
                    if (temp.startsWith("LIST")) {

                        // l.jPanel2.setLayout(new Fl);
                        //l.jTextPane2.setText("      Welcome to chat box."+"\n       Please wait while it loads all images.\n"+"\t Enjoy the chat!!!");
                        String temp1[] = temp.substring(temp.indexOf(" ") + 1).split(";");

                        JLabel ll = new JLabel("<HTML><B><FONT COLOR=RED><I>Welocme " + name + " !!" + "\n \t  Enjoy the chat</B></I></HTML>");
                        l.jEditorPane1.setText(ll.getText());
                        //l.jPanel1.add(ll);


                        for (int k = 0; k < temp1.length; k++) {

                            System.out.println(temp1[k]);

                            nmlk[k] = new JButton();
                            nmlk[k].setText(temp1[k].trim());
                            // nmlk[k].setContentAreaFilled(false);
                            l.jPanel2.add(nmlk[k]);
                            nm[k] = temp1[k].trim();
                            nmlk[k].setBorderPainted(false);
                            nmlk[k].addActionListener(this);
                            messagecnter++;

                        }
                        //l.jPanel1.updateUI();
                    }
                    if (temp.startsWith("ADD")) {
                        //l.jPanel2.setLayout(new GridLayout(20, 1, 2, 1));

                        nmlk[messagecnter] = new JButton(temp.substring(temp.indexOf(" ") + 1).trim());
                        //nmlk[messagecnter].setContentAreaFilled(false);
                        l.jPanel2.add(nmlk[messagecnter]);
                        nm[messagecnter] = temp.substring(temp.indexOf(" ") + 1);
                        nmlk[messagecnter].setBorderPainted(false);
                        nmlk[messagecnter].addActionListener(this);
                        String nameset = "<B><FONT COLOR=BLUE><I>" + nmlk[messagecnter].getText() + " has been added to your contact list!!" + "\n \t  </B></I>" + "<BR>" + l.jEditorPane1.getText();
                        l.jEditorPane1.setText(nameset);
                        messagecnter++;


                    }
                    if (temp.startsWith("GROUP")) {
                    }

                    if (temp.startsWith("PRIV")) {
                        System.out.println(temp);
                        String arg = "", sdd = "";
                        check = false;
                        if (windowchk == false) {
                            prii = new priv(skt, temp.substring(temp.indexOf(" ") + 1, temp.indexOf(":")), name);
                        }
                        if (prii.prirecord == true) {
                            for (int i = 0; i < prii.tp.getTabCount(); i++) {
                                if (temp.substring(temp.indexOf(" ") + 1, temp.indexOf(":")).trim().equals(prii.tp.getTitleAt(i).trim())) {
                                    String tempp[] = temp.substring(temp.indexOf(":") + 1).split(" ");
                                    for (int k = 0; k < tempp.length; k++) {
                                        if (tempp[k].startsWith(":-")) {
                                            sdd = "<img src=\"" + this.getClass().getClassLoader().getResource("images/" + tempp[i].substring(tempp[i].indexOf("-") + 1) + ".png").toString() + "\" />";
                                            arg = arg + " " + sdd;
                                        } else {
                                            arg = arg + " " + tempp[k];
                                        }
                                    }


                                    String toset = arg + prii.jEditorPane1[i].getText();
                                    prii.jEditorPane1[i].setText(toset);

                                    check = true;
//                                      
                                }

                            }
                            if (check == false) {

                                prii.tp.insertTab(temp.substring(temp.indexOf(" ") + 1, temp.indexOf(":")), null, prii.l[prii.tp.getTabCount()], null, prii.tp.getTabCount());
                               
                                
                                String tempp[] = temp.substring(temp.indexOf(":") + 1).split(" ");
                                for (int k = 0; k < tempp.length; k++) {
                                    if (tempp[k].startsWith(":-")) {
                                        sdd = "<img src=\"" + this.getClass().getClassLoader().getResource("images/" + tempp[i].substring(tempp[i].indexOf("-") + 1) + ".png").toString() + "\" />";
                                        arg = arg + " " + sdd;
                                    } else {
                                        arg = arg + " " + tempp[k];
                                    }
                                }

                                System.out.println("PRIVATE " + arg);
                                String toset = arg + prii.jEditorPane1[prii.tp.getTabCount() - 1].getText();
                                prii.jEditorPane1[i].setText(toset);


                                check = true;
//                                      
                            }
//                          prii.tpane[prii.tp.getTabCount()].setText(prii.tpane[0].getText()+"\n"+temp.substring(temp.indexOf(" ")+1));

                        }

                        if (prii.prirecord == false) {
                            //prii = new priv(skt, temp.substring(temp.indexOf(" ") + 1, temp.indexOf(":")), name);
                            prii.setVisible(true);
                            prii.setTitle(name);
                            prii.setSize(400, 400);
                            prii.setResizable(false);
                            String tempp[] = temp.substring(temp.indexOf(":") + 1).split(" ");
                            for (int k = 0; k < tempp.length; k++) {

                                if (tempp[k].startsWith(":-")) {
                                    sdd = "<img src=\"" + this.getClass().getClassLoader().getResource("images/" + tempp[i].substring(tempp[i].indexOf("-") + 1) + ".png").toString() + "\" />";
                                    arg = arg + " " + sdd;
                                } else {
                                    arg = arg + " " + tempp[k];
                                }
                            }
                            String toset = arg + prii.jEditorPane1[0].getText();
                            prii.jEditorPane1[0].setText(toset);


                            check = true;
//                                      
                        }
                        prii.prirecord = true;
                        windowchk = true;
                    }
                }


            }
        } catch (Exception e) {
            System.out.println("in run " + e);
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (l.jTextField1.getText().equals("")) {
            } else {
                // allmsg+="MESS" + "< " + name + " >" + l.jTextField1.getText() + ";" + String.valueOf(img1) + "{" + String.valueOf(r) + " " + String.valueOf(g) + " " + String.valueOf(blu);
                ps.println("MESS" + "< " + name + " >" + l.jTextField1.getText() + ";" + String.valueOf(img1) + "{" + String.valueOf(r) + " " + String.valueOf(g) + " " + String.valueOf(blu));
                l.jTextField1.setText(null);
                //l.jEditorPane1.setText(allmsg);
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sds = e.getActionCommand();
        if (sds.equals("logout")) {
            ps.println("LOG " + name);

            try {
                skt.close();
            } catch (Exception e1) {
                System.out.println(e1);
            }
            l.setVisible(false);
            l.dispose();
        }
        if (sds.equals("smile")) {
            locx = 1600;
            locy = 150;
            sda.setVisible(true);

            while (locx > 800) {
                try {
                    sda.setLocation(locx, locy);

                    Thread.sleep(40);
                    locx = locx - 50;


                } catch (Exception e1) {
                }
            }
            System.out.println(locx + " " + locy);
        }
        System.out.println(sds);
        for (int i = 1; i < 101; i++) {
            if (sds.equals(":-" + String.valueOf(i))) {
                l.jTextField1.setText(l.jTextField1.getText() + " " + sds);

                while (locy < 800) {
                    try {
                        sda.setLocation(locx, locy);
                        Thread.sleep(70);
                        locy = locy + 50;

                    } catch (Exception e1) {
                    }
                }
                sda.setVisible(false);
                sda.dispose();
            }
        }
        for (int i = 0; i < nm.length; i++) {
            if (sds.trim().equals(nm[i])) {
                if (windowchk == false) {
                    prii = new priv(skt, nm[i], name);
                }
                if (prii.prirecord == false) {
                    System.out.println(nm[i]);


                    prii.setVisible(true);
                    prii.setTitle(name);
                    prii.setSize(400, 400);
                    prii.setResizable(false);
                    prii.prirecord = true;
                    windowchk = true;
                    break;
                }
                if (prii.prirecord == true) {
                    for (int k = 0; k < prii.tp.getTabCount(); k++) {
                        if (prii.tp.getTitleAt(k).trim().equals(nm[i])) {
                            prii.tp.setSelectedIndex(i);

                            break;
                        } else {
                            prii.tp.insertTab(nm[i], null, prii.l[prii.tp.getTabCount()], null, prii.tp.getTabCount());

                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ps.println("LOG " + name);
        l.setVisible(false);
        l.dispose();
        try {
            skt.close();
        } catch (Exception e2) {
            dispose();
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
