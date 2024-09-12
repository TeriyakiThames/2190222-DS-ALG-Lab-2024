
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";

	public static String operate(MyStack s1, MyStack s2) throws Exception {
		StackArray s3 = new StackArray();
		
		int loopNumber = s1.size()/2;		
		for (int i = 0; i < loopNumber;i++) {
			int a = s1.top();
			s1.pop();
			int b = s1.top();
			s1.pop();
			int c = s2.top();
			s2.pop();
			s3.push(operation(a, b, c));
		}
		return decode(s3);

	}

	private static int operation(int a, int b, int c) {
		if (c >= 0) {
			return a + b;
		} else {
			return a - b;
		}
	}

	private static String decode(MyStack s) {
		String message = "";
		int loopNumber = s.size();
		for (int i = 0; i < loopNumber; i++) {
			int index = 0;
			try {
				index = s.top();
				s.pop();
			} catch (Exception e) {
				System.out.println("Error in return string!");
			}
			if (index < 26 && index >= 0) {
				char letter = alphabets.charAt(index);
				message += letter;
			} else {
				return "Message is broken!";
			}
		}
		return message;
	}
}
