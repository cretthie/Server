/**
 * Description : This class creat table, and default value of the database
 * @author Thierry Crettol
 * */

package Database;

public class Create extends Database
{
	public static void main(String[] args)
	{
		Create c = new Create();
	}
	public Create() 
	{
		super("chatProjectDB") ;
		
    	String createUser = "CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT NOT NULL UNIQUE, password TEXT NOT NULL);" ;
		if(connexion() == true)
		{
			updateValue(createUser) ;
		}
		disconnexion() ;
	}
	/**
	 * insert init value of the database
	 */
	/*
	
	public void insertValue()
	{
		OwnerDataHelper ownerDH = new OwnerDataHelper() ;
		Owner owner = new Owner() ;
		owner.setIdPersonne(2) ;
		owner.setMail("yourName@domain.com") ;
		owner.setName("Your name") ;
		owner.setOwnerSmtpServer("smtp.domain.com") ;
		owner.setPhone("+41 21 621 21 21") ;
		owner.setMan() ;
		owner.setOwnerMailpassword("Your password") ;
		ownerDH.insertOwner(owner) ;
		AlbumDataHelper albumDH = new AlbumDataHelper() ;
		Album album = new Album(1, "Default album") ;
		albumDH.insertAlbum(album) ;	
	}
	*/
}
