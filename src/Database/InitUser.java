package Database;

import BO.User;

public class InitUser 
{
	public static void main(String[] args)
	{
		InitUser i = new InitUser();
	}
	public InitUser()
	{
		UserDataHelper userDH = new UserDataHelper();
		User leUser = new User(0,"cretthie", "passe");

			userDH.insert(leUser);
		
		leUser = new User(0,"lukas", "germann");

			userDH.insert(leUser);
			/*
		leUser = new User(0,"cretthie1", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie2", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie3", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie4", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie5", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie6", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie7", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie8", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		*/
		/*
		User toSearch = new User(0,"Thierry", "", "", "", 0);
		User foundedUser = userDH.select_by_login(toSearch);
		System.out.println(foundedUser.Firstname() + "\n" + foundedUser.Lastname() + "\n" + foundedUser.IdUser()  + "\n" + foundedUser.Login());
		*/
	}
}
