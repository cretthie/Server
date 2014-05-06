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
	private Thread secuThread;
	private Vector<UserActivity> listActivity;
	public static void main(String[] args)
	{
		Srv s = new Srv(41279,10);
	}
	public Srv(int port, int maxCon)
	{
		if(port<0)
		{
			port = 41279;
		}
		this.port = port;
		this.maxCon = maxCon;
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
				userActivity.SecuThread(new Thread(new Security(userActivity)));
				userActivity.SecuThread().start();
				//System.out.println("Le Thread " + secuThread + " a �t� cr�� avec le " + clientSocket);
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
