package Database;

import java.sql.SQLException;
import java.util.Vector;

import BO.User;
import Database.Database;

public class UserDataHelper extends Database
{
	public UserDataHelper() 
	{
		super("chatProjectDB") ;
	}
	public void insert(User leUser)
	{
		connexion() ;
		String req = "INSERT INTO user(idUser, firstname, lastname, login, password, valide)" +
					 "VALUES (null, '" + leUser.Firstname() + "', '" + leUser.Lastname() + "', '" + leUser.Login() + "', '" + leUser.Password() + "'," + leUser.Valide() + ");" ;
		updateValue(req) ;
		disconnexion() ;
	}
	

	public User loginExistOK(User leUser)
	{
		User user = null;
		try 
		{
			connexion() ;
			String req = "SELECT * FROM user WHERE login = '" + leUser.Login() + "' AND password ='"+ leUser.Password()+"';" ;
			getResultOf(req) ;
			if(getResult().next())
			{
				user = new User(getResult().getInt("idUser"),
								getResult().getString("firstname"),
								getResult().getString("lastname"),
								getResult().getString("login"), 
								"",
								0);
			}
			disconnexion() ;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace() ;
		}
		return user ;
	}
	
	

	public User select_userByLogin(String login)
	{
		User leUser = null;
		try 
		{
			connexion() ;
			String req = "SELECT * FROM user WHERE login = " + login + ";" ;
			getResultOf(req) ;
			if(getResult().next())
			{
				leUser = new User(getResult().getInt("idUser"),
									getResult().getString("firstname"),
									getResult().getString("lastname"),
									getResult().getString("login"),
									"",
									getResult().getInt("valide"));
			}
			disconnexion() ;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace() ;
		}
		return leUser ;
	}
	
	
	
	
	public int loginExist(User leUser)
	{
		int exist = 0;
		try 
		{
			connexion() ;
			String req = "SELECT * FROM user WHERE login = '" + leUser.Login() + "';" ;
			getResultOf(req) ;
			if(getResult().next())
			{
				exist = getResult().getInt("idUser") ;
			}
			disconnexion() ;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace() ;
		}
		return exist ;
	}
	public User select_by_login(User leUser)
	{
		User leSearchUser = new User();
		try 
		{
			connexion() ;
			String req = "SELECT * FROM user WHERE firstname = '" + leUser.Firstname() + "';" ;
			getResultOf(req) ;
			if(getResult().next())
			{
				leSearchUser = new User(getResult().getInt("idUser"),
									  getResult().getString("firstname"), 
									  getResult().getString("lastname"), 
									  getResult().getString("login"), 
									  getResult().getString("password"),
									  getResult().getInt("valide")) ;
			}
			disconnexion() ;
			return leSearchUser ;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace() ;
		}
		return null ;
	}
	public Vector<User> selectAllUser()
	{
		Vector<User> userList = new Vector<User>();
		User user ;
		try 
		{
			connexion() ; 
			getResultOf("SELECT * FROM user ;") ;
			while(getResult().next())
			{
				user = new User(getResult().getInt("idUser"),
									  getResult().getString("firstname"), 
									  getResult().getString("lastname"), 
									  getResult().getString("login"), 
									  getResult().getString("password"), 
									  getResult().getInt("valide")) ;
				userList.add(user) ;				
			}
			disconnexion() ;
			return userList ;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace() ;
		}
		return null ;
	}
	
	public void deleteUser(User leUser)
	{
		connexion() ;
		String req = "DELETE FROM user WHERE idUser=" + leUser.IdUser() + ";" ;
		updateValue(req) ;
		disconnexion() ;
	}
}