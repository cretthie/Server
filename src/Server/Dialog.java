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
		System.out.println("ok");
	}
	@Override
	public void run() 
	{
		Message message = new Message();
		
		try 
		{
			message = (Message) userActivity.Ois().readObject();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		/*
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		*/
		System.out.println(message.Msg());
	}
}
