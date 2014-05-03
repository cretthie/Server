package BO;

import java.io.Serializable;

public class Message implements Serializable
{
	//source : http://www.coderanch.com/t/205325/sockets/java/send-java-Object-socket
	private int from;
	private int to;
	private String msg;
	private String type;
	/*
	 * Type :
	 * connexion -> from (0 = server) to (idClient) -> msg = true or false
	*/
	public Message(int from, int to, String message, String type)
	{
		this.from = from;
		this.to = to;
		this.msg = message;
		this.type = type;
	}
	public Message()
	{
	}
	
	public String Type()
	{
		return this.type;
	}
	public void Type(String value)
	{
		this.type = value;
	}
	public String Msg()
	{
		return this.msg;
	}
	public void Msg(String value)
	{
		this.msg = value;
	}
	public int To()
	{
		return this.to;
	}
	public void To(int value)
	{
		this.to = value;
	}
	public int From()
	{
		return this.from;
	}
	public void From(int value)
	{
		this.from = value;
	}
}
/*
	public void send(Socket socket, Message message)
	{		
		try 
		{
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(this);
			oos.flush();
			oos.close();
			os.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public Message recept(Socket socket)
	{
		Message message = null;
		try 
		{
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			message = (Message)ois.readObject();
			is.close();
			ois.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return message;
	}*/