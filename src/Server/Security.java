package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

import BO.Message;
import BO.User;
import Database.UserDataHelper;

public class Security implements Runnable
{
	private Thread srvThread;
	private Socket clientSocket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private User user;
	private Message msg;
	
	public Security(Socket clientSocket, Thread srvThread)
	{
		this.clientSocket = clientSocket;
		this.srvThread = srvThread;
		System.out.println("Instance de Sécurity");
		security();
	}
	public void security()
	{
		System.out.println("Instance de Sécurity -> security()");
		try 
		{
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			ois = new ObjectInputStream(clientSocket.getInputStream());
			user = (User) ois.readObject();
			System.out.println(user.Login());
				if(isvalid(user))
				{
					Date date = new Date();
					System.out.println(user.Login());
					msg = new Message(0, user.Id(), "true", "connexion", 1, date);
					oos.writeObject(msg);
					oos.flush();
				}
				else
				{
					Date date = new Date();
					msg = new Message(0, 0, "false", "connexion", 1, date);							oos.writeObject(msg);
					oos.writeObject(msg);
					oos.flush();
				}
			ois.close();
			oos.close();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	public boolean isvalid(User user)
	{
		System.out.println("isvalid()");
		boolean connect = false;
		UserDataHelper userDH = new UserDataHelper();
		User testUser = userDH.loginExistOK(user);
		System.out.println(testUser.Login());
		if(testUser.Id() > 0)
		{
			connect = true;
		}
		System.out.println(connect);
		return connect;
	}
	@Override
	public void run() 
	{
	}
}
