package chapter1;

public class Card {
	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	public enum Suit {
		SPADES, HEARTS, CLUBS, DIAMONDS;

		public enum Color {
			RED, BLACK;
		}

		public Color getColor() {
			assert this != null;
			if ((this == Suit.HEARTS) || (this == Suit.DIAMONDS))
				return Color.RED;
			else
				return Color.BLACK;
		}
	}

	private final Rank aRank;
	private final Suit aSuit;

	public Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		this.aRank = pRank;
		this.aSuit = pSuit;
	}
}
