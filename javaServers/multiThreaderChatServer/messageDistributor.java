package multiThreaderChatServer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class messageDistributor implements Runnable //Distributes given messages to all clients
{
	private Queue<String> messages;
	private List<ClientHandler> clients;
	private Thread t;
	
	public messageDistributor(List<ClientHandler> clients) 
	{
		this.clients = clients;
		messages = new LinkedList<String>();
		t = new Thread(this);
		t.start();
	}
	
	public void run()
	{
		while(!messages.isEmpty())
		{
			for(ClientHandler c : clients)
				c.pullMessage(messages.poll());
		}
	}
	
	public void pushMessage(String message, String username)
	{
		messages.add(message);
	}
}
