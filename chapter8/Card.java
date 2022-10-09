package chapter8;

public class Card {
	public enum Suit {
		CLUBS, DIAMONDS, SPADES, HEARTS;
	}

	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	private Rank aRank;
	private Suit aSuit;

	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}

	/**
	 * @return The rank of the card.
	 */
	public Rank getRank() {
		return aRank;
	}

	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit() {
		return aSuit;
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s", this.aRank, this.aSuit);
	}
}
