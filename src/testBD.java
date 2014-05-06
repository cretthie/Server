import BO.User;
import Database.UserDataHelper;


public class testBD 
{
	public static void main(String[] args)
	{
		User user = new User(0,"lukas", "germann");
		UserDataHelper userDH = new UserDataHelper();
		User testUser = userDH.loginExistOK(user);
		System.out.println(testUser.Login());
	}
}
