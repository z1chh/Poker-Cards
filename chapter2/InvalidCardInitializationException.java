package chapter2;

/**
 * InvalidCardInitializationException is thrown whenever a Card with an invalid Rank or Suit is being initialized.
 *
 */
public class InvalidCardInitializationException extends Exception
{
	public InvalidCardInitializationException(String errorMessage)
	{
        super(errorMessage);
	}
}