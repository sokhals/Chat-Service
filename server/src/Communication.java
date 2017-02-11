import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class Communication implements Runnable{
	Server sr;
	Socket skt;
	BufferedReader bf;
	PrintStream ps;
	Thread t;
	int i=0;
	Communication(Server srvr, Socket s){
		sr=srvr;
		skt=s;
		try{
		bf=new BufferedReader(new InputStreamReader(skt.getInputStream()));
		
		t=new Thread(this);
		t.start();
		
		

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		try{
			
		
		while(t!=null)
		{
			String sk;
			while((sk=bf.readLine())!=null)
			{
				if(sk.startsWith("MESS"))
				{
                                    //System.out.println(sk);
					sr.sendmessage(skt,sk.substring(sk.indexOf(">")),sk.substring(sk.indexOf("<"),sk.indexOf(">")));
					
				}
				if(sk.startsWith("NM"))
				{
					System.out.println(sk.substring(2));
					sr.adduser(skt,sk.substring(2));
					
				}
                                if(sk.startsWith("PRIV"))
				{
					System.out.println(sk);
                                        System.out.println(sk.substring(5,sk.indexOf("~")).trim());
					sr.senprivatemessage(sk.substring(sk.indexOf("~")+1),sk.substring(5,sk.indexOf("~")).trim());	
					
				}
                                if(sk.startsWith("LOG"))
                                {
                                   sr.logout(sk.substring(sk.indexOf(" ")+1).trim());
                                   System.out.println(sk);
                                }

			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
