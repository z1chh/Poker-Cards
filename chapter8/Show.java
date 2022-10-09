package chapter8;

public interface Show extends Cloneable
{
	public static Show NULLSHOW = new Show() {

		@Override
		public String description() {
			return "No show";
		}

		@Override
		public int runningTime() {
			return 0;
		}

		@Override
		public Show clone() {
			return Show.NULLSHOW;
		}
		
	};
	/**
	 * @return A description of the show.
	 */
	String description();
	
	
	/**
	 * @return The running time of the show, in minutes.
	 */
	int runningTime();
	
	Show clone();
}
