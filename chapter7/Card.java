package chapter7;

import java.util.Objects;

public class Card implements Comparable<Card> {
	public enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }
	public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS }
	
	private final Rank aRank;
	private final Suit aSuit;
	
	private final static Card[][] CARDS = new Card[13][4];
	
	private Card(Rank pRank, Suit pSuit) {
		aRank = pRank; aSuit = pSuit;
	}
	
	static {
		for(Rank rank: Rank.values()) {
			for(Suit suit: Suit.values()) {
				CARDS[rank.ordinal()][suit.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	public Rank getRank() { return this.aRank; }
	public Suit getSuit() { return this.aSuit; }
	
	public static Card get(Rank pRank, Suit pSuit) { return CARDS[pRank.ordinal()][pSuit.ordinal()]; }
	
	public int compareTo(Card pCard) {
		if(this.aSuit.compareTo(pCard.aSuit) == 0) return this.aRank.compareTo(pCard.aRank);
				return this.aSuit.compareTo(pCard.aSuit);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		return this.aRank.equals(((Card)o).aRank) && this.aSuit.equals(((Card)o).aSuit);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.aRank, this.aSuit);
	}
}
