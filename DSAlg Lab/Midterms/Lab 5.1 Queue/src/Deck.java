public class Deck extends DeQLinkedList {
	public Deck() {
		super();
	}

	public int draw() {
		if (isEmpty()) {
			return -1;
		}
		try {
			return removeFirst();
		} catch (Exception e) {
			return -1;
		}
	}

	public int removeNth(int n) {
		try {
			int data = theList.findKth(n);
			theList.remove(data);
			return data;
		} catch (Exception e) {
			return -1;
		}
	}

	public void putBottom(int n) {
		try {
			insertLast(n);
		} catch (Exception e) {
			System.out.println("Error in putBottom()");
		}
	}

	public void reverseTopN(int n) {
		if (isEmpty()) {
			return;
		}
		if (n > size()) {
			n = size();
		}
		if (n < size()) {
			DListNode first = theList.header.nextNode;

			try {
				DListIterator itr = (DListIterator) theList.findPrevious(theList.findKth(n));
				DListNode last = itr.currentNode;
				DListNode next = last.nextNode;

				DListNode current = first;
				DListNode prev = theList.header;
				DListNode next2;

				for (int i = 0; i < n - 1; i++) {
					next2 = current.nextNode;
					current.nextNode = prev;
					current.previousNode = next2;
					prev = current;
					current = next2;
				}

				current.previousNode = theList.header;
				current.nextNode = prev;
				last.previousNode = theList.header;
				theList.header.nextNode = last;
				next.previousNode = first;
				first.nextNode = next;

			} catch (Exception e) {
			}

		} else {
			DListNode first = theList.header.nextNode;
			DListNode last = theList.header.previousNode;

			DListNode current = first;
			DListNode prev = theList.header;
			DListNode next2;

			for (int i = 0; i < theList.size(); i++) {
				next2 = current.nextNode;
				current.nextNode = prev;
				current.previousNode = next2;
				prev = current;
				current = next2;
			}

			theList.header.nextNode = last;
			last.previousNode = theList.header;
			theList.header.previousNode = first;
			first.nextNode = theList.header;
		}
	}

}