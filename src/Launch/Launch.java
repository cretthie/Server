package Launch;

import Server.Server;

public class Launch 
{
	public static void main(String[] args)
	{
		Server srv = new Server(45000,15);
		srv.runNetwork();
	}
}
