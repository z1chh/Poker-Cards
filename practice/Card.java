package practice;

import java.util.Comparator;
import java.util.Objects;

import practice.Card.Suit.Color;

public class Card implements Comparable<Card> {
	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
		
		public boolean isFace() {
			return this.ordinal() > 10;
		}
		
		public boolean isNumber() {
			return ! this.isFace();
		}
		
	}
	
	public enum Suit {
		SPADES, HEARTS, CLUBS, DIAMONDS;
		
		public enum Color {BLACK, RED}
		
		public boolean isBlack() {
			return this == Suit.SPADES || this == Suit.CLUBS;
		}
		
		public boolean isRed() {
			return this == Suit.HEARTS || this == Suit.DIAMONDS;
		}
		
		public Color getColor() {
			return this.isBlack() ? Color.BLACK: Color.RED;
		}
		
	}
	
	private final Rank aRank;
	private final Suit aSuit;
	
	private static final Card[][] CARDS = new Card[4][13];
	static {
		for(Suit suit: Suit.values()) {
			for(Rank rank: Rank.values()) {
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	public final Comparator<Card> DEFAULTCOMPARATOR = this.getDefaultComparator();
	
	private Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		this.aRank = pRank;
		this.aSuit = pSuit;
	}
	
	public static Card get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return Card.CARDS[pSuit.ordinal()][pRank.ordinal()];
	}
	
	public Rank getRank() {
		return this.aRank;
	}
	
	public Suit getSuit() {
		return this.aSuit;
	}
	
	public boolean isFace() {
		return this.aRank.isFace();
	}
	
	public boolean isNumber() {
		return this.aRank.isNumber();
	}
	
	public boolean isBlack() {
		return this.aSuit.isBlack();
	}
	
	public boolean isRed() {
		return this.aSuit.isRed();
	}
	
	public Color getColor() {
		return this.aSuit.getColor();
	}

	@Override
	public int compareTo(Card pCard) {
		if(this.aSuit.compareTo(pCard.aSuit) == 0) {
			return this.aRank.compareTo(pCard.aRank);
		} else {
			return this.aSuit.compareTo(pCard.aSuit);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		} else if (this == o) {
			return true;
		} else if (this.getClass() != o.getClass()) {
			return false;
		} else {
			Card pCard = (Card) o;
			return this.aRank == pCard.aRank && this.aSuit == pCard.aSuit;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.aRank, this.aSuit);
	}
	
	private Comparator<Card> getDefaultComparator() {
		return new Comparator<Card>() {

			@Override
			public int compare(Card pCard1, Card pCard2) {
				if(pCard1.aSuit.compareTo(pCard2.aSuit) == 0) {
					return pCard1.aRank.compareTo(pCard2.aRank);
				} else {
					return pCard1.aSuit.compareTo(pCard2.aSuit);
				}
			}
			
		};
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s", this.aRank, this.aSuit);
	}
}
