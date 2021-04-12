package multiThreaderChatServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable
{
	private Thread t;
	private Socket connectionToClient;
	private Scanner in;
	private PrintWriter out;
	private messageListener parent;
	public String username;
	
	public ClientHandler(Socket clientConnection) throws IOException
	{
		username = ""+(int)((Math.random()*100)+1);

		connectionToClient = clientConnection;
		
		in =  new Scanner(connectionToClient.getInputStream());
		out = new PrintWriter(connectionToClient.getOutputStream());
		out.println("You are connected to the chat server, type * to disconnect and ~ to change username");
		
		t = new Thread(this);
		t.start();
	}
	
	public void run()
	{	
		while(!Thread.interrupted())
		{
			String temp = in.nextLine();
			
			if(temp.equals("*"))//handles leaving server
				annihilate();
			else if(temp.equals("~"))//handles changing username
			{
				out.print("Enter new username: ");
				username = in.nextLine();
			}
			else
			{
				System.out.println(username+": "+ temp);//send to distributor here 
				//add() give message to distrib.
				parent.add(username+": "+ temp);
				
				out.println("   --Message Sent--");
				out.print(username+": ");
			}
			
			out.flush();
		}
	}
	
	public void pullMessage(String message)
	{
		/*boolean same = true;
		
		for(int i=0; i<message.length() && message.charAt(i) == ':'; i++)
		{
			if(message.charAt(i) != username.charAt(i))
				same = false;
		}
		
		if(!same)*/
			out.println(message);
	}
	
	public void annihilate()
	{
		out.println("You have disconnected");
		System.out.println(username+" has disconnected");//send to distributor here
		parent.messages.add(username+" has disconnected");
		t.interrupt();
	}
}
