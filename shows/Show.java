package shows;

public interface Show {
	String getDescription();
	int getTime();
	Show copy();
	
	public static Show createNull() {
		return new Show() {

			@Override
			public String getDescription() {
				return "No Show";
			}

			@Override
			public int getTime() {
				return 0;
			}

			@Override
			public Show copy() {
				return createNull();
			}
			
			@Override
			public boolean equals(Object pObject) {
				if(pObject == null) return false;
				else if(pObject == this) return true;
				else if(this.getClass() != pObject.getClass()) return false;
				else {
					return getDescription() == ((Movie)pObject).getDescription() && getTime() == ((Movie)pObject).getTime();
				}
			}
			
			@Override
			public int hashCode() {
				return 0;
			}
			
		};
	}
}
