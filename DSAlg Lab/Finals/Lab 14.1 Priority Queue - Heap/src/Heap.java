public class Heap {
	int[] mData;
	int size = 0;

	public Heap() {
		final int DEFAULT_CAPACITY = 11;
		mData = new int[DEFAULT_CAPACITY];
	} // default constructor

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(int element) {
		// Resize if necessary and add elements to the end
		if (++size == mData.length) {
			int[] newHeap = new int[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		mData[size - 1] = element;
		percolateUp();

		// Modified part is to be written below:
		// Check from size - 2 if there is a larger number
		int maxIndex = size - 1;
		for (int i = size - 2; i >= 0; i--) {
			if (mData[i] > mData[maxIndex]) {
				maxIndex = i;
			}
		}

		// If there is a new maxIndex, swap it
		if (maxIndex != size - 1) {
			swap(maxIndex, size - 1);
		}

		// Same code from percolateUp() but change child to maxIndex
		while (maxIndex > 0) {
			int parent = (maxIndex - 1) / 2;
			if (mData[parent] <= mData[maxIndex])
				break;
			swap(parent, maxIndex);
			maxIndex = parent;
		}
	}

	// Method to swap values
	private void swap(int index1, int index2) {
		int tempValue = mData[index1];
		mData[index1] = mData[index2];
		mData[index2] = tempValue;
	}

	protected void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		while (child > 0) {
			parent = (child - 1) / 2;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}

	public int top() throws Exception {
		if (size == 0)
			throw new Exception("Empty");
		return mData[0];
	}

	// never get called in our program
	public int pop() throws Exception {
		if (size == 0)
			throw new Exception("Priority queue empty.");
		int minElem = mData[0];
		mData[0] = mData[size - 1];
		size--;
		percolateDown(0);
		return minElem;
	}

	protected void percolateDown(int start) {
		int parent = start;
		int child = 2 * parent + 1;
		int temp;
		while (child < size) {
			if (child < size - 1 && mData[child] > mData[child + 1])
				child++;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[child];
			mData[child] = mData[parent];
			mData[parent] = temp;
			parent = child;
			child = 2 * parent + 1;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
