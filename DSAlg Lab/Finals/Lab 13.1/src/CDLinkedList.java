public class CDLinkedList {
	DListNode header;
	int size;
	static final int HEADERVALUE = -9999999;

	public CDLinkedList() {
		header = new DListNode(HEADERVALUE);
		makeEmpty();// necessary, otherwise next/previous node will be null
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	public boolean isFull() {
		return false;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
		size = 0;
	}

	// put in new data after the position of p.
	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(int value) throws Exception {
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v == value)
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public int findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size - 1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(int value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		int currentData = itr2.next();
		while (currentData != value) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(int value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();

			System.out.println(data);

		}
	}

	public int size() throws Exception {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}

	public void sort() throws Exception {
		DListIterator start = new DListIterator(header.nextNode);
		DListIterator end = new DListIterator(header.previousNode);
		quickSort(start, end);
	}

	public void quickSort(DListIterator left, DListIterator right) throws Exception {
		// Base Case
		if (left.currentNode.previousNode == right.currentNode) {
			return;
		}

		DListIterator i = new DListIterator(left.currentNode);
		DListIterator j = new DListIterator(right.currentNode.previousNode);
		int pivot = right.currentNode.data;

		for (;;) {
			// If current value is less than pivot, move forwards
			while ((i.currentNode.data < pivot) && (i.currentNode.nextNode != header)) {
				i.next();
			}

			// If current value is more than pivot, move backwards
			while ((j.currentNode.data > pivot) && (j.currentNode.previousNode != header)) {
				j.previous();
			}

			// Swap the data when it should be on the opposite side of the pivot
			if ((isLeft(i, j)) && (i.currentNode.data > j.currentNode.data)) {
				swap(i, j);
				i.next();
				j.previous();
			} else {
				break;
			}
		}

		// Swapping pivot location
		swap(i, right);

		// Recursively go through the left and right halves
		quickSort(left, new DListIterator(i.currentNode.previousNode));
		quickSort(new DListIterator(i.currentNode.nextNode), right);
	}

	// Helper function to check whether i is to the left of the j iterator
	public boolean isLeft(DListIterator i, DListIterator j) throws Exception {
		int iValue = 0, jValue = 0;
		DListIterator iItr = new DListIterator(i.currentNode);
		DListIterator jItr = new DListIterator(j.currentNode);

		// Adds 1 when you can move
		while (iItr.currentNode != header) {
			iValue++;
			iItr.previous();
		}

		while (jItr.currentNode != header) {
			jValue++;
			jItr.previous();
		}

		// The one with the lower value should be left
		// while the one with the higher value should be on the right
		if (iValue < jValue) {
			return true;
		}
		return false;

	}

	// Helper function to swap values
	public void swap(DListIterator a, DListIterator b) {
		int temp = b.currentNode.data;
		b.currentNode.data = a.currentNode.data;
		a.currentNode.data = temp;
	}

}