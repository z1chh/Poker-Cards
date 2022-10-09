package chapter6;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Program {
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);

	
	public Program() {
		for(Day day: aShows.keySet()) {
			aShows.put(day, Show.NULLSHOW);
		}
	}

	/**
	 * Clear the program by removing all existing shows.
	 */
	public void clear() {
		for (Day day : aShows.keySet()) {
			aShows.put(day, Show.NULLSHOW);
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
		aShows.put(pDay, pShow);
	}

	/**
	 * Removes a show from the program.
	 * 
	 * @param pDay The day when we want to zap the show.
	 */
	public void remove(Day pDay) {
		assert pDay != null;
		aShows.put(pDay, Show.NULLSHOW);
	}

	/**
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
	 */
	public Show get(Day pDay) {
		assert pDay != null;
		if(aShows.containsKey(pDay)) return aShows.get(pDay);
		else return Show.NULLSHOW;
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
	
	public Program copy() {
		Program toReturn = new Program();
		for(Day day: this.aShows.keySet()) {
			toReturn.aShows.put(day, this.aShows.get(toReturn).copy());
		}
		return toReturn;
	}
	
	
	// Commands
	public Command getAddCommand(Show pShow, Day pDay) {
		return new Command() {
			private List<Program> aPrograms = new ArrayList<>();

			@Override
			public void execute() {
				aPrograms.add(Program.this.copy());
				add(pShow, pDay);
			}
			
			@Override
			public String toString() {
				return String.format("ADD: [%s: %s]", pDay, pShow);
			}

			@Override
			public void undo() {
				int programs = this.aPrograms.size();
				assert programs != 0;
				for(Day day: Program.this.aShows.keySet()) {
					Program.this.aShows.put(day, this.aPrograms.get(programs).get(day));
				}
				this.aPrograms.remove(programs);
			}
			
		};
	}
	
	public Command getRemoveCommand(Day pDay) {
		return new Command() {
			private List<Program> aPrograms = new ArrayList<>();

			@Override
			public void execute() {
				remove(pDay);
			}
			
			@Override
			public String toString() {
				return String.format("REMOVE: [%s]", pDay);
			}

			@Override
			public void undo() {
				int programs = this.aPrograms.size();
				assert programs != 0;
				for(Day day: Program.this.aShows.keySet()) {
					Program.this.aShows.put(day, this.aPrograms.get(programs).get(day));
				}
				this.aPrograms.remove(programs);
			}
			
		};
	}
	
	public Command getClearCommand() {
		return new Command() {
			private List<Program> aPrograms = new ArrayList<>();
			
			@Override
			public void execute() {
				aPrograms.add(Program.this.copy());
				clear();
			}
			
			@Override
			public String toString() {
				return "CLEAR";
			}

			@Override
			public void undo() {
				int programs = this.aPrograms.size();
				assert programs != 0;
				for(Day day: Program.this.aShows.keySet()) {
					Program.this.aShows.put(day, this.aPrograms.get(programs).get(day));
				}
				this.aPrograms.remove(programs);
			}
			
		};
	}
}