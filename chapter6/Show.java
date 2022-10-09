package chapter6;

public interface Show {

	public static final Show NULLSHOW = getNullShow();

	private static Show getNullShow() {
		return new Show() {

			@Override
			public String description() {
				return "NO SHOW";
			}

			@Override
			public int time() {
				return 0;
			}

			@Override
			public Show copy() {
				return getNullShow();
			}

			@Override
			public boolean isNull() {
				return true;
			}

		};
	}

	public String description();

	public int time();

	public Show copy();

	public default boolean isNull() {
		return false;
	}
}
