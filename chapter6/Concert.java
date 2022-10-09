package chapter6;

import java.util.Objects;

public class Concert implements Show {
	private String aTitle;
	private String aPerformer;
	private int aTime;

	/**
	 * @param pTitle     The title of the concert
	 * @param pPerformer The name of the artist or orchestra performing
	 * @param pTime      The running time of the concert.
	 */
	public Concert(String pTitle, String pPerformer, int pTime) {
		assert pTitle != null && pPerformer != null && pTime >= 0;
		aTitle = pTitle;
		aPerformer = pPerformer;
		aTime = pTime;
	}

	private Concert(Concert pConcert) {
		assert pConcert != null;
		aTitle = pConcert.aTitle;
		aPerformer = pConcert.aPerformer;
		aTime = pConcert.aTime;
	}

	@Override
	public String description() {
		return String.format("%s by %s", aTitle, aPerformer);
	}

	@Override
	public int time() {
		return aTime;
	}

	@Override
	public Show copy() {
		return new Concert(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aPerformer, aTime, aTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(aPerformer, other.aPerformer) && aTime == other.aTime
				&& Objects.equals(aTitle, other.aTitle);
	}
}
