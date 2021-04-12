package blackjack_2;

/**
 * Represents a playing card
 */
public class Card
{
    private String suit;
    private int value;
    
    /**
     * Constructs a playing card with the specified suit and value
     * @param suit one of "D", "H", "S", "C"
     * @param value 1 - 13 corresponding to Ace, 2 - 10, Jack, Queen, King
     * @throws IllegalArgumentException if argument formats don't match
     */
    public Card(String suit, int value)
    {
        if(!suit.equals("D") && !suit.equals("H") &&
                !suit.equals("S") && !suit.equals("C"))
            throw new IllegalArgumentException("suit must be one of \"D\", \"H\", \"S\", \"C\"");
        
        if(! (1 <= value && value <= 13) )
            throw new IllegalArgumentException("value must be 1 - 13 (inclusive)");
        
        this.suit = suit;
        this.value = value;
    }
    
    /**
     * Returns this card's suit ("D", "H", "S" or "C")
     * @return this card's suit
     */
    public String getSuit()
    {
        return suit;
    }
    
    /**
     * Return this card's value (1 - 13 corresponding to Ace, 2 - 10, Jack, Queen, King)
     * @return this card's value
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Returns this card with the 1 or 2 character value (A, 2-10, J, Q, K)
     * followed by the 1 character suit (D, H, S, C)
     * Examples: JD, 10H, AS, 9C
     */
    public String toString()
    {
    	String suit1 = suit;
		String value1 = "";
		
		if(value == 1)
			value1 += "A";
		else if(value == 2)
			value1 += "2";
		else if(value == 3)
			value1 += "3";
		else if(value == 4)
			value1 += "4";
		else if(value == 5)
			value1 += "5";
		else if(value == 6)
			value1 += "6";
		else if(value == 7)
			value1 += "7";
		else if(value == 8)
			value1 += "8";
		else if(value == 9)
			value1 += "9";
		else if(value == 10)
			value1 += "10";
		else if(value == 11)
			value1 += "J";
		else if(value == 12)
			value1 += "Q";
		else
			value1 += "K";
		
		return value1 + suit1;
    }
}
