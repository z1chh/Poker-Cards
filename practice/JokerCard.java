package practice;

import java.util.Optional;

public class JokerCard {
	public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
	
	public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}
	
	public enum Joker {BIGJOKER, SMALLJOKER}
	
	private final Optional<Rank> aRank;
	private final Optional<Suit> aSuit;
	private final Optional<Joker> aJoker;
	private final boolean isJoker;
	
	public JokerCard(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		this.aRank = Optional.of(pRank);
		this.aSuit = Optional.of(pSuit);
		this.aJoker = Optional.empty();
		this.isJoker = false;
	}
	
	public JokerCard(Joker pJoker) {
		assert pJoker != null;
		this.aJoker = Optional.of(pJoker);
		this.aRank = Optional.empty();
		this.aSuit = Optional.empty();
		this.isJoker = true;
	}
	
	public Rank getRank() {
		assert !this.isJoker;
		return this.aRank.get();
	}
	
	public Suit getSuit() {
		assert !this.isJoker;
		return this.aSuit.get();
	}
	
	public Joker getJoker() {
		assert this.isJoker;
		return this.aJoker.get();
	}
}
