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
	private UserActivity userToSend;
	
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
				Message ReceivedMsg = (Message)userActivity.Ois().readObject();
				for(int i = 0 ; i<listActivity.size() ; i++)
				{
					if(listActivity.get(i).User().Id() == ReceivedMsg.To())
					{
						userToSend = listActivity.get(i);
					}
				}
				userToSend.Oos().writeObject(ReceivedMsg);
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
