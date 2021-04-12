package multiThreaderChatServer;

public class ServerStarter
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Server myServer = new Server();
		try
		{
			Thread.sleep(6000000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		myServer.annihilate();
	}
}
