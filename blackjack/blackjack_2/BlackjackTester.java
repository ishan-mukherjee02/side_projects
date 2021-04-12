package blackjack_2;

public class BlackjackTester {

	public static void main(String[] args) {
		testWinConditions();
		
		
	}
	
	public static void testWinConditions()
	{
		Blackjack bj = new Blackjack(1000.0);
		Card c1, c2, c3, c4;
		
		//Player bj and DEALER DOESNT
		c1 = new Card("S", 10);
		c2 = new Card("S", 1);
		bj.playersHand = new Hand(c1, c2);
		System.out.println(bj.getPlayersHand());
		
		c3 = new Card("S", 10);
		c4 = new Card("S", 6);
		bj.dealersHand = new Hand(c3, c4);
		System.out.println(bj.getDealersHand());
		
		System.out.println(bj.isPlayerWin());
		System.out.println("Should be: true");
		System.out.println();
		
		c1 = new Card("S", 10);
		c2 = new Card("S", 1);
		bj.playersHand = new Hand(c1, c2);
		System.out.println(bj.getPlayersHand());
		
		c3 = new Card("S", 10);
		c4 = new Card("S", 1);
		bj.dealersHand = new Hand(c3, c4);
		System.out.println(bj.getDealersHand());
		
		System.out.println(bj.isPlayerWin());
		System.out.println("Should be: false");
		System.out.println();
		
		//Dealer bust
		c1 = new Card("S", 10);
		c2 = new Card("S", 5);
		bj.playersHand = new Hand(c1, c2);
		System.out.println(bj.getPlayersHand());
		
		c3 = new Card("S", 10);
		c4 = new Card("S", 6);
		Card c5 = new Card("S", 7);
		bj.dealersHand = new Hand(c3, c4);
		bj.dealersHand.addCard(c5);
		System.out.println(bj.getDealersHand());
		
		System.out.println(bj.isPlayerWin());
		System.out.println("Should be: true");
		System.out.println();
		//Player high 
		c1 = new Card("S", 10);
		c2 = new Card("S", 9);
		bj.playersHand = new Hand(c1, c2);
		System.out.println(bj.getPlayersHand());
		
		c3 = new Card("S", 10);
		c4 = new Card("S", 7);
		bj.dealersHand = new Hand(c3, c4);
		System.out.println(bj.getDealersHand());
		
		System.out.println(bj.isPlayerWin());
		System.out.println("Should be: true");
		System.out.println();
	}

}
