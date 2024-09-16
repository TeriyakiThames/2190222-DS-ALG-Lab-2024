
public class StackLinkedList implements MyStack {
	private CDLinkedList theList;

	public StackLinkedList() { // create an empty stack
		theList = new CDLinkedList();
	}

	public StackLinkedList(CDLinkedList l) throws Exception {
		super();
		DListIterator iparam = new DListIterator(l.header);
		DListIterator ithis = new DListIterator(theList.header);
		while (iparam.hasNext()) {
			int v = iparam.next();
			if (iparam.currentNode == l.header)
				return;
			theList.insert(v, ithis);
			ithis.next();
		}
	}

	public CDLinkedList getTheList() {
		return theList;
	}

	public void setTheList(CDLinkedList theList) {
		this.theList = theList;
	}

	public boolean isEmpty() {
		return theList.isEmpty();
	}

	public boolean isFull() {
		return false;
	}

	public void makeEmpty() {
		theList.makeEmpty();
	}

	public int top() throws MyStackException {
		if (isEmpty())
			throw new MyStackException();
		return theList.header.nextNode.data;
	}

	public void pop() throws MyStackException {
		if (isEmpty())
			throw new MyStackException();
		Iterator itr = new DListIterator(theList.header);
		theList.remove(itr);
	}

	public void push(int data) throws Exception {
		Iterator itr = new DListIterator(theList.header);
		theList.insert(data, itr);
	}

	public void removeRange(int i, int j) throws Exception {
		// Set up the 2 iterators
		DListIterator itrI = new DListIterator(theList.header.nextNode);
		DListIterator itrJ = new DListIterator(theList.header.nextNode);

		// Loop the iterators to their respective positions
		for (int index = 0; index < j; index++) {
			if (index < i) {
				itrI.next();
			}
			itrJ.next();
		}

		// Reconnect the nodes
		DListNode iPrev = itrI.currentNode.previousNode;
		DListNode jNext = itrJ.currentNode.nextNode;

		iPrev.nextNode = jNext;
		jNext.previousNode = iPrev;

		// Change size of the list
		int numRemoved = j - i + 1;
		theList.size -= numRemoved;

	}

}
