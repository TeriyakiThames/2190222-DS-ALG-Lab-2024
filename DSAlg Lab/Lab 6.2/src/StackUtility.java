public class StackUtility {
	public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
		StackArray tempStack = new StackArray();
		int stackSize = 0;

		// Get the size from the stack
		if (s instanceof StackArray) {
			stackSize = ((StackArray) s).getCurrentSize();
		} else if (s instanceof StackLinkedList) {
			stackSize = ((StackLinkedList) s).getTheList().size();
		}
		
		// Move elements outside range to a new stack
		for (int index = 0; index < stackSize; index++) {
			int topElement = s.top();
			s.pop();
			if (index < i || index > j) {
				tempStack.push(topElement);
			}
		}
		
		// Move the elements back to the old stack
		while (!tempStack.isEmpty()) {
			int data = tempStack.top();
			tempStack.pop();
			s.push(data);
		}
		return s;

	}

}