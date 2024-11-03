public class PointsLinkedList2 extends PointsLinkedList {
	public boolean pointValueExist(Point p) throws Exception {
		PointListNode currentNode = this.header.nextNode;

		// Loop through nodes with data
		while (currentNode != null && currentNode.data != null) {
			// Return true if the value is equal but next and prev aren't
			if (p.value == currentNode.data.value && !p.equals(currentNode.data)) {
				return true;
			}
			currentNode = currentNode.nextNode;
		}
		// Otherwise return false
		return false;

	}

}
