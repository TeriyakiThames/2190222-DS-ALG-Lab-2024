
public class StackArray implements MyStack {
	private int[] theArray;
	private int currentSize;
	private static final int DEFAULT_SIZE = 10;

	public StackArray() { // create an empty stack
		this(DEFAULT_SIZE);
	}

	public StackArray(int intendedCapacity) {
		theArray = new int[intendedCapacity];
		currentSize = 0;
	}

	public StackArray(int[] theArray, int currentSize) {
		super();
		this.theArray = theArray;
		this.currentSize = currentSize;
	}

	public int[] getTheArray() {
		return theArray;
	}

	public void setTheArray(int[] theArray) {
		this.theArray = theArray;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean isFull() {
		return currentSize == theArray.length;
	}

	public void makeEmpty() {
		theArray = new int[DEFAULT_SIZE];
		currentSize = 0;
	}

	public int top() throws MyStackException {
		if (isEmpty())
			throw new MyStackException();
		return theArray[currentSize - 1];
	}

	public void pop() throws MyStackException {
		if (isEmpty())
			throw new MyStackException();
		currentSize--;
	}

	public void doubleCapacity() { // resize array to twice the original size
		int[] temp = new int[theArray.length * 2];
		System.arraycopy(theArray, 0, temp, 0, theArray.length);
		theArray = temp;
	}

	public void push(int data) throws Exception {
		if (isFull())
			doubleCapacity();
		theArray[currentSize] = data;
		currentSize++;
	}

	public void removeRange(int i, int j) {
		int numRemoved = j - i + 1;
		// Shift i and j to the back (0 => 6 if size is 7)
		int transformedI = currentSize - 1 - j;
		int transformedJ = currentSize - 1 - i;

		int[] tempArray = new int[currentSize - numRemoved];
		int indexTemp = 0;

		// Add to new array is index is not between i and j
		for (int index = 0; index < currentSize; index++) {
			if (index < transformedI || index > transformedJ) {
				tempArray[indexTemp++] = theArray[index];
			}
		}
		
		theArray = tempArray;
		currentSize -= numRemoved;
	}

}
