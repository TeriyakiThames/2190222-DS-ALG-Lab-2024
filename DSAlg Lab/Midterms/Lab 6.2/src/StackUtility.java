public class StackUtility {
	public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
		StackArray tempStack = new StackArray();
		int index = 0;

		// Move elements outside range to a new stack
		while (!s.isEmpty()) {
			int topElement = s.top();
			s.pop();
			if (index < i || index > j) {
				tempStack.push(topElement);
			}
			index++;
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
