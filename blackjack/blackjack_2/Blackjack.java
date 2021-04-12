package blackjack_2;

import java.util.ArrayList;

/**
 * The Blackjack class allows a single player to play a game of blackjack.
 * The class tracks the player's bankroll but makes no attempt to prevent
 * a negative bankroll.
 *
 */
public class Blackjack
{
	private static final int DECKS = 6, CARDS_PER_DECK = 52;
	private static final double SHOE_PENETRATION = 0.75;
	
    private Shoe shoe;
    
    private double playersMoney;
    
    Hand playersHand;
    private double playersBet;
    
    Hand dealersHand;
    
    /**
     * Constructs a blackjack object that is ready to play.
     * @param playersMoney the player's starting bankroll (all values, including 0 and negative values, are permitted)
     */
    public Blackjack(double playersMoney)
    {
        this.playersMoney = playersMoney;
        shoe = new Shoe(DECKS);
        
        
    }
    
    /**
     * Resets for another round, including reseting shoe if necessary
     */
    private void reset()
    {
        if((shoe.cardsLeft() / (CARDS_PER_DECK * DECKS)) <= .25)
        	shoe.reset();
        
        playersBet = 0;
        
    }
    
    /**
     * Returns the player's money (can be negative)
     * @return the player's money
     */
    public double getPlayersMoney()
    {
        return playersMoney;
    }
    
    /**
     * Returns the player's bet
     * @return the player's bet for the hand
     */
    public double getPlayersBet()
    {
        return playersBet; 
    }
    
    /**
     * Places a bet at the start of a round. Deals cards to the player and dealer.
     * @param amount the amount to bet
     * @throws IllegalArgumentException if the bet is too much
     */
    public void placeBetAndDealCards(double amount)
    {
    	if(amount > playersMoney)
    		throw new IllegalArgumentException("You stupid, bet something you have.");	
    	else
    	{
	    	playersMoney -= amount;
    		playersBet = amount;
    		
    		Card card1 = shoe.dealCard();
    		Card card2 = shoe.dealCard();
    		Card card3 = shoe.dealCard();
    		Card card4 = shoe.dealCard();
		
    		playersHand = new Hand(card1, card3);
	        dealersHand = new Hand(card2, card4);
    	}
    }
    
    /**
     * Returns the player's hand
     * @return the player's hand
     */
    public Hand getPlayersHand()
    {
        return playersHand; 
    }
    
    /**
     * Returns the dealer's hand
     * @return the dealer's hand
     */
    public Hand getDealersHand()
    {
        return dealersHand;
    }
    
    /**
     * Returns true if the player can hit, false otherwise
     * @return true if the player can hit, false otherwise
     */
    public boolean canHit()
    {
        return playersHand.getValue() < 21 && !dealersHand.isBlackjack();
    }
    
    /**
     * Deals another card to the player's hand.
     * 
     * Precondition: canHit()
     */
    public void hit()
    {
        playersHand.addCard(shoe.dealCard());
    }
    
    /**
     * Plays the dealer's hand.
     */
    public void playDealersHand()
    {
    	while(dealersHand.getValue() < 17)
    	{
    		dealersHand.addCard(shoe.dealCard());
    	}
    	
    	System.out.println("Dealer has: " + dealersHand.toString());
    	
    }
    
    /**
     * Returns true if the player's hand is a push, false otherwise
     * @return true if the player's hand is a push, false otherwise
     */
    public boolean isPush()
    {
        if(dealersHand.isBlackjack() && !playersHand.isBlackjack() && playersHand.getValue() == 21)
        	return false;
        else if(playersHand.isBlackjack() && !dealersHand.isBlackjack() && dealersHand.getValue() == 21)
        	return false;
    	
        return dealersHand.getValue() == playersHand.getValue();
    }
    
    /**
     * Returns true if the player's hand is a player win, false otherwise
     * @return true if the player's hand is a player win, false otherwise
     */
    public boolean isPlayerWin()
    {	
    	if(dealersHand.isBlackjack())
    		return false;
    	else if(playersHand.isBlackjack())
    		return true;
    	else if(dealersHand.getValue() > 21 && playersHand.getValue() <= 21)
    		return true;
    	else if(playersHand.getValue() > dealersHand.getValue() && playersHand.getValue() <= 21)
    		return true;
    	
    	return false;
    		
    }
    
    /**
     * Returns true if the player has blackjack, false otherwise
     * @return true if the player has blackjack, false otherwise
     * 
     * Precondition: isPlayerWin()
     */
    public boolean isPlayerBlackjack()
    {
        return playersHand.isBlackjack();
    }
    
    /**
     * Resolves the player's bets (updates player's money based on the
     * results of the round) and resets for another round
     */
    public void resolveBetsAndReset()
    {
        if(isPlayerWin())
        {
        	if(isPlayerBlackjack())
        		playersMoney += playersBet + (playersBet * 1.5);
        	else
        		playersMoney += playersBet * 2;
        }
        else if(isPush())
        {
        	playersMoney += playersBet;
        }
        
        reset();
    }

    public boolean canDouble()
    {
    	return canHit() && (playersMoney >= playersBet * 2) && playersHand.getCards().size() == 2;
    }

    public void doublee()
    {
    	hit();
    	playersMoney -= playersBet;
    	playersBet *= 2;
    }
}
