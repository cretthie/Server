package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import BO.UserThread;
public class Dialog implements Runnable
{ 
	private Vector<UserThread> userThreadList;
	private UserThread userThread;
	private Thread dialogThread;
	private ObjectInputStream ois;
	private Vector<UserThread> listUser;
	public Dialog(UserThread userThread, Thread securityThread, Vector<UserThread> listUser)
	{
		this.userThread = userThread;
		this.userThread.SecurityThread(securityThread);
		this.listUser = listUser;
	}
	@Override
	public void run() 
	{
		try 
		{
			ois = new ObjectInputStream(userThread.Socket().getInputStream());
			dialogThread = new Thread(new Recept(userThread, ois, dialogThread, listUser));
			dialogThread.start();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
