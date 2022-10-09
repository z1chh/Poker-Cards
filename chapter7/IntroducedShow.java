package chapter7;

public class IntroducedShow implements Show {
	private final AbstractShow aShow;
	private final String aIntroducer;
	private final int aIntroducingTime;
	
	IntroducedShow(AbstractShow pShow, String pIntroducer, int pIntroducingTime) {
		assert pShow != null && pIntroducer != null && pIntroducingTime >= 0;
		aShow = pShow;
		aIntroducer = pIntroducer;
		aIntroducingTime = pIntroducingTime;
	}
	
	@Override
	public String title() {
		return aShow.title();
	}

	@Override
	public String description() {
		return aShow.description() + " introduced by " + aIntroducer;
	}

	@Override
	public int time() {
		return aShow.time() + aIntroducingTime;
	}

}
