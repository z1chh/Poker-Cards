package shows;

import java.util.EnumMap;

public class Program {
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	private final Show NULLSHOW = Show.createNull();

	public Program() {
		clear();
	}

	/**
	 * Clear the program by removing all existing shows.
	 */
	public void clear() {
		for(Day day: Day.values()) {
			aShows.put(day,  NULLSHOW);
		};
	}

	/**
	 * Adds a new show to the program. Overrides any existing show on that day.
	 * 
	 * @param pShow The show to add.
	 * @param pDay  The day when the show takes place.
	 */
	public void add(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		aShows.put(pDay,  pShow);
	}

	/**
	 * Removes a show from the program.
	 * 
	 * @param pDay The day when we want to zap the show.
	 */
	public void remove(Day pDay) {
		assert pDay != null;
		assert aShows.get(pDay) != NULLSHOW;
		aShows.remove(pDay);
	}

	/**
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
	 */
	public Show get(Day pDay) {
		assert pDay != null;
		return aShows.get(pDay);
	}
	
	public boolean showIsNull(Day pDay) {
		assert aShows.get(pDay) != null;
		return aShows.get(pDay).equals(NULLSHOW);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Day day : aShows.keySet()) {
			if (aShows.containsKey(day)) {
				result.append(String.format("%9s", day.name())).append(": ").append(aShows.get(day).getDescription())
						.append("\n");
			}
		}
		return result.toString();
	}
	
	public Command addCommand(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		return new Command() {

			@Override
			public void execute() {
				add(pShow, pDay);
			}
			
		};
	}
}
