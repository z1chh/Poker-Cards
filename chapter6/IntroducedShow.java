package chapter6;

import java.util.Objects;

public class IntroducedShow implements Show {
	private final Show aShow;
	private final String aSpeaker;
	private final int aSpeakerTime;

	public IntroducedShow(Show pShow, String pSpeaker, int pSpeakerTime) {
		assert pShow != null && pSpeaker != null && pSpeakerTime >= 0;
		this.aShow = pShow;
		this.aSpeaker = pSpeaker;
		this.aSpeakerTime = pSpeakerTime;
	}

	@Override
	public String description() {
		return this.aShow.description() + " introduced by " + aSpeaker;
	}

	@Override
	public int time() {
		return this.aShow.time() + this.aSpeakerTime;
	}

	@Override
	public Show copy() {
		return new IntroducedShow(this.aShow.copy(), this.aSpeaker, this.aSpeakerTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aShow, aSpeaker, aSpeakerTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntroducedShow other = (IntroducedShow) obj;
		if (!aShow.equals(other.aShow))
			return false;
		if (!aSpeaker.equals(other.aSpeaker))
			return false;
		return aSpeakerTime == other.aSpeakerTime;
	}
}
