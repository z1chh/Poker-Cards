package practice;

import practice.JokerCard.Joker;
import practice.JokerCard.Rank;

public class Client {
	public static void main(String[] args) {
		/*Deck d1 = new Deck(new DefaultValidator());
		int d1size = d1.size();
		int test = 0;
		System.out.println("Unsorted deck d1:");
		System.out.println(d1);
		
		System.out.println("Sorted deck d1:");
		d1.sort();
		for(Card card: d1) {
			System.out.println(card);
			test++;
		}
		if(d1size != test) {
			System.out.println("Error: size mismatch. Something went wrong");
		} else {
			System.out.println(String.format("Deck d1 has size : %d.", test));
		}*/
		JokerCard j = new JokerCard(Joker.BIGJOKER);
		Rank r = j.getRank();
		System.out.println(r);
	}
}
