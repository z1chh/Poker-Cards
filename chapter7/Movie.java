package chapter7;

public class Movie extends AbstractShow {
	private int aYear;

	public Movie(String pTitle, int pYear, int pTime) {
		super(pTitle, pTime);
		aYear = pYear;
	}

	@Override
	public String extraDescription() {
		return String.format("%d", aYear);
	}
}