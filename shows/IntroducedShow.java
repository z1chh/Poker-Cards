package shows;

import java.util.Objects;

public class IntroducedShow implements Show {
	private final String aSpeaker;
	private final int aTime;
	private final Show aShow;
	
	public IntroducedShow(String pSpeaker, int pTime, Show pShow) {
		assert pSpeaker != null && pTime >= 0 && pShow != null;
		aSpeaker = pSpeaker;
		aTime = pTime;
		aShow = pShow;
	}

	@Override
	public String getDescription() {
		return aShow.getDescription() + " introduced by " + aSpeaker;
	}

	@Override
	public int getTime() {
		return aShow.getTime() + aTime;
	}

	@Override
	public Show copy() {
		return new IntroducedShow(aSpeaker, aTime, aShow.copy());
	}
	
	@Override
	public boolean equals(Object pObject) {
		if(pObject == null) return false;
		else if(pObject == this) return true;
		else if(this.getClass() != pObject.getClass()) return false;
		else {
			return aSpeaker == ((IntroducedShow)pObject).aSpeaker && aTime == ((IntroducedShow)pObject).aTime && aShow.equals(((IntroducedShow)pObject).aShow);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aSpeaker, aTime) + aShow.hashCode();
	}
}
