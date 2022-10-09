package chapter7;

public class Concert extends AbstractShow {
	private String aPerformer;

	public Concert(String pTitle, String pPerformer, int pTime) {
		super(pTitle, pTime);
		aPerformer = pPerformer;
	}


	public String extraDescription() {
		return String.format("performed by %s", aPerformer);
	}
}
