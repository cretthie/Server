package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;

import BO.Message;
import BO.User;
import BO.UserActivity;
import Database.UserDataHelper;

public class Security implements Runnable
{
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
			userActivity.Oos(new ObjectOutputStream(userActivity.UserSocket().getOutputStream()));
			userActivity.Ois(new ObjectInputStream(userActivity.UserSocket().getInputStream()));
			user = (User) userActivity.Ois().readObject();
			if(isvalid(user))
			{
				System.out.println(user.Login());
				userActivity.User(user);
				msg = new Message(0, user.Id(), "true", "connexion", 1, new Date());
				userActivity.Oos().writeObject(msg);
				userActivity.Oos().flush();
				userActivity.SecuThread(new Thread(new Dialog(userActivity, listActivity)));
				userActivity.SecuThread().start();
				//userActivity.SrvThread().interrupt();
				//System.out.println(userActivity.SrvThread().isInterrupted());
			}
			else
			{
				msg = new Message(0, 0, "false", "connexion", 1, new Date());
				userActivity.Oos().writeObject(msg);
				userActivity.Oos().flush();
				//userActivity.SrvThread().interrupt();
				//userActivity.UserSocket().close();
				//System.out.println(userActivity.SrvThread().getId());
			}
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
