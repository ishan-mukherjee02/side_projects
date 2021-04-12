package blackjack_2;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * A text based user interface that allows the user to play a game of blackjack.
 */
public class BlackjackUI {
	private Blackjack bj;
	private Scanner fromKeyboard = new Scanner(System.in);;
	private NumberFormat nf;

	/**
	 * Constructs a blackjack game with $1,000 in player bankroll
	 */
	public BlackjackUI()
	{
		bj = new Blackjack(1000);		
	}

	/**
	 * Returns a valid numerical bet obtained from the player
	 * 
	 * @return a valid numerical bet obtained from the player
	 */
	private double getValidBet() {


		System.out.println("What is your bet: ");
		int money = fromKeyboard.nextInt();
		fromKeyboard.nextLine();

		while (money <= 0) {
			System.out.println("What is your bet: ");
			money = fromKeyboard.nextInt();
			fromKeyboard.nextLine();
		}

		return money; // TODO: implement
	}

	/**
	 * Plays a single hand of blackjack
	 */
	public void playHand() 
	{
		System.out.println("You have: " + bj.getPlayersMoney());
		bj.placeBetAndDealCards(getValidBet());
		playPlayersHand();
		bj.playDealersHand();
		displayResult();
		bj.resolveBetsAndReset();
		System.out.println("You have: " + bj.getPlayersMoney());
	}

	/**
	 * Plays blackjack hands until the user chooses to quit
	 */
	public void playHandsUntilQuit() {
		String input;
		do {
			playHand();
			System.out.println("Keep playing? ");
			input = fromKeyboard.nextLine();
		}while(input.toLowerCase().equals("yes") && bj.getPlayersMoney() != 0);
		
		System.out.println("Thanks for playing");
	}

	/**
	 * Allows the player to hit until it is no longer possible to do so or until the
	 * player chooses to stand
	 */
	private void playPlayersHand() {
		
		System.out.println("You have: " + bj.getPlayersHand());
		System.out.println("Dealer has: " + bj.getDealersHand().getCards().get(0));

		String response = "";
		
		//if they can hit and want to hit
		while (bj.canHit() && !response.equals("stand") )
		{
			System.out.println("Do you want to hit, stand, or double: ");
			response = fromKeyboard.nextLine();
			
			if(response.toLowerCase().equals("hit"))
			{
				bj.hit();
				
				
				if(bj.getPlayersHand().getValue() > 21)
					System.out.println("You are bust.");
			}
			if(response.toLowerCase().equals("double"))
			{
				bj.doublee();
				if(bj.getPlayersHand().getValue() > 21)
					System.out.println("You are bust.");
				System.out.println("You have: " + bj.getPlayersHand());
				break;
			}
			
			System.out.println("You have: " + bj.getPlayersHand());
		}
	}

	/**
	 * Displays the result of the hand (push, player win, player blackjack or loss)
	 */
	private void displayResult() {
		if(bj.getDealersHand().isBlackjack() && bj.getPlayersHand().isBlackjack())
			System.out.println("Y'all both got blackjack, it's a push");
		else if(bj.getPlayersHand().isBlackjack())
			System.out.println("YOU GOT BLACKJACK!");
		else if(bj.isPlayerWin())
			System.out.println("Player win");
		else if(bj.isPush())
			System.out.println("Push");
		else
			System.out.println("Player loss");
	}

	/**
	 * Returns the numeric representation of input or -1 if input is not numeric
	 * 
	 * @param input the value to be converted to a number
	 * @return numeric representation or -1
	 */
	private double stringToNumber(String input) {
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
}
