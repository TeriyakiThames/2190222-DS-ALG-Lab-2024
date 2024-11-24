
public interface Iterator {

	public boolean hasNext();

	public boolean hasPrevious();

	// move iterator to the next position,
	// then returns the value at that position.
	public int next() throws Exception;

	// return the value at current position,
	// then move the iterator back one position.
	public int previous() throws Exception;

	public void set(int value);

}
