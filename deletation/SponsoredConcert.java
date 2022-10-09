package deletation;

public class SponsoredConcert extends Concert {

	private final String aSponsor;
	private final int aSponsorTime;
	
	public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsor, int aSponsorTime) {
		super(pTitle, pPerformer, pTime);
		this.aSponsor = pSponsor;
		this.aSponsorTime = aSponsorTime;
	}
	
	@Override
	public String extraDescription()
	{
		return super.extraDescription() + String.format(" sponsored by %s", aSponsor);
	}
	
	@Override
	public int time()
	{
		return super.time() + aSponsorTime;
	}
	
	@Override
	public AbstractShow clone() {
		return new SponsoredConcert(this.title(), this.getPerformer(), this.time(), this.aSponsor, this.aSponsorTime);
	}
}
