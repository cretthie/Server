package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import BO.Message;
import BO.User;

public class Server 
{
	private int port;
	private int maxCon;
	private ServerSocket srv;
	private Socket client;
	private Thread conThread;
	private boolean secure;
	private ObjectOutputStream oos;
	private User user;
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException
	{
		Server s = new Server(41279,10);
	}
	public Server(int port, int maxCon) throws ClassNotFoundException, InterruptedException
	{
		this.port = port;
		this.port = 41279;
		this.maxCon = maxCon;
		try 
		{
			srv = new ServerSocket(port, maxCon);
			client = srv.accept();
			System.out.println("Helo / " + client);
			
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

			System.out.println("OK");
			user = (User) ois.readObject();
			
			System.out.println("OK2");
			System.out.println(user.Login());
			oos.flush();
			oos.close();
			ois.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
