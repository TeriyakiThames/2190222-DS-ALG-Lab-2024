public class TypingDeadList extends CDLinkedList {
	int score = 0; // not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// Initialise the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String word) throws Exception {
		DListIterator itr = new DListIterator(header.nextNode);
		DListIterator tempStart = null;

		int wordLength = word.length();
		int matchIndex = 0;

		while (itr.currentNode != header) {
			char currentData = itr.currentNode.data;

			if (currentData == word.charAt(matchIndex)) {
				if (matchIndex == 0) {
					tempStart = new DListIterator(itr.currentNode);
				}
				
				matchIndex++;
				
				if (matchIndex == wordLength) {
					start = tempStart;
					end = new DListIterator(itr.currentNode);
					return;
				}
			} else {
				matchIndex = 0;
				tempStart = null;
			}

			itr.next();
		}
	}

	public void remove(int dec) throws Exception {
		if (start != null && end != null && start.currentNode != header && end.currentNode != header) {
			DListNode endNextNode = end.currentNode.nextNode;
			DListNode startPreviousNode = start.currentNode.previousNode;

			if (startPreviousNode != null) {
				startPreviousNode.nextNode = endNextNode;
			}

			if (endNextNode != null) {
				endNextNode.previousNode = startPreviousNode;
			}

			size -= dec;
			start = null;
			end = null;
		} else {
			return;
		}
	}

}
