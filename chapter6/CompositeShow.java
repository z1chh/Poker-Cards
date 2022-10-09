package chapter6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CompositeShow implements Show, Iterable<Show> {
	private final List<Show> aShows = new ArrayList<>();

	public CompositeShow(Show... shows) {
		assert shows.length < 6 && shows.length > 1;
		for (Show show : shows) {
			assert show != null;
			this.aShows.add(show);
		}
	}

	@Override
	public String description() {
		String s = "";
		for (int i = 0; i < aShows.size(); i++) {
			s += aShows.get(i).description();
			if (i != aShows.size() - 1)
				s += " followed by ";
		}
		return s;
	}

	@Override
	public int time() {
		int time = 0;
		for (Show show : aShows) {
			time += show.time();
		}
		return time;
	}

	@Override
	public Show copy() {
		CompositeShow newShow = new CompositeShow();
		for (Show show : aShows) {
			newShow.aShows.add(show.copy());
		}
		return newShow;
	}

	@Override
	public Iterator<Show> iterator() {
		return this.aShows.iterator();
	}

	@Override
	public int hashCode() {
		return Objects.hash(aShows);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeShow other = (CompositeShow) obj;
		if (this.aShows.size() != other.aShows.size())
			return false;
		for (int i = 0; i < this.aShows.size(); i++) {
			if (!this.aShows.get(i).equals(other.aShows.get(i)))
				return false;
		}
		return true;
	}
}
