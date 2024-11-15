public class TernaryHeap extends Heap {

	@Override
	protected void percolateUp() {
		int child = size - 1;
		while (child > 0) {
			// Change equation here from 2 to 3.
			int parent = (child - 1) / 3;
			if (mData[parent] <= mData[child])
				break;
			swap(parent, child);
			child = parent;
		}
	}

	@Override
	protected void percolateDown(int start) {
		int parent = start;

		while (true) {
			int child1 = 3 * parent + 1;
			int child2 = 3 * parent + 2;
			int child3 = 3 * parent + 3;
			int smallest = parent;

			// Basically find the smallest among all three, then swap them.
			if (child1 < size && mData[child1] < mData[smallest])
				smallest = child1;
			if (child2 < size && mData[child2] < mData[smallest])
				smallest = child2;
			if (child3 < size && mData[child3] < mData[smallest])
				smallest = child3;

			// Condition for stopping the loop
			if (smallest == parent)
				break;

			// Swap parent and smallest child
			swap(parent, smallest);
			parent = smallest;
		}
	}

	// Function to clean up swapping values
	private void swap(int i, int j) {
		int temp = mData[i];
		mData[i] = mData[j];
		mData[j] = temp;
	}
}