package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import BO.Message;
import BO.User;
import Database.UserDataHelper;

public class Srv 
{
	private int port;
	private int maxCon;
	private ServerSocket srv;
	private Socket client;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private User user;
	private Message msg;
	
	public Srv(int port, int maxCon)
	{
		if(port<0)
		{
			port = 41279;
		}
		this.port = port;
		this.maxCon = maxCon;
	}
	public void runNetwork()
	{
		try 
		{
			srv = new ServerSocket(port, maxCon);
			while(true)
			{
				client = srv.accept();
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				try 
				{
					user = (User) ois.readObject();
					boolean connect = false;
					while(!connect)
					{
						Date date = new Date();
						if(isvalid(user))
						{
							msg = new Message(0, user.Id(), "true", "connexion", 1, date);
							oos.writeObject(msg);
							oos.flush();
							connect=true;
						}
						else
						{
							msg = new Message(0, 0, "false", "connexion", 1, date);							oos.writeObject(msg);
							oos.writeObject(msg);
							oos.flush();
						}
					}
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
	public boolean isvalid(User user)
	{
		boolean connect = false;
		UserDataHelper userDH = new UserDataHelper();
		User testUser = userDH.loginExistOK(user);
		if(testUser.Id() > 0)
		{
			connect = true;
		}
		return connect;
	}
}
