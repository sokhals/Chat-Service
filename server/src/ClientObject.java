/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*****************Chat Server Client Object*******************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/

import java.net.Socket;
public class ClientObject
{
	ClientObject(Socket socket,String UserName)
	{
		ClientSocket = socket;
		ClientUserName = UserName;
		
	}
			
	public void setSocket(Socket socket)
	{
		ClientSocket =  socket;
	}
	
	public void setUserName(String UserName)
	{
		ClientUserName = UserName;
	}
	
	
	
	public Socket getSocket()
	{
		return ClientSocket;
	}
	
	public String getUserName()
	{
		return ClientUserName;
	}
	
	
Socket ClientSocket;
String ClientUserName;
}