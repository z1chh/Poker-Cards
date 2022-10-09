package chapter8;

public interface DeckObserver {
	public void cardDrawn(DeckModel pModel);
	
	public void cardPushed(DeckModel pModel);
	
	public void deckShuffled(DeckModel pModel);
}
