package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import BO.Message;
import BO.User;

public class Server 
{
	private int port;
	private int maxCon;
	private ServerSocket srv;
	private Socket client;
	private Thread conThread;
	private boolean secure;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private User user;
	public Server(int port, int maxCon)
	{
		this.port = port;
		this.port = 41279;
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
			secure = false;
			try 
			{
				client = srv.accept();
				while(!secure)
				{
					try 
					{
						ois = new ObjectInputStream(client.getInputStream());
						oos = new ObjectOutputStream(client.getOutputStream());
						user = (User)ois.readObject();
						System.out.println(user.Login());
							oos.flush();
							oos.close();
							ois.close();

					} 
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					}
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
