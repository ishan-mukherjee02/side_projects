package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleServer implements Runnable
{
	private Thread t;
	private List<SimpleClientHandler> clients;

	public SimpleServer()
	{
		clients = new LinkedList<SimpleClientHandler>();
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		ServerSocket ss = null;
		
		try
		{
			ss = new ServerSocket(8888);
			ss.setSoTimeout(1000);
			System.out.println("Waiting for connections");
			
			while( ! Thread.interrupted() )
			{
				try
				{
        				Socket s = ss.accept();
        				System.out.println("Client connected");
        				clients.add(new SimpleClientHandler(s));
				}
				catch(SocketTimeoutException e)
				{
					
				}
			}
			
		}
		catch (IOException e)
		{
			System.out.println("IOException - Server terminating");
		}
		finally
		{
			System.out.println("Terminating server");
			try
			{
				closeAll();
				ss.close();
			}
			catch (IOException e)
			{
				
			}
			finally
			{
				System.out.println("Server terminated");
			}
		}
	}
	
	private void closeAll()
	{
		for(SimpleClientHandler sch : clients)
			sch.annihilate();
		clients.clear();
	}
	
	public void annihilate()
	{
		t.interrupt();
	}
}
