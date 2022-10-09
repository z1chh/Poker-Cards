package chapter6;

import java.util.Iterator;
import java.util.Objects;

public class DoubleBill implements Show, Iterable<Show> {
	private final Movie aMovie1;
	private final Movie aMovie2;
	
	public DoubleBill(Movie pMovie1, Movie pMovie2) {
		assert pMovie1 != null && pMovie1 != null;
		this.aMovie1 = pMovie1;
		this.aMovie2 = pMovie2;
	}

	@Override
	public String description() {
		return aMovie1.description() + " followed by " + aMovie2.description();
	}

	@Override
	public int time() {
		return aMovie1.time() + aMovie2.time();
	}

	@Override
	public Show copy() {
		return new DoubleBill((Movie) aMovie1.copy(), (Movie) aMovie2.copy());
	}

	@Override
	public Iterator<Show> iterator() {
		return new Iterator<Show>() {

			private int pos = 0;
			
			@Override
			public boolean hasNext() {
				return (this.pos == 1);
			}

			@Override
			public Show next() {
				if(this.pos == 0) {
					this.pos = 1;
					return aMovie1;
				}
				else return aMovie2;
			}
			
		};
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aMovie1, aMovie2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoubleBill other = (DoubleBill) obj;
		if (!aMovie1.equals(other.aMovie1))
			return false;
		if (!aMovie2.equals(other.aMovie2))
			return false;
		return true;
	}
}
