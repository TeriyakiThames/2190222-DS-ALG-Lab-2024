
public class FileBucketDoubleHashing extends FileBucketOpenAddressing {

	static double MAXFACTOR = 0.75;
	int occupiedSlots = 0;

	public FileBucketDoubleHashing() {
		this(DEFAULT_SIZE);
	}

	public FileBucketDoubleHashing(int size) {
		super(size);
	}

	public int hash(int id) {
		return id % array.length;
	}

	public int hash2(int id) {
		if (id % 2 == 0) {
			return id % 5;
		} else {
			return id % 4;
		}

	}

	private double loadFactor() {
		return (double) occupiedSlots / array.length;
	}

	public void add(File file) throws Exception {
		int data = file.getId();
		int hash1Result = hash(data);
		int hash2Result = hash2(data);
		int emptySlotPosition = -1;
		final int smallNumber = 5;

		int i = 0;
		for (; i < currentSize + smallNumber; i++) {
			if (array[hash1Result] == null || array[hash1Result] == file) {
				break;
			} else if (array[hash1Result] == DELETED && emptySlotPosition == -1) {
				emptySlotPosition = hash1Result;
			}
			hash1Result = (hash1Result + hash2Result) % array.length;
		}

		if (i >= currentSize + smallNumber) {
			rehash();
			add(file);
		} else {
			if (array[hash1Result] == null) {
				if (emptySlotPosition != -1) {
					array[emptySlotPosition] = file;
				} else {
					array[hash1Result] = file;
					occupiedSlots++;
				}
				currentSize++;
				if (loadFactor() > MAXFACTOR) {
					rehash();
				}
			}
		}
	}

	public void rehash() throws Exception {
		File[] oldArray = array;
		array = new File[nextPrime(array.length * 2)];
		currentSize = 0;
		occupiedSlots = 0;

		for (File file : oldArray) {
			if (file != null && file != DELETED) {
				add(file);
			}
		}
	}

	public void remove(int index) {
		if (index != -1 || array[index] != null) {
			array[index] = DELETED;
			currentSize--;
		}
	}

}
