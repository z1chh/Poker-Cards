package deletation;

public class Concert extends AbstractShow
{
	private String aPerformer;
	
	public Concert(String pTitle, String pPerformer, int pTime)
	{
		super(pTitle, pTime);
		aPerformer = pPerformer;
	}

	@Override
	public String extraDescription()
	{
		return String.format("by %s", aPerformer);
	}
	
	public String getPerformer() {
		return this.aPerformer;
	}

	@Override
	public AbstractShow clone() {
		return new Concert(this.title(), this.aPerformer, this.time());
	}
}
