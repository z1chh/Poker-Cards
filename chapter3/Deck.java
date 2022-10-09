package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import chapter3.Card.Rank;
import chapter3.Card.Suit;

public class Deck implements CardSource {
	private final List<Card> aListOfCards;

	/**
	 * Default constructor for Deck. Initializes the Deck with the standard 52
	 * playing Cards.
	 */
	public Deck() {
		this.aListOfCards = new ArrayList<>();
		for (Suit pSuit : Suit.values()) {
			for (Rank pRank : Rank.values()) {
				this.aListOfCards.add(new Card(pRank, pSuit));
			}
		}
		Collections.shuffle(this.aListOfCards);
	}

	/**
	 * Custom constructor for Deck. Uses the pCardValidator for a special
	 * configuration to initialize the Deck.
	 * 
	 * @param pCardValidator the configuration to use when creating the Deck.
	 * @pre pCardConfigurator != null
	 */
	public Deck(CardConfigurator pCardConfigurator) {
		assert (pCardConfigurator != null);
		this.aListOfCards = new ArrayList<>();
		for (Suit pSuit : Suit.values()) {
			for (Rank pRank : Rank.values()) {
				if (pCardConfigurator.isValid(new Card(pRank, pSuit))) {
					this.aListOfCards.add(new Card(pRank, pSuit));
				}
			}
		}
		Collections.shuffle(this.aListOfCards);
	}

	/**
	 * @return true if the Deck has no Cards.
	 */
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	/**
	 * @pre !this.isEmpty()
	 * @return the Card drawn.
	 */
	public Card draw() {
		assert (!this.isEmpty());
		return this.aListOfCards.remove(0);
	}

	/**
	 * Checks for pCard in the Deck.
	 * 
	 * @return true if pCard is in the Deck.
	 * @return false otherwise.
	 * @pre pCard != null
	 */
	public boolean hasCard(Card pCard) {
		assert pCard != null;
		for (Card curCard : this) {
			if ((curCard.getRank() == pCard.getRank()) && (curCard.getSuit() == pCard.getSuit()))
				return true;
		}
		return false;
	}

	/**
	 * Reveals the Card on the top of the Deck.
	 * 
	 * Note that it does now draw it.
	 * 
	 * @return Card the Card on top of the Deck.
	 */
	public Card nextCard() {
		assert this.size() != 0;
		return this.aListOfCards.get(0);
	}

	/**
	 * Getter method for the size of the Deck.
	 * 
	 * @return int the size of the Deck.
	 */
	public int size() {
		return this.aListOfCards.size();
	}

	/**
	 * Prints out to the screen the list of Cards in the Deck, in order.
	 */
	public void print() {
		for (Card pCard : this) {
			pCard.print();
		}
	}

	/**
	 * Prints out to the screen the list of Cards in the Deck, in order.
	 * 
	 * Note that if pCards > Deck.getSize(), then only Deck.aSize will be printed.
	 * 
	 * @pre pCards > 0
	 */
	public void print(int pCards) {
		assert pCards > 0;
		for (Card pCard : this) {
			pCard.print();
			if (--pCards == 0)
				break;
		}
	}

	/**
	 * Overrides java.lang.Object.toString.
	 * 
	 * @return the Deck as a String.
	 */
	@Override
	public String toString() {
		String s = "";
		for (Card pCard : this) {
			s += (pCard + "\n");
		}
		return s;
	}

	/**
	 * Sorts the Deck in order (like a newly initialized Deck).
	 * 
	 * Suit order: Spades, Hearts, Clubs, Diamonds.
	 * 
	 * Rank order: Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack,
	 * Queen, King.
	 */
	public void sort() {
		Collections.sort(this.aListOfCards);
	}

	/**
	 * Sorts the Deck in order (like a newly initialized Deck).
	 * 
	 * Order is specified by the given Comparator<Card>.
	 */
	public void sort(Comparator<Card> pComparator) {
		Collections.sort(this.aListOfCards, pComparator);
	}

	/**
	 * Shuffles the Cards of the Deck in a random order.
	 */
	public void shuffle() {
		Collections.shuffle(this.aListOfCards);
	}

	/**
	 * @return Iterator<Card> an iterator for the list of Cards of the Deck.
	 */
	@Override
	public Iterator<Card> iterator() {
		return this.aListOfCards.iterator();
	}
}
