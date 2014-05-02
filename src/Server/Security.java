package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import BO.Message;
import BO.User;
import BO.UserThread;
import Database.UserDataHelper;

public class Security implements Runnable
{
	private Socket clientSocket;
	private boolean secure = false;
	private UserDataHelper userDH = new UserDataHelper();
	private User user;
	private Vector<UserThread> userThreadList;
	private Thread securityThread;
	private Thread conThread;
	private UserThread userThread;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Vector<UserThread> listUser;
	public Security(Socket clientSocket, Thread conThread, Vector<UserThread> listUser)
	{
		this.clientSocket = clientSocket;
		this.conThread = conThread;
		this.listUser = listUser;
	}
	@Override
	public void run() 
	{
			while(!secure)
			{
				try 
				{
					ois = new ObjectInputStream(clientSocket.getInputStream());
					oos = new ObjectOutputStream(clientSocket.getOutputStream());
					user = (User)ois.readObject();
					if(isValid(user))
					{
						secure = true;
						Message message = new Message(0, user.IdUser(), "true", "connexion");
						userThread = new UserThread(user, clientSocket);
						userThread.ConThread(conThread);
						//Send message connexion ok
						oos.writeObject(message);
						oos.flush();
						oos.close();
						ois.close();
					}
					else
					{
						Message message = new Message(0, 0, "false", "connexion");
						//Send message connexion not ok
						oos.writeObject(message);
						oos.flush();
						oos.close();
					}
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			securityThread = new Thread(new Dialog(userThread, securityThread, listUser));
		}
	public boolean isValid(User leUser)
	{
		boolean ok = false;
		user = userDH.loginExistOK(leUser);
		if(user.IdUser()>1)
		{
			ok = true;
		}
		return ok;
	}
	
}
