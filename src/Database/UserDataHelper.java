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
		String req = "INSERT INTO user(id, login, password)" +
					 "VALUES (null, '" + leUser.Login() + "', '" + leUser.Password() + "');" ;
		updateValue(req) ;
		disconnexion() ;
	}
	public User loginExistOK(User leUser)
	{
		User user = new User(0,"","");
		try 
		{
			connexion() ;
			String req = "SELECT * FROM user WHERE login = '" + leUser.Login() + "' AND password ='"+ leUser.Password()+"';" ;
			getResultOf(req) ;
			if(getResult().next())
			{
				user = new User (getResult().getInt("id"),
								 getResult().getString("login"),
								 "");
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
			String req = "SELECT * FROM user WHERE login = '" + login + "';" ;
			getResultOf(req) ;
			if(getResult().next())
			{
				leUser = new User(getResult().getInt("id"),
									getResult().getString("login"),
									"");
			}
			disconnexion() ;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace() ;
		}
		return leUser ;
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
				user = new User(getResult().getInt("id"),
									  getResult().getString("login"), 
									  getResult().getString("password")) ;
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
		String req = "DELETE FROM user WHERE id=" + leUser.Id() + ";" ;
		updateValue(req) ;
		disconnexion() ;
	}
}