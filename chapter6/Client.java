package chapter6;

public class Client {
	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test1() {
		Concert c1 = new Concert("Concert", "Mozart", 60);
		Movie m1 = new Movie("Spider-man 1", 2000, 120);
		Movie m2 = new Movie("Spider-man 2", 2004, 122);
		CompositeShow cs1 = new CompositeShow(m1, m2);
		CompositeShow cs2 = new CompositeShow(c1, cs1);
	}

	public static void test2() {
		Concert c1 = new Concert("Concert", "Mozart", 60);
		Movie m1 = new Movie("Spider-man 1", 2000, 120);
		Movie m2 = new Movie("Spider-man 2", 2004, 122);
		IntroducedShow is1 = new IntroducedShow(m2, "Tom Holland", 5);
		CompositeShow cs1 = new CompositeShow(m1, is1);
		CompositeShow cs2 = new CompositeShow(c1, cs1);
		IntroducedShow is2 = new IntroducedShow(cs2, "Marvel", 15);
		System.out.println(is2.description());
		System.out.println(is2.time());
	}
}
