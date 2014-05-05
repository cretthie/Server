package BO;

import java.io.Serializable;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String login;
	private String password;
	public User(int id, String login, String password)
	{
		Id(id);
		Login(login);
		Password(password);
	}
	public User()
	{}
	public int Id()
	{
		return this.id;
	}
	public String Login()
	{
		return this.login;
	}
	public String Password()
	{
		return this.password;
	}
	public void Id(int value)
	{
		this.id = value;
	}
	public void Login(String value)
	{
		this.login = value;
	}
	public void Password(String value)
	{
		this.password = value;
	}
}
