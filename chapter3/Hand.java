package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import chapter3.Card.Rank;

public class Hand implements Comparable<Hand>, Iterable<Card> {
	public final int MAX_HAND_SIZE;
	private int aSize;
	private final List<Card> aListOfCards;

	/**
	 * @param pHandSize The maximum size of the Hand.
	 * @pre pHandSize > 0
	 */
	public Hand(int pHandSize) {
		assert pHandSize > 0;
		this.MAX_HAND_SIZE = pHandSize;
		this.aSize = 0;
		this.aListOfCards = new ArrayList<>();
	}

	/**
	 * Adds a new Card to the Hand.
	 * 
	 * @param pCard The Card to add to the Hand.
	 * @pre pCard != null
	 * @pre this.aSize < this.MAX_HAND_SIZE
	 */
	public void add(Card pCard) {
		this.addCard(pCard);
	}

	/**
	 * Adds a new Card to the Hand.
	 * 
	 * @param pCard The Card to add to the Hand.
	 * @pre pCard != null
	 * @pre !this.isFull()
	 */
	public void addCard(Card pCard) {
		assert pCard != null;
		assert !this.isFull();
		this.aSize = this.aSize + 1;
		this.aListOfCards.add(pCard);
	}

	/**
	 * @param pCard
	 * @return The Card to remove, if it is found.
	 * @return null if pCard is not in the Hand.
	 * @pre pCard != null
	 * @pre this.aSize > 0
	 */
	public Card removeCard(Card pCard) {
		assert pCard != null;
		assert this.aSize > 0;
		int cardFound = this.contains(pCard);
		if (cardFound == -1)
			return null;
		else {
			this.aSize = this.aSize - 1;
			return this.aListOfCards.remove(cardFound);
		}
	}

	/**
	 * @param pCard
	 * @return the index of the position of the Card if it is found in the Hand.
	 * @return -1 otherwise (pCard is not in the Hand).
	 * @pre pCard != null
	 * @pre this.aSize > 0
	 */
	public int contains(Card pCard) {
		assert pCard != null;
		assert this.aSize > 0;
		for (int i = 0; i < this.aSize; i++) {
			if ((this.aListOfCards.get(i).getRank() == pCard.getRank())
					&& (this.aListOfCards.get(i).getSuit() == pCard.getSuit())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @return true if the Hand has no Cards.
	 * @return false otherwise.
	 */
	public boolean isEmpty() {
		return this.aSize == 0;
	}

	/**
	 * @return the number of Cards in the Hand.
	 */
	public int size() {
		return this.aSize;
	}

	/**
	 * @return true if the Hand is full (has MAX_HAND_SIZE Cards).
	 * @return false otherwise.
	 */
	public boolean isFull() {
		return this.aSize == this.MAX_HAND_SIZE;
	}

	/**
	 * @return The list of Cards in the Hand.
	 * @pre The Hand is not empty.
	 */
	public List<Card> getCards() {
		assert this.aSize > 0;
		return new ArrayList<>(this.aListOfCards);
	}

	/**
	 * @return the number of Cards of pRank.
	 * @pre this.aSize != 0
	 * @pre pRank != null
	 */
	public int totalRank(Rank pRank) {
		assert this.aSize != 0;
		assert pRank != null;
		int totalRanks = 0;
		for (Card pCard : this)
			if (pCard.getRank() == pRank)
				totalRanks++;
		return totalRanks;
	}

	/**
	 * Computes the sum of the Rank of all Cards in the Hand.
	 * 
	 * @return int the total value of all the Cards in the Hand.
	 * @pre this.aSize != 0
	 */
	public int totalValue() {
		assert this.aSize != 0;
		int totalValue = 0;
		for (Card pCard : this.aListOfCards)
			totalValue += (pCard.getRank().ordinal() + 1);
		return totalValue;
	}

	/**
	 * Prints out to the screen the list of Cards in the Hand, in order.
	 * 
	 * @pre this.aSize > 0
	 */
	public void print() {
		assert this.aSize > 0;
		for (Card pCard : this) {
			System.out.println(pCard);
		}
	}

	/**
	 * Sorts the Hand in order (like a newly initialized Hand).
	 * 
	 * Suit order: Spades, Hearts, Clubs, Diamonds.
	 * 
	 * Rank order: Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack,
	 * Queen, King.
	 * 
	 * @pre this.aSize > 0
	 */
	public void sort() {
		assert this.aSize > 0;
		Collections.sort(this.aListOfCards);
	}

	/**
	 * Sorts the Hand in order (like a newly initialized Hand).
	 * 
	 * Order is specified by the given Comparator<Card>.
	 * 
	 * @pre this.aSize > 0
	 * @pre pComparator != null
	 */
	public void sort(Comparator<Card> pComparator) {
		assert this.aSize > 0;
		assert pComparator != null;
		Collections.sort(this.aListOfCards, pComparator);
	}

	/**
	 * Shuffles the Cards of the Deck in a random order.
	 * 
	 * @pre this.aSize > 0
	 */
	public void shuffle() {
		assert this.aSize > 0;
		Collections.shuffle(this.aListOfCards);
	}

	/**
	 * Compares Hands by increasing number of Cards in the Hand.
	 * 
	 * @pre this != null
	 * @pre pHand != null
	 */
	public int compareTo(Hand pHand) {
		assert this != null;
		assert pHand != null;
		return this.aSize - pHand.aSize;
	}

	/**
	 * @return Iterator<Card> an iterator for the list of Cards of the Deck.
	 */
	@Override
	public Iterator<Card> iterator() {
		return this.aListOfCards.iterator();
	}

	/*****************************************************************************
	 * 
	 * Static Factory Methods to Return Comparators
	 * 
	 *****************************************************************************/

	public static Comparator<Hand> BY_LENGTH_COMPARATOR = ByLengthComparator();
	public static Comparator<Hand> BY_TOTAL_VALUE_THEN_SIZE_COMPARATOR = ByTotalValueThenSizeComparator();
	public static Comparator<Hand> BY_TOTAL_VALUE_COMPARATOR = ByTotalValueComparator();
	public static Comparator<Hand> BY_REVERSE_TOTAL_VALUE_COMPARATOR = ByReverseTotalValueComparator();
	public static Comparator<Hand> BY_REVERSE_LENGTH_COMPARATOR = ByReverseLengthComparator();

	/**
	 * Compares by Hand.aSize only.
	 */
	private static Comparator<Hand> ByLengthComparator() {
		return new Comparator<Hand>() {
			/**
			 * @return -1 if the first Hand comes before the second Hand.
			 * @return 0 if the first Hand is the same Card as the second Hand.
			 * @return 1 if the first Hand comes after the second Hand.
			 * @pre pHand1 != null
			 * @pre pHand2 != null
			 */
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				assert pHand1 != null;
				assert pHand2 != null;
				return pHand1.aSize - pHand2.aSize;
			}
		};
	}

	/**
	 * Compares by Hand.totalValue() only.
	 */
	private static Comparator<Hand> ByTotalValueComparator() {
		return new Comparator<Hand>() {
			/**
			 * @return -1 if the first Hand comes before the second Hand.
			 * @return 0 if the first Hand is the same Card as the second Hand.
			 * @return 1 if the first Hand comes after the second Hand.
			 * @pre pHand1 != null
			 * @pre pHand2 != null
			 */
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				assert pHand1 != null;
				assert pHand2 != null;
				return pHand1.totalValue() - pHand2.totalValue();
			}
		};
	}

	/**
	 * Compares by Hand.totalValue() first.
	 * 
	 * Then compares by Hand.aSize.
	 */
	private static Comparator<Hand> ByTotalValueThenSizeComparator() {
		return new Comparator<Hand>() {
			/**
			 * @return -1 if the first Hand comes before the second Hand.
			 * @return 0 if the first Hand is the same Card as the second Hand.
			 * @return 1 if the first Hand comes after the second Hand.
			 * @pre pHand1 != null
			 * @pre pHand2 != null
			 */
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				assert pHand1 != null;
				assert pHand2 != null;
				if (pHand1.totalValue() == pHand2.totalValue())
					return pHand1.aSize - pHand2.aSize;
				else
					return pHand1.totalValue() - pHand2.totalValue();
			}
		};
	}

