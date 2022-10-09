package chapter3;

import java.util.ArrayList;
import java.util.List;

public interface CardSource extends Iterable<Card> {

	/**
	 * @return the Card drawn from the CardSource.
	 * @pre !this.isEmpty()
	 */
	public abstract Card draw();

	/**
	 * @return true if the CardSource has no Cards.
	 */
	public abstract boolean isEmpty();

	/**
	 * Draws a given number of Cards from the CardSource, if there is enough Cards.
	 * 
	 * Otherwise, draw until the CardSource is empty.
	 * 
	 * @param pCardSource The CardSource to draw from.
	 * @param pCards      the number of Cards to draw.
	 * @return List<Card> the list of Cards drawn from the CardSource.
	 * @pre !this.isEmpty()
	 * @pre pCards > 0
	 */
	public default List<Card> drawCards(int pCards) {
		assert (!this.isEmpty());
		assert pCards > 0;
		List<Card> pListOfCards = new ArrayList<>();
		for (int i = 0; (i < pCards) && (!this.isEmpty()); i++) {
			pListOfCards.add(this.draw());
		}
		return pListOfCards;
	}

	/**
	 * Prints out to the screen (output) the list of Cards in the CardSource.
	 */
	public void print();

	/**
	 * Prints out to the screen (output) pCards number of Cards in the CardSource.
	 * 
	 * @pre pCards > 0
	 */
	public void print(int pCards);
}
