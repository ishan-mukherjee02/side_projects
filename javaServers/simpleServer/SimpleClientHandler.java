package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClientHandler implements Runnable
{
	private Thread t;
	private Socket connectionToClient;
	
	public SimpleClientHandler(Socket clientConnection)
	{
		connectionToClient = clientConnection;
		t = new Thread(this);
		t.start();
	}
	
	public void run()
	{
		try
		{
			Scanner in = new Scanner(connectionToClient.getInputStream());
			PrintWriter out = new PrintWriter(connectionToClient.getOutputStream());
			
			while( ! Thread.interrupted() )
			{
				System.out.println(in.next());
				out.println("ACK");
				out.flush();
			}
		}
		catch (IOException e)
		{
			
		}

	}
	
	public void annihilate()
	{
		t.interrupt();
	}
}
