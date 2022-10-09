package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter3.Card.Rank;
import chapter3.Card.Suit;
import chapter3.Hand.UniversalComparator;
import chapter3.Hand.UniversalComparator.Order;

public final class Client {
	public static void main(String[] args) {
		// Testing the Deck default constructor and the Deck.sort() method.
		// Testing the @Override of toString().
		test1();

		// Testing the Deck parameterized constructors using CardConfigurators.
		// Testing the Card Comparators.
		test2();

		// Testing the Hand constructor and the Hand.addCard(Card) method when the Hand
		// has
		// its maximum number of Cards.
		test3();

		// Testing the CardSource.drawCards(int) method and the Hand.addCard() method.
		test4();

		// Testing the Hand class' comparators (from static factory methods) and the
		// UniversalComparator.
		test5();

		// Testing Deck.getSize(), Deck.hasCard(), Deck.print(int) and Deck.draw().
		test6();
	}

	public static void newTest(int i) {
		System.out.println("==================================================================================");
		System.out.println("Initializing Test " + i + "...\n\n");
	}

	public static void endTest(int i) {
		System.out.println("\n\nTest " + i + " completed.");
		System.out.println(
				"==================================================================================\n\n\n\n\n");
	}

	public static void test1() {
		// Testing the Deck default constructor and the Deck.sort() method.
		// Testing the @Override of toString().
		newTest(1);
		System.out.println("Creating a standard Deck using the default constructor...");
		Deck Standard = new Deck();
		System.out.println(
				"Deck Standard (Standard Cards Deck with " + Standard.size() + " Cards) has the following Cards:");
		Standard.print();

		System.out.println("\nSorting the Deck Standard (Standard Cards Deck).");
		System.out.println(
				"Deck Standard (Standard Cards Deck with " + Standard.size() + " Cards) has the following Cards:");
		Standard.sort();
		System.out.print(Standard);
		endTest(1);
	}

	public static void test2() {
		// Testing the Deck parameterized constructors using CardConfigurators.
		// Testing the Card Comparators.
		newTest(2);
		System.out.println("Using the CardConfigurator constructor.");
		Deck RedFaces = new Deck(new RedFacesConfigurator());
		System.out.println(
				"Deck RedFaces (Red Face Cards Deck with " + RedFaces.size() + " Cards) has the following Cards:");
		RedFaces.print();

		System.out.println("\nSorting the Deck RedFaces (Red Face Cards Deck) by Void.");
		System.out.println(
				"Deck RedFaces (Red Face Cards Deck with " + RedFaces.size() + " Cards) has the following Cards:");
		RedFaces.sort(new Card.VoidComparator());
		RedFaces.print();

		System.out.println("\nSorting the Deck RedFaces (Red Face Cards Deck) by Suit.");
		System.out.println(
				"Deck RedFaces (Red Face Cards Deck with " + RedFaces.size() + " Cards) has the following Cards:");
		RedFaces.sort(new Card.BySuitComparator());
		RedFaces.print();

		System.out.println("\n\nUsing the CardConfigurator constructor.");
		Deck BlackNumbers = new Deck(new BlackNumbersConfigurator());
		System.out.println("Deck BlackNumbers (Black Number Cards Deck with " + BlackNumbers.size()
				+ " Cards) has the following Cards:");
		BlackNumbers.print();

		System.out.println("\nSorting the Deck BlackNumbers (Black Number Cards Deck) by Rank.");
		System.out.println("Deck BlackNumbers (Black Number Cards Deck with " + BlackNumbers.size()
				+ " Cards) has the following Cards:");
		BlackNumbers.sort(new Card.ByRankComparator());
		BlackNumbers.print();

		System.out.println("\n\nUsing the CardConfigurator constructor.");
		Deck BlackFaces = new Deck(new BlackFacesConfigurator());
		System.out.println("Deck BlackFaces (Black Face Cards Deck with " + BlackFaces.size()
				+ " Cards) has the following Cards:");
		BlackFaces.print();

		System.out.println("\nSorting the Deck BlackFaces (Black Face Cards Deck) by Reverse.");
		System.out.println("Deck BlackFaces (Black Face Cards Deck with " + BlackFaces.size()
				+ " Cards) has the following Cards:");
		BlackFaces.sort(new Card.ByReverseComparator());
		BlackFaces.print();

		System.out.println("\nShuffling the Deck BlackFaces (Black Face Cards Deck).");
		System.out.println("Deck BlackFaces (Black Face Cards Deck with " + BlackFaces.size()
				+ " Cards) has the following Cards:");
		BlackFaces.shuffle();
		BlackFaces.print();

		System.out.println("\nSorting the Deck BlackFaces (Black Face Cards Deck) by ReverseRank.");
		System.out.println("Deck BlackFaces (Black Face Cards Deck with " + BlackFaces.size()
				+ " Cards) has the following Cards:");
		BlackFaces.sort(new Card.ByReverseRankComparator());
		BlackFaces.print();
		endTest(2);
	}

