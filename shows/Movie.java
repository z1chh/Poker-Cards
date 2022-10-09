package shows;

import java.util.Objects;

public class Movie implements Show {
	private final String aTitle;
	private final int aTime;
	private final int aYear;
	
	Movie(String pDescription, int pTime, int pYear) {
		assert pDescription != null && pTime >= 0 && pYear > 0;
		aTitle = pDescription;
		aTime = pTime;
		aYear = pYear;
	}
	
	private Movie(Movie pMovie) {
		assert pMovie != null;
		aTitle = pMovie.aTitle;
		aTime = pMovie.aTime;
		aYear = pMovie.aYear;
	}

	@Override
	public String getDescription() {
		return String.format("[%s (%d): %d minutes]", aTitle, aYear, aTime);
	}

	@Override
	public int getTime() {
		return aTime;
	}
	
	@Override
	public String toString() {
		return getDescription();
	}

	@Override
	public Show copy() {
		return new Movie(this);
	}
	
	@Override
	public boolean equals(Object pObject) {
		if(pObject == null) return false;
		else if(pObject == this) return true;
		else if(this.getClass() != pObject.getClass()) return false;
		else {
			return aTitle == ((Movie)pObject).aTitle && aTime == ((Movie)pObject).aTime && aYear == ((Movie)pObject).aYear;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aTitle, aTime, aYear);
	}
}
