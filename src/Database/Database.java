/**
 * Description : This class help to manage connexion and disconnexion of the database
 * @author Thierry Crettol
 * */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
	private String dbName ;
    private Connection connexion ;
    private Statement requete ;
    private ResultSet result ;
    
	public Database(String dbName)
	{
		this.dbName = dbName ;
		this.connexion = null ;
		try
		{
			Class.forName("org.sqlite.JDBC") ;
		}
		catch (ClassNotFoundException e1)
		{
			System.err.println(e1.getMessage()) ;
		}
	}
	/**
	 * Connection to the database 
	 * @return true Return true if the database connection is open, false if ths connection is not valid
	 */
	public boolean connexion()
	{
		try
		{
			this.connexion = DriverManager.getConnection("jdbc:sqlite:" + this.dbName) ;
			this.requete = this.connexion.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY) ;
			this.requete.executeUpdate("PRAGMA synchronous = OFF;") ;
			this.requete.setQueryTimeout(30) ;
			return true ;
		}
		catch(SQLException e)
		{
			e.printStackTrace() ;
			return false ;
		}
	}
	/**
	 * Disconnection of the database 
	 * @return true Return true if the database connection is close, false if there is an error
	 */
	public boolean disconnexion()
	{
		try
		{
			if(this.connexion != null)
			{
				this.connexion.close() ;
			}
			return true ;
		}
		catch(SQLException e)
		{
			e.printStackTrace() ;
			return false ;
		}
	}
	/**
	 * Method to make select query
	 */
	public void getResultOf(String requete)
	{
		try
		{
			this.result = this.requete.executeQuery(requete) ;
		}
		catch (SQLException e)
		{
			e.printStackTrace() ;
		}
	}
	/**
	 * Method to make insert, update or delete queries
	 */
	public void updateValue(String requete)
	{
		try
		{
			this.requete.executeUpdate(requete) ;
		}
		catch (SQLException e)
		{
			e.printStackTrace() ;
		}
	}
	/**
	 * Get the result of the query
	 * @return Return a resultSet contains the query result
	 */
	public ResultSet getResult()
	{
		return this.result ;
	}
}
