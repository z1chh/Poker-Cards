package chapter8;

public interface DeckModel {
	public void push(Card pCard);
	public Card draw();
	public int size();
	public Card getLastDrawnCard();
	public Card getLastPushedCard();
}
