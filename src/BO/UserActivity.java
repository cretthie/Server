package BO;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UserActivity 
{
	private User user;
	private Thread srvThread;
	private Socket userSocket;
	private Thread secuThread;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	public UserActivity()
	{
		
	}
	public void Ois(ObjectInputStream ois)
	{
		this.ois = ois;
	}
	public ObjectInputStream Ois()
	{
		return this.ois;
	}
	public void Oos(ObjectOutputStream oos)
	{
		this.oos = oos;
	}
	public ObjectOutputStream Oos()
	{
		return this.oos;
	}
	public Thread SecuThread()
	{
		return this.secuThread;
	}
	public void SecuThread(Thread value)
	{
		this.secuThread = value;
	}
	public Socket UserSocket()
	{
		return this.userSocket;
	}
	public void UserSocket(Socket value)
	{
		this.userSocket = value;
	}
	public void SrvThread(Thread value)
	{
		this.srvThread = value;
	}
	public Thread SrvThread()
	{
		return this.srvThread;
	}
	public User User()
	{
		return this.user;
	}
	public void User(User value)
	{
		this.user = value;
	}
}
