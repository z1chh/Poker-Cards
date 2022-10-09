package chapter7;

public interface CardSource {
	public default boolean isEmpty() {
		return size() == 0;
	}
	
	public int size();
	public Card draw();
}
