package BO;

import java.net.Socket;

public class UserActivity 
{
	private User user;
	private Thread secuThread;
	private Socket userSocket;
	private Thread dialThread;
	public UserActivity()
	{
		
	}
	public Thread DialThread()
	{
		return this.dialThread;
	}
	public void DialThread(Thread value)
	{
		this.dialThread = value;
	}
	public Socket UserSocket()
	{
		return this.userSocket;
	}
	public void UserSocket(Socket value)
	{
		this.userSocket = value;
	}
	public void SecuThread(Thread value)
	{
		this.secuThread = value;
	}
	public Thread SecuThread()
	{
		return this.secuThread;
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
