package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import BO.Message;
import BO.User;
import Database.UserDataHelper;

public class Srv 
{
	private int port;
	private int maxCon;
	private ServerSocket srv;
	private Socket clientSocket;
	private Thread srvThread;
	
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
				System.out.println("Création d'un thread server");
				srvThread = new Thread(new Security(clientSocket, srvThread));
				System.out.println("Le Thread " + srvThread + " a été créé avec le " + clientSocket);
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
