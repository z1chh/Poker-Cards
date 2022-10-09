package chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck class.
 * Represents a valid Deck.
 */
public class Deck
{
	/*public static void main(String[] args) throws Exception
	{
		Deck d1 = new Deck();
		String c1 = d1.aListOfCards.get(0).toString();
		String c2 = d1.aListOfCards.get(1).toString();
		System.out.println(c1 + "\n" + c2);
		d1.shuffle();
		c1 = d1.aListOfCards.get(0).toString();
		c2 = d1.aListOfCards.get(1).toString();
		System.out.println(c1 + "\n" + c2);
		System.out.println(d1.isEmpty());
		System.out.println(d1.aSize);
		Card card1 = d1.draw();
		System.out.println(card1.toString());
		System.out.println(d1.aSize);
		Card card2 = d1.draw();
		System.out.println(card2.toString());
		System.out.println(d1.aSize);
		d1.clear();
		System.out.println(d1.aSize);
		System.out.println(d1.isEmpty());
		d1.populate();
		c1 = d1.aListOfCards.get(0).toString();
		c2 = d1.aListOfCards.get(1).toString();
		System.out.println(c1 + "\n" + c2);
		d1.shuffle();
		c1 = d1.aListOfCards.get(0).toString();
		c2 = d1.aListOfCards.get(1).toString();
		System.out.println(c1 + "\n" + c2);
	}*/
	private List<Card> aListOfCards;
	private int aSize;
	public static final int MAX_CARDS = 52;
	
	public Deck() throws Exception
	{
		this.aSize = MAX_CARDS;
		this.aListOfCards = new ArrayList<>();
		for(Suit pSuit: Suit.values())
		{
			for(Rank pRank: Rank.values())
			{
				this.aListOfCards.add(new Card(pRank, pSuit));
			}
		}
	}
	
	/**
	 * Getter method to get the list of Cards in the Deck.
	 * Note that this method assumes an object of type Card is immutable.
	 * @return a shallow copy of aListOfCards.
	 * @throws EmptyDeckException if the Deck contains no Cards.
	 */
	public ArrayList<Card> getCards() throws EmptyDeckException
	{
		if(this.isEmpty()) throw new EmptyDeckException("The Deck is empty and has no Cards in it.");
		return new ArrayList<>(this.aListOfCards);
	}
	
	/**
	 * Deck method to clear the Deck of all Cards.
	 */
	public void clear() throws EmptyDeckException
	{
		this.aListOfCards = new ArrayList<>();
		this.aSize = 0;
	}
	
	/**
	 * Re-populates an empty Deck with the standard 52 playing Cards, in order.
	 * @return false if the Deck is not empty, and does not populate it.
	 * @throws Exception if an invalid Card is added (will not happen).
	 */
	public boolean populate() throws Exception
	{
		if(!this.isEmpty()) return false;
		this.aSize = MAX_CARDS;
		this.aListOfCards = new ArrayList<>();
		for(Suit pSuit: Suit.values())
		{
			for(Rank pRank: Rank.values())
			{
				this.aListOfCards.add(new Card(pRank, pSuit));
			}
		}
		return true;
	}
	
	/**
	 * Method to check whether a Deck is empty or not.
	 * @return whether the Deck is empty or not.
	 */
	public boolean isEmpty()
	{
		return this.aSize == 0;
	}
	
	/**
	 * Deck method to shuffle a non-empty Deck.
	 * @throws EmptyDeckException if the Deck is empty.
	 */
	public void shuffle() throws EmptyDeckException
	{
		if(this.aSize == 0) throw new EmptyDeckException("The Deck is empty and cannot be shuffled.");
		if(this.aSize != 1) Collections.shuffle(aListOfCards);
	}
	
	public Card draw() throws EmptyDeckException
	{
		if(this.isEmpty()) throw new EmptyDeckException("Deck is empty.");
		else
		{
			this.aSize = this.aSize - 1;
			return this.aListOfCards.remove(0);
		}
	}
}
