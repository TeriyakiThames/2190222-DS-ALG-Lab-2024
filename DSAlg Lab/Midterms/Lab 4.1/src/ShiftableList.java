
public class ShiftableList extends CDLinkedList {

	public ShiftableList() throws Exception {
		this("");
	}

	public ShiftableList(String s) throws Exception {
		// Initialise the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}
	}

	// Credit to Fong 🙏🙏🙏

	// Can use loops
	public void shift(int n) throws Exception {
		DListNode newStartNode = header;
		// Loop to the new header node
		for (int i = 0; i < n; i++) {
			newStartNode = newStartNode.nextNode;
		}
		shift(newStartNode);
	}

	// Can't use loops!!!
	public void shift(DListNode newStart) {
		// Last node in the list
		DListNode lastNode = header.previousNode;
		// Index 0 of the list
		DListNode firstNode = header.nextNode;
		// Previous node of newStart
		DListNode prevNew = newStart.previousNode;

		// Switch header with newStart
		header.nextNode = newStart;
		newStart.previousNode = header;

		// Switch the first and last index
		lastNode.nextNode = firstNode;
		firstNode.previousNode = lastNode;

		// Switch the node previous to newStart with header
		prevNew.nextNode = header;
		header.previousNode = prevNew;
	}

}
