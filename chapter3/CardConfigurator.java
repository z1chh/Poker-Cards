package chapter3;

public interface CardConfigurator {

	/**
	 * @param pCard The Card to check its validity.
	 * @return whether the Card respects the CardConfigurator.
	 * @pre pCard != null;
	 */
	abstract boolean isValid(Card pCard);

}