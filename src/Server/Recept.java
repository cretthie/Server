package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import BO.Message;
import BO.User;
import BO.UserThread;

public class Recept implements Runnable
{
	private UserThread userThread;
	private ObjectInputStream ois;
	private Vector<UserThread> listUser;
	public Recept(UserThread userThread, ObjectInputStream ois, Thread dialogThread, Vector<UserThread> listUser)
	{
		this.userThread = userThread;
		this.ois = ois;
		this.userThread.DialogThread(dialogThread);
		this.listUser = listUser;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			try 
			{
				Message message = (Message)ois.readObject();
				transmettre(message);
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
	public void transmettre(Message message)
	{
		Socket socket = null;
		ObjectOutputStream oos;
		for(int i = 0 ; i<listUser.size() ; i++)
		{
			if(listUser.get(i).User().IdUser() == message.To())
			{
				socket = listUser.get(i).Socket();
			}
		}
		try 
		{
			oos = new ObjectOutputStream(socket.getOutputStream());						oos.writeObject(message);
			oos.flush();
			oos.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
