package shows;

import java.util.Objects;

public class DoubleBill implements Show {
	private Movie aMovie1;
	private Movie aMovie2;

	DoubleBill(Movie pMovie1, Movie pMovie2) {
		assert pMovie1 != null && pMovie2 != null;
		aMovie1 = pMovie1;
		aMovie2 = pMovie2;
	}

	@Override
	public String getDescription() {
		return "Double bill presenting " + aMovie1.getDescription() + " followed by " + aMovie2.getDescription();
	}

	@Override
	public int getTime() {
		return aMovie1.getTime() + aMovie2.getTime();
	}

	@Override
	public Show copy() {
		return new DoubleBill((Movie) aMovie1.copy(), (Movie) aMovie2.copy());
	}
	
	@Override
	public boolean equals(Object pObject) {
		if(pObject == null) return false;
		else if(pObject == this) return true;
		else if(this.getClass() != pObject.getClass()) return false;
		else {
			return aMovie1.equals(((DoubleBill)pObject).aMovie1) && aMovie2.equals(((DoubleBill)pObject).aMovie2);
		}
	}
	
	@Override
	public int hashCode() {
		return aMovie1.hashCode() + aMovie2.hashCode();
	}
}
