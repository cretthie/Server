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
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"lukas", "germann");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		leUser = new User(0,"cretthie", "passe");
		if(userDH.loginExistOK(leUser).Id()<1)
		{
			userDH.insert(leUser);
		}
		/*
		User toSearch = new User(0,"Thierry", "", "", "", 0);
		User foundedUser = userDH.select_by_login(toSearch);
		System.out.println(foundedUser.Firstname() + "\n" + foundedUser.Lastname() + "\n" + foundedUser.IdUser()  + "\n" + foundedUser.Login());
		*/
	}
}
