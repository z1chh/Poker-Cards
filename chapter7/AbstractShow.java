package chapter7;

public abstract class AbstractShow implements Show {
	private String aTitle;
	private int aTime;

	protected AbstractShow(String pTitle, int pTime) {
		this.aTitle = pTitle;
		this.aTime = pTime;
	}

	@Override
	public String title() {
		return aTitle;
	}

	@Override
	public int time() {
		return aTime;
	}

	@Override
	public final String description() {
		return String.format("%s [%s] (%d minutes)", aTitle.toUpperCase(), extraDescription(), aTime);
	}

	protected abstract String extraDescription();
}
