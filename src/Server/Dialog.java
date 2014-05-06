package Server;

import java.util.Vector;

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
		
	}
}
