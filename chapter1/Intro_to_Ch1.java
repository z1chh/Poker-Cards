package chapter1;

import java.util.Random;

public class Intro_to_Ch1 {
	
	/**
	 * @param pArgs Not used.
	 */
	public static void main(String[] pArgs) {
		System.out.println("Hello World!\nThis is Chapter 1!");
		int a = new Random().nextInt(13);
		System.out.println(a + " squared is " + power(a) + ".");
	}

	private static int power(int a) {
		return a*a;
	}
}
