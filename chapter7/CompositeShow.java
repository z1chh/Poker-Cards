package chapter7;

import java.util.ArrayList;
import java.util.List;

public class CompositeShow implements Show {
	private final List<AbstractShow> aShows = new ArrayList<>();

	@Override
	public String title() {
		String toReturn = "";
		for(int i = 0; i < aShows.size(); i++) {
			AbstractShow show = aShows.get(i);
			toReturn += show.title();
			if(i != aShows.size() - 1) toReturn += " followed by ";
		}
		return toReturn;
	}

	@Override
	public String description() {
		String toReturn = "";
		for(int i = 0; i < aShows.size(); i++) {
			AbstractShow show = aShows.get(i);
			toReturn += show.description();
			if(i != aShows.size() - 1) toReturn += " followed by ";
		}
		return toReturn;
	}

	@Override
	public int time() {
		int toReturn = 0;
		for(AbstractShow show: aShows) {
			toReturn += show.time();
		}
		return toReturn;
	}
	
	


}
