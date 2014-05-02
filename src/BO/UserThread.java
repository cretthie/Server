package BO;

import java.io.IOException;
import java.net.Socket;

public class UserThread 
{
	private User user;
	private Thread conThread;
	private Thread securityThread;
	private Thread dialogThread;
	private Socket socket;
	public UserThread(User user, Socket socket)
	{
		this.user = user;
		this.socket = socket;
	}
	public void DialogThread(Thread value)
	{
		this.dialogThread = value;
	}
	public void ConThread(Thread value)
	{
		this.conThread = value;
	}
	public void SecurityThread(Thread value)
	{
		this.securityThread = value;
	}
	public User User()
	{
		return this.user;
	}
	public void User(User user)
	{
		this.user = user;
	}
	public void Socket(Socket value)
	{
		this.socket = value;
	}
	public Socket Socket()
	{
		return this.socket;
	}
	public void close()
	{
		try 
		{
			this.socket.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
