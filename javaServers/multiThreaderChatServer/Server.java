package multiThreaderChatServer;

import java.io.*;
import java.util.Queue;
import java.net.*;
import java.util.*;

public class Server implements Runnable
{
	private Thread t;
	private List<ClientHandler> clients;
	public Queue<String> messages;

	public Server()
	{
		clients = new LinkedList<ClientHandler>();
		messages = new LinkedList<String>();
		t = new Thread(this);
		t.start();
		System.out.println("Server Started!");
	}

	public void run()
	{
		ServerSocket ss = null;
	
		try
		{
			ss = new ServerSocket(25565);
			ss.setSoTimeout(1000);
			System.out.println("Waiting for connections");
			
			while(!Thread.interrupted())
			{	
				try
				{
        				Socket s = ss.accept();
        				clients.add(new ClientHandler(s));
        				System.out.println("Client connected");
				}
				catch(SocketTimeoutException e){}
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
			catch (IOException e){}
			finally
			{
				System.out.println("Server terminated");
			}
		}
	}
	
	private void closeAll()
	{
		for(ClientHandler sch : clients)
			sch.annihilate();
		clients.clear();
	}
	
	public void annihilate()
	{
		t.interrupt();
	}
}
