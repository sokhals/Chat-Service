import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Server extends JFrame implements Runnable{
	private static final Socket Socket = null;
	ServerSocket sk;
	Socket s;
	BufferedReader bf;
	PrintStream ps;
	Thread t;
	ClientObject co;
	ArrayList userlist;
	int i=0,g_loop;
	JButton b1,b2;
	
public void run()
{
	try
	{
	String ss[]=new String[100];
	while(t!=null)
	{
		s=sk.accept();
                //adduser(s,"hello");
		System.out.println(s);
		ps=new PrintStream(s.getOutputStream());
		Communication cm=new Communication(this, s);
	}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	t.stop();
}

public void adduser(Socket sock,String username)
{
	int m_userListSize = userlist.size();
        System.out.println(m_userListSize);
	if(m_userListSize<11)
	{
	String m_addRFC = "ADD  "+username;
	StringBuffer stringbuffer = new StringBuffer("LIST ");
	for(g_loop = 0; g_loop < m_userListSize; g_loop++)
	{
		co = (ClientObject) userlist.get(g_loop);			
		sendtoclient(co.getSocket(),m_addRFC);
		stringbuffer.append(co.getUserName());													
		stringbuffer.append(";");
		
	}
	
	/*****Add a user in to array list***/
	co = new ClientObject(sock,username);
	userlist.add(co);
	
		
	
	
	/********Sending the Complte User List to the New User***********/
	
	stringbuffer.append(username);
	stringbuffer.append(";");
	
	sendtoclient(sock,stringbuffer.toString());
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Error Message");
	}
	}
public void logout(String username)
{
    
	{
		ClientObject removeclientobject = GetClientObject(username);
		if(removeclientobject != null)
		{
			userlist.remove(removeclientobject);	
			userlist.trimToSize();
			int m_userListSize = userlist.size();
			String m_RemoveRFC=username;
			sendupdateddata();		
		}			
	}
    
}
public void sendupdateddata()
{
    int m_userListSize = userlist.size();
        
	
	StringBuffer stringbuffer = new StringBuffer("NLIST ");
	for(g_loop = 0; g_loop < m_userListSize; g_loop++)
	{
		co = (ClientObject) userlist.get(g_loop);			
		
		stringbuffer.append(co.getUserName());													
		stringbuffer.append(";");
		
	}
	
	/*****Add a user in to array list***/
	
	
	
	for(g_loop = 0; g_loop < m_userListSize; g_loop++)
	{
		co= (ClientObject)userlist.get(g_loop);
						
			sendtoclient(co.getSocket(),stringbuffer.toString());	
		}	
	
		
	
	
	
	
	
	
	
	}

public void sendmessage(Socket sk,String msg,String username)
{
	int m_userListSize = userlist.size();
	String m_messageRFC = "MESS "+username+msg;
	for(g_loop = 0; g_loop < m_userListSize; g_loop++)
	{
		co= (ClientObject)userlist.get(g_loop);
		if((!(co.getUserName().equals(username))))
		{				
			sendtoclient(co.getSocket(),m_messageRFC);	
		}	
	}
}
public void senprivatemessage(String message, String toname)
{
    co = GetClientObject(toname);
		if(co != null)
		{
			sendtoclient(co.getSocket(),"PRIV "+message);	
		}
			
}
private ClientObject GetClientObject(String UserName)
	{
		ClientObject returnClientObject = null;
		ClientObject TempClientObject;
		int m_userListSize = userlist.size();
		for(int G_ILoop = 0; G_ILoop < m_userListSize; G_ILoop++)
		{
			TempClientObject = (ClientObject) userlist.get(G_ILoop);
			if(TempClientObject.getUserName().equalsIgnoreCase(UserName))
			{
				returnClientObject = TempClientObject;
				break;
			}
		}
		return returnClientObject;
	}
	
public void sendtoclient(Socket socket,String message)
{
	try
	{
	ps=new PrintStream(socket.getOutputStream());
	ps.println(new String(message));
	}
	catch(Exception e)
	{
		System.out.println("In sendtoclient "+e);
	}
}
	public static void main(String arg[]) throws Exception
	{
		Server s = new Server();
		s.sk=new ServerSocket(4002);
		s.t=new Thread(s);
		s.t.start();
	}

   
}
