package chapter2;

/**
 * EmptyDeckException is thrown whenever an action is executed on a Deck that must have at least one Card, but the Deck has no Card.
 *
 */
public class EmptyDeckException extends Exception
{
	public EmptyDeckException(String errorMessage)
	{
        super(errorMessage);
	}
}
