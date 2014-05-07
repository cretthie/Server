package BO;

import java.net.Socket;

public class UserActivity 
{
	private User user;
	private Thread srvThread;
	private Socket userSocket;
	private Thread secuThread;
	public UserActivity()
	{
		
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
