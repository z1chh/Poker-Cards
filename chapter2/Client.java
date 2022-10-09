package chapter2;

public final class Client
{
	/**
	 * @param args Not used.
	 */
	public static void main(String[] args)
	{
		Card c1 = new Card(Rank.ACE, Suit.CLUBS);
		System.out.println(c1);
		System.out.println(new Card(null, Suit.CLUBS));
	}
}
