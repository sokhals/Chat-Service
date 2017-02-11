
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.*;
import javax.swing.plaf.FileChooserUI;


public class priv extends JFrame implements KeyListener,ActionListener,WindowListener
{
	JTabbedPane tp=new JTabbedPane(SwingConstants.BOTTOM);

	String toname,byname,total="";
	smilly  sda=new smilly();;
	JButton smily[]=new JButton[10];
	int counter[]=new int[10];
	JButton file[]=new JButton[10]; 
	JTextField tf[]=new JTextField[10];
	int locx=1600,locy=150;
	JTextPane tpane[]=new JTextPane[10];
	JScrollPane jsp[]=new JScrollPane[10];
	PrintStream ps;
	DataOutputStream dos;
	String imgg;
	Boolean prirecord=false;
	JLabel msg[]=new JLabel[5000];
	JPanel l[]=new JPanel[10],ll[]=new JPanel[10];
	JEditorPane jEditorPane1[]=new JEditorPane[10];
	priv(Socket sk,String arg,String g)
	{
		toname=arg;
		byname=g;


		setLocation(350,150);
		try
		{
			ps=new PrintStream(sk.getOutputStream());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		for(int i=0;i<10;i++)
		{
			counter[i]=0;
			l[i]=new JPanel();

			jEditorPane1[i]=new JEditorPane();
			jEditorPane1[i].setContentType("text/html");
			l[i].setLayout(new BorderLayout(10,10));

			//ll[i].setLayout(new GridLayout(50000, 1, 10, 10));
			tf[i]=new JTextField();
			//ll[i].setBackground(Color.WHITE);
			smily[i]=new JButton("smile");
			tpane[i]=new JTextPane();
			file[i]=new JButton("File");
			tpane[i].setEditable(false);
			jsp[i]=new JScrollPane();

			//smily[i].setIcon(new ImageIcon("D:\\images\\78.png"));

			jsp[i].setViewportView(jEditorPane1[i]);
			l[i].add(jsp[i],BorderLayout.CENTER);
			l[i].add(tf[i],BorderLayout.SOUTH);
			l[i].add(smily[i],BorderLayout.AFTER_LINE_ENDS);
			l[i].add(file[i],BorderLayout.LINE_END);


			smily[i].addActionListener(this);
			file[i].addActionListener(this);
			tf[i].addKeyListener(this);

			repaint();
		}
		tp.insertTab(toname,null,l[0], null,tp.getTabCount());
		Color c=new Color(112,234,212);
		tp.setForegroundAt(tp.getTabCount(), c);

		add(tp);
		smilylistener();

	}
	public void smilylistener()
	{
		for(int i=0;i<9;i++)
		{
			sda.heart[i].addActionListener(this);

		}
		for(int i=0;i<15;i++)
		{
			sda.faces[i].addActionListener(this);

		}
		for(int i=0;i<9;i++)
		{
			sda.ptato[i].addActionListener(this);

		}
		for(int i=0;i<41;i++)
		{
			sda.smily[i].addActionListener(this);

		}
		for(int i=0;i<6;i++)
		{
			sda.joker[i].addActionListener(this);

		}
		for(int i=0;i<20;i++)
		{
			sda.item[i].addActionListener(this);

		}
	}



	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e)
	{

		if(e.getKeyCode()==KeyEvent.VK_ENTER)

		{
			String arg="";
			int k=tp.getSelectedIndex();
			String temp=tf[k].getText();

			String readd = "", sdd = "";
			String tempp[]=temp.split(" ");
			for(int i=0;i<tempp.length;i++)
			{

				if(tempp[i].startsWith(":-"))
				{
					sdd = "<img src=\"" + this.getClass().getClassLoader().getResource("images/"+tempp[i].substring(tempp[i].indexOf("-")+1)+".png").toString()+"\" />";

					readd = readd + " " + sdd;
					System.out.println(sdd);

				} else {
					readd = readd + " " + tempp[i];

				}

			}





			//readd=readd+"<img src=\"" + this.getClass().getClassLoader().getResource("seticon/"+imgg.substring(imgg.indexOf("n")+2,imgg.indexOf("{"))).toString()+"\" /> ";

			//System.out.println(readd);


			if(sdd.equals(""))
			{
				String tobeset = readd + jEditorPane1[k].getText();
				jEditorPane1[k].setText(tobeset);
			}
			else
			{
				String tobeset = readd +jEditorPane1[k].getText()+">";
				jEditorPane1[k].setText(tobeset);
			}

			// System.out.println(tobeset);


			jEditorPane1[k].repaint();




			ps.println("PRIV "+tp.getTitleAt(k)+"~"+byname+": "+tf[k].getText());
			tf[k].setText(null);
			repaint();

		}


	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String s=e.getActionCommand();
		if(s.equals("smile"))
		{
			locx=1600;locy=150;

			sda.setVisible(true);
			while(locx>800)
			{
				try
				{
					sda.setLocation(locx, locy);

					Thread.sleep(40);
					locx=locx-50;

					repaint();                      
				}

				catch(Exception e1)
				{

				}
			}
		}
		for(int i=0;i<100;i++)
		{
			if(s.equals(":-"+String.valueOf(i)))
			{
				tf[tp.getSelectedIndex()].setText(tf[tp.getSelectedIndex()].getText()+" "+s);
				repaint();
				while(locy<800)
				{
					try
					{
						sda.setLocation(locx, locy);
						Thread.sleep(70);
						locy=locy+50;
						repaint();
					}
					catch(Exception e1)
					{

					}
				}
				sda.setVisible(false);
				sda.dispose();
				break;
			}
		}
		if(s.equals("File"))
		{
			JFileChooser f=new JFileChooser();

		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		prirecord=false;
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
