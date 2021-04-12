package simpleServer;

public class ServerStarter
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SimpleServer myServer = new SimpleServer();
		try
		{
			Thread.sleep(600000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myServer.annihilate();
	}
}
