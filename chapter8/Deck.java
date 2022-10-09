package chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import chapter8.Card.Rank;
import chapter8.Card.Suit;

/**
 * Represents a deck of playing cards. In this version, the cards in the deck
 * are stored in a list and the list of cards in the deck can be obtained by
 * client code using an immutable wrapper object.
 */
public class Deck implements DeckModel {
	private final List<Card> aCards = new ArrayList<>();
	
	private final List<DeckObserver> aObservers = new ArrayList<>();
	private Optional<Card> aLastDrawnCard = Optional.empty();
	private Optional<Card> aLastPushedCard = Optional.empty();
	
	public void addObserver(DeckObserver pObserver) {
		this.aObservers.add(pObserver);
	}
	
	public void removeObserver(DeckObserver pObserver) {
		if(this.aObservers.contains(pObserver)) this.aObservers.remove(pObserver);
	}

	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck() {
		shuffle();
	}
	
	public int size() {
		return this.aCards.size();
	}

	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle() {
		aCards.clear();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				aCards.add(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
		
		aLastDrawnCard = Optional.empty();
		aLastPushedCard = Optional.empty();
		for(DeckObserver observer: this.aObservers) observer.deckShuffled(this);
	}

	/**
	 * Places pCard on top of the deck.
	 * 
	 * @param pCard The card to place on top of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard) {
		assert pCard != null;
		aCards.add(pCard);
		
		this.aLastPushedCard = Optional.of(pCard);
		for(DeckObserver observer: this.aObservers) observer.cardPushed(this);
	}

	/**
	 * Draws a card from the deck: removes the card from the top of the deck and
	 * returns it.
	 * 
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw() {
		assert !isEmpty();
		Card card = aCards.remove(aCards.size() - 1);
		
		this.aLastDrawnCard = Optional.of(card);
		for(DeckObserver observer: this.aObservers) observer.cardDrawn(this);
		return card;
	}

	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty() {
		return aCards.isEmpty();
	}

	/**
	 * @return An unmodifiable list of all the cards in the deck.
	 */
	public List<Card> getCards() {
		return Collections.unmodifiableList(aCards);
	}

	@Override
	public Card getLastDrawnCard() {
		return this.aLastDrawnCard.get();
	}

	@Override
	public Card getLastPushedCard() {
		return this.aLastPushedCard.get();
	}
}
