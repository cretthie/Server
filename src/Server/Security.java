package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

import BO.Message;
import BO.User;
import BO.UserActivity;
import Database.UserDataHelper;

public class Security implements Runnable
{
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private User user;
	private Message msg;
	private UserActivity userActivity;
	private Vector<UserActivity> listActivity;
	
	public Security(UserActivity userActivity, Vector<UserActivity> listActivity)
	{
		this.userActivity = userActivity;
		this.listActivity = listActivity;
	}
	public void security()
	{
		try 
		{
			oos = new ObjectOutputStream(userActivity.UserSocket().getOutputStream());
			ois = new ObjectInputStream(userActivity.UserSocket().getInputStream());
			user = (User) ois.readObject();
			if(isvalid(user))
			{
				Date date = new Date();
				System.out.println(user.Login());
				userActivity.User(user);
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
		boolean connect = false;
		UserDataHelper userDH = new UserDataHelper();
		User testUser = userDH.loginExistOK(user);
		if(testUser.Id() > 0)
		{
			connect = true;
		}
		return connect;
	}
	@Override
	public void run() 
	{
		security();
	}
}
