
public class SepChaining {
	static int DEFAULT_SIZE = 5;
	static int MAXLOAD = 3;
	CDLinkedList[] lists;
	int currentSize = 0;

	public SepChaining() {
		this(DEFAULT_SIZE);
	}

	public SepChaining(int size) {
		int nextPrimeSize = nextPrime(size);
		lists = new CDLinkedList[nextPrimeSize];
		for (int i = 0; i < lists.length; i++)
			lists[i] = new CDLinkedList();
	}

	private static boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	private static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2) {
		}
		return n;
	}

	public int hash(int data) {
		int hashValue = data;
		int abs = Math.abs(hashValue);
		return abs % lists.length;
	}

	// Position of that exact data in that list
	public int find(int data) throws Exception {
		int pos = hash(data);
		CDLinkedList theList = lists[pos];
		return theList.find(data);
	}

	public void add(int data) throws Exception {
		int pos = hash(data);
		CDLinkedList theList = lists[pos];
		if (theList.find(data) == -1) { // not found
			DListIterator itr = new DListIterator(lists[pos].header);
			lists[pos].insert(data, itr);
			currentSize++;
		}
		if (currentSize / lists.length >= MAXLOAD) {
			rehash();
		}
	}

	public void rehash() throws Exception {
		CDLinkedList[] oldLists = lists;
		int newLength = nextPrime(2 * lists.length);
		lists = new CDLinkedList[newLength];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new CDLinkedList();
		}
		currentSize = 0;
		for (int i = 0; i < oldLists.length; i++) {
			DListIterator itr;
			itr = new DListIterator(oldLists[i].header);
			while (itr.currentNode.nextNode != oldLists[i].header) {
				add(itr.next());
			}
		}
	}

	public double loadFactor() {
		// Load factor = n/N where,
		// n = number of entries in the structure
		// N = number of slots in the array
		return (double) currentSize / lists.length;
	}

	public int maxLength() {
		// Go through each linked list then return the one with the largest size
		int maxLength = 0;
		for (CDLinkedList list : lists) {
			if (list.size > maxLength) {
				maxLength = list.size;
			}
		}
		return maxLength;
	}

}
