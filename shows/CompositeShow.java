package shows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CompositeShow implements Show, Iterable<Show> {
	private final List<Show> aShows = new ArrayList<>();

	CompositeShow(Show ...shows) {
		assert shows.length >= 2 && shows.length <= 5;
		for(Show show: shows) {
			assert show != null;
			aShows.add(show);
		}
	}
	
	@Override
	public String getDescription() {
		String description = "[";
		for(Show show: aShows) {
			description += show.getDescription();
		}
		return description + "]";
	}

	@Override
	public int getTime() {
		int totalTime = 0;
		for(Show show: aShows) {
			totalTime += show.getTime();
		}
		return totalTime;
	}

	@Override
	public Iterator<Show> iterator() {
		return aShows.iterator();
	}

	@Override
	public Show copy() {
		CompositeShow toReturn = new CompositeShow();
		for(Show show: aShows) {
			toReturn.aShows.add(show.copy());
		}
		return toReturn;
	}
	
	@Override
	public boolean equals(Object pObject) {
		if(pObject == null) return false;
		else if(pObject == this) return true;
		else if(this.getClass() != pObject.getClass()) return false;
		else {
			if(aShows.size() != ((CompositeShow)pObject).aShows.size()) return false;
			for(int i = 0; i < aShows.size(); i++) {
				if(!aShows.get(i).equals(((CompositeShow)pObject).aShows.get(i))) return false;
			}
			return true;
		}
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		for(Show show: aShows) {
			hash += show.hashCode();
		}
		return hash;
	}
}
