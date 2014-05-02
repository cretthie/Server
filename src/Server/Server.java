package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import BO.User;
import BO.UserThread;

public class Server 
{
	private int port;
	private int maxCon;
	private ServerSocket srv = null;
	private Socket client = null;
	private Thread conThread;
	private Vector<UserThread> listUser = new Vector<UserThread>() ;
	
	public Server(int port, int maxCon)
	{
		this.port = port;
		this.maxCon = maxCon;
	}
	public void runNetwork()
	{
		try 
		{
			srv = new ServerSocket(port,maxCon);
			while(true)
			{
				client = srv.accept();
				conThread = new Thread(new Security(client, conThread, listUser));
				conThread.start();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
