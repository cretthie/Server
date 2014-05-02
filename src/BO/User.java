package BO;

import java.io.Serializable;


public class User implements Comparable<User>, Serializable
{
	private int idUser;
	private String lastname;
	private String firstname;
	private String login;
	private String password;
	// valide = 1 / non valide = 0
	private int valide;
	
	public User()
	{}
	public User(int idUser, String firstname, String lastname, String login, String password, int valide)
	{
		this.idUser = idUser;
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.valide = valide;
	}
	public int Valide()
	{
		return this.valide;
	}
	public void Valide(int value)
	{
		this.valide = value;
	}
	public String Password()
	{
		return this.password;
	}
	public void Password(String value)
	{
		this.password = value;
	}
	public String Login()
	{
		return this.login;
	}
	public void Login(String value)
	{
		this.login = value;
	}
	public String Firstname()
	{
		return this.firstname;
	}
	public void Firstname(String value)
	{
		this.firstname = value;
	}
	public String Lastname()
	{
		return this.lastname;
	}
	public void Lastname(String value)
	{
		this.lastname = value;
	}
	public int IdUser()
	{
		return this.idUser;
	}
	public void IdUser(int value)
	{
		this.idUser = value;
	}
	@Override
	public int compareTo(User p) 
	{
		int result = 0;
		if(this.lastname.compareTo(p.lastname)==0)
		{
			result = this.firstname.compareTo(p.firstname);
		}
		else
		{
			result = this.lastname.compareTo(p.lastname);
		}
		return result;
	}
}
