package chapter8;

public class DrawLogger implements DeckObserver {

	@Override
	public void cardDrawn(DeckModel pModel) {
		System.out.println(String.format("A card has been drawn: %s", pModel.getLastDrawnCard().toString()));
	}

	@Override
	public void cardPushed(DeckModel pModel) {	
	}

	@Override
	public void deckShuffled(DeckModel pModel) {
	}

}
