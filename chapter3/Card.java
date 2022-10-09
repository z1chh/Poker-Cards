package chapter3;

import java.util.Comparator;

public class Card implements Comparable<Card> {
	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

		public enum RankType {
			FACE, NUMBER
		}

		/**
		 * Getter method for the rank type of a Rank.
		 * 
		 * @return RankType the rank type of the current Rank.
		 * @pre this != null
		 */
		public RankType getRankType() {
			assert this != null;
			if ((this == Rank.JACK) || (this == Rank.QUEEN) || (this == Rank.KING))
				return RankType.FACE;
			else
				return RankType.NUMBER;
		}
	}

	public enum Suit {
		SPADES, HEARTS, DIAMONDS, CLUBS;

		public enum Color {
			RED, BLACK
		}

		/**
		 * Getter method for the color of a Suit.
		 * 
		 * @return Color the color of the current Suit.
		 * @pre this != null
		 */
		public Color getColor() {
			assert this != null;
			if ((this == Suit.SPADES) || (this == Suit.CLUBS))
				return Color.BLACK;
			else if ((this == Suit.HEARTS) || (this == Suit.DIAMONDS))
				return Color.RED;
			else
				return null;
		}
	}

	private final Rank aRank;
	private final Suit aSuit;

	/**
	 * @param pRank The Rank of the Card.
	 * @param pSuit The Suit of the Card.
	 * @pre ((pRank != null) && (pSuit != null))
	 */
	public Card(Rank pRank, Suit pSuit) {
		assert ((pRank != null) && (pSuit != null));
		this.aRank = pRank;
		this.aSuit = pSuit;
	}

	/**
	 * @param pCard The Card to duplicate.
	 * @pre ((pCard.aRank != null) && (pCard.aSuit != null))
	 */
	Card(Card pCard) {
		assert ((pCard.aRank != null) && (pCard.aSuit != null));
		this.aRank = pCard.aRank;
		this.aSuit = pCard.aSuit;
	}

	/**
	 * Getter method for the Rank of the Card.
	 * 
	 * @return Rank the Rank of the Card.
	 */
	public Rank getRank() {
		return this.aRank;
	}

	/**
	 * Getter method for the Suit of the Card.
	 * 
	 * @return Rank the Suit of the Card.
	 */
	public Suit getSuit() {
		return this.aSuit;
	}

	/**
	 * Checks whether the Card has a Suit of Color RED.
	 * 
	 * @return true if the Color is RED.
	 * @return false otherwise (Color is BLACK).
	 */
	public boolean isRed() {
		return (this.aSuit.getColor() == Suit.Color.RED);
	}

	/**
	 * Checks whether the Card has a Suit of Color BLACK.
	 * 
	 * @return true if the Color is BLACK.
	 * @return false otherwise (Color is RED).
	 */
	public boolean isBlack() {
		return (this.aSuit.getColor() == Suit.Color.BLACK);
	}

	/**
	 * Checks whether the Card is a FACE.
	 * 
	 * @return true if the Rank has ordinal value greater than 10.
	 * @return false otherwise (Card is a NUMBER).
	 */
	public boolean isFace() {
		return (this.aRank.getRankType() == Rank.RankType.FACE);
	}

	/**
	 * Checks whether the Card is a NUMBER.
	 * 
	 * @return true if the Rank has ordinal value lesser than 10.
	 * @return false otherwise (Card is a FACE).
	 */
	public boolean isNumber() {
		return (this.aRank.getRankType() == Rank.RankType.NUMBER);
	}

	/**
	 * Method to print out the Card to the screen (output).
	 */
	public void print() {
		System.out.println(this);
	}

	/**
	 * Overrides java.lang.Object.toString.
	 * 
	 * @return the Card as a String.
	 */
	@Override
	public String toString() {
		return this.aRank.toString() + " of " + this.aSuit.toString();
	}

	/**
	 * Compares by Suit first (ordinal value).
	 * 
	 * Then compares by Rank (ordinal value).
	 * 
	 * @return -1 if the implicit Card comes before the explicit Card.
	 * @return 0 if the implicit Card is the same Card as the explicit Card.
	 * @return 1 if the implicit Card comes after the explicit Card.
	 * @pre this != null
	 * @pre pCard != null
	 */
	public int compareTo(Card pCard) {
		assert this != null;
		assert pCard != null;
		if (this.aSuit.compareTo(pCard.aSuit) == 0)
			return this.aRank.compareTo(pCard.aRank);
		else
			return this.aSuit.compareTo(pCard.aSuit);
	}

	/*****************************************************************************
	 * 
	 * Comparators
	 * 
	 *****************************************************************************/

	/**
	 * Compares by Suit first (ordinal value).
	 * 
	 * Then compares by Rank (ordinal value).
	 */
	static class StandardComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			if (pCard1.aSuit.compareTo(pCard2.aSuit) == 0)
				return pCard1.aRank.compareTo(pCard2.aRank);
			else
				return pCard1.aSuit.compareTo(pCard2.aSuit);
		}
	}

	/**
	 * Compares by Rank only (ordinal value).
	 */
	static class ByRankComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			return pCard1.aRank.compareTo(pCard2.aRank);
		}
	}

	/**
	 * Compares by Suit only (ordinal value).
	 */
	static class BySuitComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			return pCard1.aSuit.compareTo(pCard2.aSuit);
		}
	}

	/**
	 * Compares by Rank first (ordinal value).
	 * 
	 * Then compares by Suit (ordinal value).
	 */
	static class ByRankFirstComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			if (pCard1.aRank.compareTo(pCard2.aRank) == 0)
				return pCard1.aSuit.compareTo(pCard2.aSuit);
			else
				return pCard1.aRank.compareTo(pCard2.aRank);
		}
	}

	/**
	 * Compares by Suit first (ordinal value).
	 * 
	 * Then compares by Rank (ordinal value).
	 */
	static class BySuitFirstComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			if (pCard1.aSuit.compareTo(pCard2.aSuit) == 0)
				return pCard1.aRank.compareTo(pCard2.aRank);
			else
				return pCard1.aSuit.compareTo(pCard2.aSuit);
		}
	}

	/**
	 * Does not compare by Cards.
	 */
	static class VoidComparator implements Comparator<Card> {

		/**
		 * @return 0 every time.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			return 0;
		}
	}

	/**
	 * Compares by Suit first (reverse ordinal value).
	 * 
	 * Then compares by Rank (reverse ordinal value).
	 */
	static class ByReverseComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			if (pCard1.aSuit.compareTo(pCard2.aSuit) == 0)
				return pCard2.aRank.compareTo(pCard1.aRank);
			else
				return pCard2.aSuit.compareTo(pCard1.aSuit);
		}
	}

	/**
	 * Compares by Rank only (reverse ordinal value).
	 */
	static class ByReverseRankComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			return pCard2.aRank.compareTo(pCard1.aRank);
		}
	}

	/**
	 * Compares by Suit only (reverse ordinal value).
	 */
	static class ByReverseSuitComparator implements Comparator<Card> {

		/**
		 * @return -1 if the first Card comes before the second Card.
		 * @return 0 if the first Card is the same Card as the second Card.
		 * @return 1 if the first Card comes after the second Card.
		 * @pre pCard1 != null
		 * @pre pCard2 != null
		 */
		@Override
		public int compare(Card pCard1, Card pCard2) {
			assert pCard1 != null;
			assert pCard2 != null;
			return pCard2.aSuit.compareTo(pCard1.aSuit);
		}
	}
}
