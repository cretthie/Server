package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import BO.UserActivity;

public class Srv 
{
	private int port;
	private int maxCon;
	private ServerSocket srv;
	private Socket clientSocket;
	private Vector<UserActivity> listActivity;
	public static void main(String[] args)
	{
		Srv s = new Srv(41279,10);
	}
	public Srv(int port, int maxCon)
	{
		if(port<1025)
		{
			port = 41279;
		}
		this.port = port;
		this.maxCon = maxCon;
		listActivity = new Vector<UserActivity>();
		runNetwork();
	}
	public void runNetwork()
	{
		try 
		{
			srv = new ServerSocket(port, maxCon);
			while(true)
			{
				clientSocket = srv.accept();
				UserActivity userActivity = new UserActivity();
				userActivity.UserSocket(clientSocket);
				userActivity.SrvThread(new Thread(new Security(userActivity, listActivity)));
				userActivity.SrvThread().start();
				
				//System.out.println("Le Thread " + secuThread + " a été créé avec le " + clientSocket);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void closeNetwork()
	{
		
	}
}
