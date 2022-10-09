package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import practice.Card.Rank;
import practice.Card.Suit;

public class Deck implements Iterable<Card> {

	private final List<Card> aCards = new ArrayList<>();
	
	public Deck() {
		initialize();
	}
	
	public Deck(CardValidator pCardValidator) {
		initialize(pCardValidator);
	}
	
	private void initialize() {
		for(Rank rank: Rank.values()) {
			for(Suit suit: Suit.values()) {
				this.aCards.add(Card.get(rank, suit));
			}
		}
		Collections.shuffle(this.aCards);
	}
	
	private void initialize(CardValidator pCardValidator) {
		for(Rank rank: Rank.values()) {
			for(Suit suit: Suit.values()) {
				Card toAdd = Card.get(rank, suit);
				if(pCardValidator.isValid(toAdd)) {
					this.aCards.add(toAdd);
				}
			}
		}
		Collections.shuffle(this.aCards);
	}
	
	public void sort() {
		Collections.sort(this.aCards);
	}
	
	public void shuffle() {
		Collections.shuffle(this.aCards);
	}
	
	public void reset() {
		initialize();
	}
	
	public void reset(CardValidator pCardValidator) {
		initialize(pCardValidator);
	}
	
	public int size() {
		return this.aCards.size();
	}

	@Override
	public Iterator<Card> iterator() {
		return this.aCards.iterator();
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		for(Card card: this) {
			toReturn += String.format("%s\n", card);
		}
		return toReturn;
	}
}
