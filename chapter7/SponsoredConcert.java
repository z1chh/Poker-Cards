package chapter7;

public class SponsoredConcert extends Concert {
	private final String aSponsor;
	private final int aSponsorTime;
	public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsor, int pSponsorTime) {
		super(pTitle, pPerformer, pTime);
		aSponsor = pSponsor;
		aSponsorTime = pSponsorTime;
	}
	
	@Override
	public String extraDescription() {
		return super.extraDescription() + " sponsored by " + aSponsor;
	}
	
	@Override
	public int time() {
		return super.time() + aSponsorTime;
	}
	
}
