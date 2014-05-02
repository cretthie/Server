package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	private int port;
	private int maxCon;
	private ServerSocket srv;
	private Socket client;
	private Thread conThread;
	public Server(int port, int maxCon)
	{
		this.port = port;
		this.maxCon = maxCon;
		try 
		{
			srv = new ServerSocket(port, maxCon);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void runNetwork()
	{
		while(true)
		{
			try 
			{
				client = srv.accept();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
