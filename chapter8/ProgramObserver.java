package chapter8;

import chapter8.Program.Day;

public interface ProgramObserver {
	public void showAddedToDay(Show pShow, Day pDay);
	public void showRemovedFromDay(Show pShow, Day pDay);
}
