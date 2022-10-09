package chapter8;

public class SizeStatus implements DeckObserver {
	@Override
	public void cardDrawn(DeckModel pModel) {
		System.out.println(String.format("A card has been drawn, the deck now has %d cards", pModel.size()));
	}

	@Override
	public void cardPushed(DeckModel pModel) {
		System.out.println(String.format("A card has been drawn, the deck now has %d cards", pModel.size()));
	}

	@Override
	public void deckShuffled(DeckModel pModel) {
		System.out.println(String.format("The deck has been shuffled, it now has %d cards", pModel.size()));
	}

}
