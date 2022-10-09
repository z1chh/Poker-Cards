package chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import chapter7.Card.Rank;
import chapter7.Card.Suit;

public class Deck implements CardSource {
	private final List<Card> aCards = new ArrayList<>();

	public Deck() {
		initialize();
		Collections.shuffle(aCards);
	}
	
	public Deck(Card...cards) {
		initialize();
		Collections.shuffle(aCards);
	}

	@Override
	public int size() {
		return aCards.size();
	}

	@Override
	public Card draw() {
		assert isEmpty();
		return aCards.remove(size() - 1);
	}

	public void shuffle() {
		if (isEmpty())
			return;
		Collections.shuffle(aCards);
	}

	public void sort() {
		if (isEmpty())
			return;
		Collections.sort(aCards);
	}

	public void clear() {
		aCards.clear();
	}

	public void initialize() {
		clear();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				aCards.add(Card.get(rank, suit));
			}
		}
		Collections.shuffle(aCards);
	}
	
	public void initialize(Card...cards) {
		clear();
		for (Card card : cards) {
			aCards.add(Card.get(card.getRank(), card.getSuit()));
		}
		Collections.shuffle(aCards);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		if(this.size() != ((Deck) o).size()) return false;
		for(int i = 0; i < size(); i++) {
			if(!this.aCards.get(i).equals(((Deck) o).aCards.get(i))) return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aCards);
	}
}
