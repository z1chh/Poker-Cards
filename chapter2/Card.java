package chapter2;

/**
 * Card class.
 * Represents a valid Card.
 */
public class Card
{	
	private final Rank aRank;
	private final Suit aSuit;
	
	
	/**
	 * Default constructor for Card.
	 * Initializes a Card as the ACE of SPADES.
	 */
	private Card()
	{
		this.aRank = Rank.ACE;
		this.aSuit = Suit.SPADES;
	}
	
	/**
	 * Constructor for Card.
	 * Throws an exception if the Card has an invalid Rank or Suit.
	 * @param pRank The Rank of the Card.
	 * @param pSuit The Suit of the Card.
	 * @pre ((pRank != null) && (pSuit != null))
	 */
	Card(Rank pRank, Suit pSuit)
	{
		assert((pRank != null) && (pSuit != null));
		this.aRank = pRank;
		this.aSuit = pSuit;
	}
	
	/**
	 * @param pCard The Card to duplicate.
	 * @pre pCard.getRank() != null
	 * @pre pCard.getSuit() != null
	 */
	public Card(Card pCard)
	{
		assert ((pCard.aRank != null) && (pCard.aSuit != null));
		this.aRank = pCard.aRank;
		this.aSuit = pCard.aSuit;
	}
	
	
	/**
	 * Getter method for Card.aRank.
	 * @return the Rank of the Card.
	 */
	public Rank getRank()
	{
		return this.aRank;
	}
	
	/**
	 * Getter method for Card.aSuit.
	 * @return the Suit of the Card.
	 */
	public Suit getSuit()
	{
		return this.aSuit;
	}

	
	
	/**
	 * Overrides java.lang.Object.toString.
	 * @return the Card as a String.
	 */
	public String toString()
	{
		return this.aRank.toString() + " of " + this.aSuit.toString();
	}

}