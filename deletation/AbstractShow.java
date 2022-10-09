package deletation;

public abstract class AbstractShow implements Show {
	private String aTitle;
	private int aTime;
	
	public AbstractShow(String pTitle, int pTime)
	{
		this.aTitle = pTitle;
		this.aTime = pTime;
	}
	
	public final String title()
	{
		return aTitle;
	}
	
	public void setTitle(String pTitle)
	{
		aTitle = pTitle;
	}
	
	@Override
	public int time()
	{
		return aTime;
	}
	
	protected final void setTime(int pTime)
	{
		aTime = pTime;
	}
	
	@Override
	public final String description()
	{
		return String.format("%s [%s] (%d minutes)", aTitle.toUpperCase(), extraDescription(), this.aTime);
	}
	
	protected abstract String extraDescription();
	
	public abstract AbstractShow clone();
}