	public static void test3() {
		// Testing the Hand constructor and the Hand.addCard(Card) method when the Hand
		// has
		// its maximum number of Cards.
		newTest(3);
		Hand h1 = new Hand(14);
		int forSuits = 0;
		int loop = 0;
		try {
			while (true) {
				h1.addCard(new Card(Rank.values()[loop], Suit.values()[forSuits]));
				if (++loop > 12)
					loop -= 13;
				if (++forSuits > 3)
					forSuits -= 4;
			}
		} catch (AssertionError e) {
		}
		System.out.println("Creating a new Hand h1.");
		System.out.println("Hand h1 has the following " + h1.size() + " Cards:");
		h1.print();
		endTest(3);
	}

	public static void test4() {
		// Testing the CardSource.drawCards(int) method and the Hand.addCard() method.
		newTest(4);
		Deck Standard = new Deck();
		List<Card> list = Standard.drawCards(10);
		Hand h2 = new Hand(10);
		for (int i = 0; i < h2.MAX_HAND_SIZE; i++) {
			h2.addCard(list.get(i));
		}
		System.out.println("Creating a new Hand h2.");
		System.out.println("Hand h2 has the following " + h2.size() + " Cards:");
		h2.print();
		endTest(4);
	}

	public static void test5() {
		// Testing the Hand class' comparators (from static factory methods) and the
		// UniversalComparator.
		newTest(5);
		Hand h1 = new Hand(14);
		int forSuits = 0;
		int loop = 0;
		try {
			while (true) {
				h1.addCard(new Card(Rank.values()[loop], Suit.values()[forSuits]));
				if (++loop > 12)
					loop -= 13;
				if (++forSuits > 3)
					forSuits -= 4;
			}
		} catch (AssertionError e) {
		}

		Deck Standard = new Deck();
		List<Card> list = Standard.drawCards(10);
		Hand h2 = new Hand(10);
		for (int i = 0; i < h2.MAX_HAND_SIZE; i++) {
			h2.addCard(list.get(i));
		}

		System.out.println("Creating a list of Hands listOfHands containing h1 and h2...");
		System.out.println("Hand h1 has the following object reference:" + h1 + ".");
		System.out.println("Hand h2 has the following object reference:" + h2 + ".");
		List<Hand> listOfHands = new ArrayList<>();
		listOfHands.add(h1);
		listOfHands.add(h2);

		System.out.println("The first hand is:" + listOfHands.get(0) + ".");
		System.out.println("Sorting listOfHands by Rank occurrences of Aces...");
		System.out.println("The Hand h1 has " + h1.totalRank(Rank.ACE) + " Aces.");
		System.out.print("The Hand h2 has ");
		if (h2.totalRank(Rank.ACE) > 1)
			System.out.println(h2.totalRank(Rank.ACE) + " Aces.");
		else if (h2.totalRank(Rank.ACE) == 0)
			System.out.println("no Aces.");
		else
			System.out.println("1 Ace.");
		Collections.sort(listOfHands, Hand.ByRankOccurrencesComparator(Rank.ACE));
		System.out.println("The first hand is:" + listOfHands.get(0) + ".");

		System.out.println("\n\nComparing h1 and h2 with the UniversalComparator...");
		UniversalComparator comparator = new UniversalComparator();
		System.out.println(
				"The difference of Cards between h1 and h2 (increasing) is: " + comparator.compare(h1, h2) + ".");
		comparator.setOrder(Order.DECREASING);
		System.out.println(
				"The difference of Cards between h1 and h2 (decreasing) is: " + comparator.compare(h1, h2) + ".");

		System.out.println("\n\nThe first hand is:" + listOfHands.get(0) + ".");
		System.out.println("The total value of the first Hand is " + listOfHands.get(0).totalValue() + ".");
		System.out.println("The total value of the second Hand is " + listOfHands.get(1).totalValue() + ".");
		System.out.println("Sorting listOfHands by total value...");
		Collections.sort(listOfHands, Hand.BY_TOTAL_VALUE_COMPARATOR);
		System.out.println("The first hand is:" + listOfHands.get(0) + ".");
		System.out.println("The total value of the first Hand is " + listOfHands.get(0).totalValue() + ".");
		System.out.println("The total value of the second Hand is " + listOfHands.get(1).totalValue() + ".");
		endTest(5);
	}

	public static void test6() {
		// Testing Deck.getSize(), Deck.hasCard(), Deck.print(int) and Deck.draw().
		newTest(6);
		Deck Standard = new Deck();
		System.out.println("The Standard Deck has " + Standard.size() + " Cards.");
		Card next = Standard.nextCard();
		System.out.println("The next Card in the Standard Deck is: " + next + ".");
		System.out.println("The Standard Deck has the " + next + " Card: " + Standard.hasCard(next) + ".");

		System.out.println("\nDrawing one Card from the Standard Deck...");
		Card c1 = Standard.draw();
		System.out.println("The Card drawn is: " + c1 + ".");
		System.out.println("The Standard Deck has " + Standard.size() + " Cards.");
		System.out.println("The Standard Deck has the " + next + " Card: " + Standard.hasCard(next) + ".");

		System.out.println("\n\nThe Standard Deck has " + Standard.size() + " Cards.");
		System.out.println("The next 5 Cards in the Standard Deck are:");
		Standard.print(5);
		System.out.println("The Standard Deck has " + Standard.size() + " Cards.");
		endTest(6);
	}
}
