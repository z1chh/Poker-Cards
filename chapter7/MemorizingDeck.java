package chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemorizingDeck extends Deck {
	private final List<Card> aDrawnCards = new ArrayList<>();
	
	MemorizingDeck() {
		super();
	}
	
	MemorizingDeck(Card...cards) {
		super(cards);
	}
	
	@Override
	public Card draw() {
		Card toReturn = super.draw();
		aDrawnCards.add(toReturn);
		return toReturn;
	}
	
	@Override
	public void clear() {
		super.clear();
		aDrawnCards.clear();
	}
	
	@Override
	public int size() {
		return super.size() + aDrawnCards.size();
	}
	
	@Override
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		for(int i = 0; i < aDrawnCards.size(); i++) {
			if(!this.aDrawnCards.get(i).equals(((MemorizingDeck) o).aDrawnCards.get(i))) return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode() + Objects.hash(aDrawnCards));
	}
}
