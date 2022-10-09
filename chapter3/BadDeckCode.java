package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter3.Card.Rank;
import chapter3.Card.Suit;
import chapter3.Card.Rank.RankType;
import chapter3.Card.Suit.Color;

public class BadDeckCode extends Deck {
	private final List<Card> aListOfCards;

	/*****************************************************************************
	 * 
	 * BAD CODE IMPLEMENTATION BELOW
	 * 
	 * DO NOT USE THIS CODE :)
	 * 
	 *****************************************************************************/

	/**
	 * NOTE THAT THIS CONSTRUCTOR IS USING THE DUPLICATE CODE ANTIPATTERN AND THE
	 * SWITCH STATEMENT ANTIPATTERN.
	 * 
	 * @param pColor the Color of the Cards to add in the new Deck. If pColor is
	 *               null, then the Deck is initialized with all Cards (default
	 *               constructor).
	 */
	public BadDeckCode(Color pColor) {
		this.aListOfCards = new ArrayList<>();
		if (pColor == null) {
			for (Suit pSuit : Suit.values()) {
				for (Rank pRank : Rank.values()) {
					this.aListOfCards.add(new Card(pRank, pSuit));
				}
			}
		} else if (pColor == Color.BLACK) {
			for (Suit pSuit : Suit.values()) {
				if ((pSuit == Suit.HEARTS) || (pSuit == Suit.DIAMONDS))
					continue;
				for (Rank pRank : Rank.values()) {
					this.aListOfCards.add(new Card(pRank, pSuit));
				}
			}
		} else { // pColor == Color.RED
			for (Suit pSuit : Suit.values()) {
				if ((pSuit == Suit.SPADES) || (pSuit == Suit.CLUBS))
					continue;
				for (Rank pRank : Rank.values()) {
					this.aListOfCards.add(new Card(pRank, pSuit));
				}
			}
		}
		Collections.shuffle(this.aListOfCards);
	}

	/**
	 * NOTE THAT THIS CONSTRUCTOR IS USING THE DUPLICATE CODE ANTIPATTERN AND THE
	 * SWITCH STATEMENT ANTIPATTERN.
	 * 
	 * @param pRankType the RankType of the Cards to add in the new Deck. If
	 *                  pRankType is null, then the Deck is initialized with all
	 *                  Cards (default constructor).
	 */
	public BadDeckCode(RankType pRankType) {
		this.aListOfCards = new ArrayList<>();
		if (pRankType == null) {
			for (Suit pSuit : Suit.values()) {
				for (Rank pRank : Rank.values()) {
					this.aListOfCards.add(new Card(pRank, pSuit));
				}
			}
		} else if (pRankType == RankType.NUMBER) {
			for (Suit pSuit : Suit.values()) {
				for (Rank pRank : Rank.values()) {
					if ((pRank == Rank.JACK) || (pRank == Rank.QUEEN) || (pRank == Rank.KING))
						continue;
					this.aListOfCards.add(new Card(pRank, pSuit));
				}
			}
		} else { // pRankType == RankType.FACE
			for (Suit pSuit : Suit.values()) {
				for (Rank pRank : Rank.values()) {
					if ((pRank != Rank.JACK) && (pRank != Rank.QUEEN) && (pRank != Rank.KING))
						continue;
					this.aListOfCards.add(new Card(pRank, pSuit));
				}
			}
		}
		Collections.shuffle(this.aListOfCards);
	}
}
