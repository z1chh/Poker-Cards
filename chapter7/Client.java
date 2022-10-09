package chapter7;

public class Client {
	public static void main(String[] args) {
		Movie m1 = new Movie("Spiderman", 2000, 120);
		System.out.println(m1.description());
		System.out.println(m1.time());
	}
}