	/**
	 * Compares by Hand.aSize only.
	 */
	private static Comparator<Hand> ByReverseLengthComparator() {
		return new Comparator<Hand>() {
			/**
			 * @return -1 if the first Hand comes before the second Hand.
			 * @return 0 if the first Hand is the same Card as the second Hand.
			 * @return 1 if the first Hand comes after the second Hand.
			 * @pre pHand1 != null
			 * @pre pHand2 != null
			 */
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				assert pHand1 != null;
				assert pHand2 != null;
				return pHand2.aSize - pHand1.aSize;
			}
		};
	}

	/**
	 * Compares by Hand.totalValue() only.
	 */
	private static Comparator<Hand> ByReverseTotalValueComparator() {
		return new Comparator<Hand>() {
			/**
			 * @return -1 if the first Hand comes before the second Hand.
			 * @return 0 if the first Hand is the same Card as the second Hand.
			 * @return 1 if the first Hand comes after the second Hand.
			 * @pre pHand1 != null
			 * @pre pHand2 != null
			 */
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				assert pHand1 != null;
				assert pHand2 != null;
				return pHand2.totalValue() - pHand1.totalValue();
			}
		};
	}

	/**
	 * Compares by the number of Cards with the right Rank.
	 */
	public static Comparator<Hand> ByRankOccurrencesComparator(Rank pRank) {
		return new Comparator<Hand>() {
			/**
			 * @return -1 if the first Hand comes before the second Hand.
			 * @return 0 if the first Hand is the same Card as the second Hand.
			 * @return 1 if the first Hand comes after the second Hand.
			 * @pre pHand1 != null
			 * @pre pHand2 != null
			 */
			@Override
			public int compare(Hand pHand1, Hand pHand2) {
				assert pHand1 != null;
				assert pHand2 != null;
				return pHand1.totalRank(pRank) - pHand2.totalRank(pRank);
			}
		};
	}

	/*****************************************************************************
	 * 
	 * Static UniversalComparator Class
	 * 
	 *****************************************************************************/

	public static class UniversalComparator implements Comparator<Hand> {

		public enum Order {
			INCREASING, DECREASING
		}

		private Order aOrder;

		/**
		 * Default constructor for UniversalComparator.
		 */
		UniversalComparator() {
			this.aOrder = Order.INCREASING;
		}

		/**
		 * Custom constructor for UniversalComparator.
		 * 
		 * @param pOrder the Order of comparison.
		 * @pre pOrder != null
		 */
		UniversalComparator(Order pOrder) {
			assert pOrder != null;
			this.aOrder = pOrder;
		}

		/**
		 * @param pOrder the Order of comparison.
		 * @pre pOrder != null
		 */
		public void setOrder(Order pOrder) {
			assert pOrder != null;
			this.aOrder = pOrder;
		}

		@Override
		public int compare(Hand pHand1, Hand pHand2) {
			if (this.aOrder == Order.INCREASING)
				return (pHand1.aSize - pHand2.aSize);
			else
				return (pHand2.aSize - pHand1.aSize);
		}

	}
}
