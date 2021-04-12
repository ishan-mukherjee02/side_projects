package blackjack_2;

import java.util.ArrayList;

/**
 * Represents all or part player's or dealer's blackjack hand
 */
public class Hand
{
    private ArrayList<Card> cards;
    
    /**
     * Constructs a hand containing the specified 2 cards
     * @param card1 the first card
     * @param card2 the second card
     */
    public Hand(Card card1, Card card2)
    {
        cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
    }

    /**
     * Returns the numerical value of this hand according to the rules of blackjack
     * @return the numerical value of this hand
     */
    public int getValue()
    {
    	
		int sum = 0;
		int aceCounter = 0;
		
		for(int i = 0; i < cards.size(); i++) 
		{
			if(cards.get(i).getValue() == 11 || cards.get(i).getValue() == 12 || cards.get(i).getValue() == 13) //works
			{
				sum += 10;
			}
			else
			{
				sum += cards.get(i).getValue();
			}


			if(cards.get(i).getValue() == 1)
			{		
				aceCounter++;
			}
		}

			if(sum < 12 && aceCounter > 0)
			{
				sum += 10;
			}

		return sum; // TODO: implement
    }

    /**
     * Returns true if this hand is a blackjack, false otherwise
     * @return true if this hand is a blackjack, false otherwise
     */
    public boolean isBlackjack()
    {
    	if(cards.size() == 2 && getValue() == 21)
    		return true;
    	
    	return false;    }

    /**
     * Returns the cards in this hand
     * @return the cards in this hand
     */
    public ArrayList<Card> getCards()
    {
    	 return cards;    
    }
    
    /**
     * Returns the cards in this hand followed by their numerical value
     * Ex: JS AH (21)
     */
    public String toString()
    {
    	String hand = "";
    	
        for(int i = 0; i < cards.size(); i++)
        {
        	hand += cards.get(i).toString();
        	hand += " ";
        }
        
        hand += "(" + getValue() + ")";
        
        return hand;
    }

    /**
     * Adds the specified card to this hand
     * @param card the card to add
     */
    public void addCard(Card card)
    {
    	cards.add(card);
    }

    /**
     * Returns the number of cards in this hand
     * @return the number of cards in this hand
     */
    public int getNumCards()
    {
    	return cards.size();
    }
}