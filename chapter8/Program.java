package chapter8;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Class responsible for managing a program that consists of various shows
 * presented on different days of one week. Each day of the week must be
 * associated with exactly one Show object. If there is not show on a given day,
 * a special object of type show is used to represent a "non-show".
 */
public class Program {
	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);

	private final List<ProgramObserver> aObservers = new ArrayList<>();

	public void addObserver(ProgramObserver pProgramObserver) {
		this.aObservers.add(pProgramObserver);
	}

	public void removeObserver(ProgramObserver pProgramObserver) {
		if (this.aObservers.contains(pProgramObserver))
			this.aObservers.remove(pProgramObserver);
	}

	public Program() {
		clear();
	}

	/**
	 * Clear the program by removing all existing shows.
	 */
	public void clear() {
		for(Day day: Day.values()) {
			this.aShows.put(day, Show.NULLSHOW);
			for(ProgramObserver o: this.aObservers) o.showRemovedFromDay(this.aShows.get(day), day);
		}
	}

	/**
	 * Adds a new show to the program. Overrides any existing show on that day.
	 * 
	 * @param pShow The show to add.
	 * @param pDay  The day when the show takes place.
	 */
	public void add(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		this.aShows.put(pDay, pShow);
		for(ProgramObserver o: this.aObservers) o.showAddedToDay(pShow, pDay);
	}

	/**
	 * Removes a show from the program.
	 * 
	 * @param pDay The day when we want to zap the show.
	 */
	public void remove(Day pDay) {
		assert pDay != null;
		for(ProgramObserver o: this.aObservers) o.showAddedToDay(this.aShows.get(pDay), pDay);
		this.aShows.put(pDay, Show.NULLSHOW);
		
	}

	/**
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
	 */
	public Show get(Day pDay) {
		assert pDay != null;
		return this.aShows.get(pDay).clone();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Day day : aShows.keySet()) {
			if (aShows.containsKey(day)) {
				result.append(String.format("%9s", day.name())).append(": ").append(aShows.get(day).description())
						.append("\n");
			}
		}
		return result.toString();
	}
}
