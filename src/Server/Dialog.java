package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import BO.Message;
import BO.User;
import BO.UserActivity;

public class Dialog implements Runnable
{
	private UserActivity userActivity;
	private Vector<UserActivity> listActivity;
	
	public Dialog(UserActivity userActivity, Vector<UserActivity> listActivity)
	{
		this.userActivity = userActivity;
		this.listActivity = listActivity;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			try 
			{
				Message msg = (Message)userActivity.Ois().readObject();
				System.out.println(msg.Msg());
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
	}
}
