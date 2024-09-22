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

	public void swapRange(Iterator s1, Iterator f1, Iterator s2, Iterator f2) {
		// Check for errors
		if (s1 == null || s2 == null || f1 == null || f2 == null || !(s1 instanceof DListIterator)
				|| !(s2 instanceof DListIterator) || !(f1 instanceof DListIterator) || !(f2 instanceof DListIterator)) {
			return;
		}

		// Type cast to DListIterator
		DListIterator s1ListItr = (DListIterator) s1;
		DListIterator f1ListItr = (DListIterator) f1;
		DListIterator s2ListItr = (DListIterator) s2;
		DListIterator f2ListItr = (DListIterator) f2;

		// Get the nodes for each iterator
		DListNode s1Node = s1ListItr.currentNode;
		DListNode f1Node = f1ListItr.currentNode;
		DListNode s2Node = s2ListItr.currentNode;
		DListNode f2Node = f2ListItr.currentNode;

		// Store the previous/next nodes for switching
		DListNode s1PrevNode = s1Node.previousNode;
		DListNode f1NextNode = f1Node.nextNode;
		DListNode s2PrevNode = s2Node.previousNode;
		DListNode f2NextNode = f2Node.nextNode;

		// Switching the nodes
		boolean isAdjacent = (f1Node.nextNode == s2Node);
		if (isAdjacent) {
			s1PrevNode.nextNode = s2Node;
			s2Node.previousNode = s1PrevNode;
			
			f2Node.nextNode = s1Node;
			s1Node.previousNode = f2Node;
			
			f1Node.nextNode = f2NextNode;
			f2NextNode.previousNode = f1Node;
			
		} else {
			s1Node.previousNode = s2PrevNode;
			s1PrevNode.nextNode = s2Node;

			s2PrevNode.nextNode = s1Node;
			s2Node.previousNode = s1PrevNode;

			f2Node.nextNode = f1NextNode;
			f2NextNode.previousNode = f1Node;

			f1Node.nextNode = f2NextNode;
			f1NextNode.previousNode = f2Node;

		}
	}

}