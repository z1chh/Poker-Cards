package deletation;

public class Movie extends AbstractShow
{
	private int aYear;
	
	public Movie(String pTitle, int pYear, int pTime)
	{
		super(pTitle, pTime);
		aYear = pYear;
	}

	@Override
	public String extraDescription()
	{
		return String.format("%d", aYear);
	}
	
	@Override
	public void setTitle(String pTitle) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Movie clone() {
		return new Movie(this.title(), this.aYear, this.time());
	}
}
