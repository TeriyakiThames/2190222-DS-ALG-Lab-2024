
public class Sort {
	public static int[] sortFrequency(int[] x) {
		Pair[] pairList = getPairList(x);
		mergeSort(pairList);
//		printPairList(pairList);
		return pair2Int(pairList);
	}

	private static Pair[] getPairList(int[] x) {
		// Create an array of 10 pairs with freq = 0
		Pair[] pairList = new Pair[10];
		for (int i = 0; i < 10; i++) {
			pairList[i] = new Pair(i + 1, 0);
		}

		// For each number in x, add 1 to the freq in the array
		for (int num : x) {
			pairList[num - 1].freq += 1;
		}
		return pairList;
	}

	private static void mergeSort(Pair[] pairList) {
		int size = pairList.length;
		// Base Case: array less than 2 elements
		if (size < 2) {
			return;
		}

		// Split the array into left and right halves
		int mid = size / 2;
		Pair[] left = new Pair[mid];
		Pair[] right = new Pair[size - mid];
		System.arraycopy(pairList, 0, left, 0, mid);
		System.arraycopy(pairList, mid, right, 0, size - mid);

		// Recursively go through each half
		mergeSort(left);
		mergeSort(right);

		// Merge them back together
		merge(pairList, left, right);
	}

	private static void merge(Pair[] pairList, Pair[] left, Pair[] right) {
		// left, right, and main index
		int li = 0, ri = 0, mi = 0;

		// Merge elements into pairList
		while (li < left.length && ri < right.length) {
			Pair leftPair = left[li];
			Pair rightPair = right[ri];

			// Sort by frequency descending, then by value ascending
			if (leftPair.freq > rightPair.freq
					|| (leftPair.freq == rightPair.freq && leftPair.value < rightPair.value)) {
				pairList[mi++] = leftPair;
				li++;
			} else {
				pairList[mi++] = rightPair;
				ri++;
			}
		}

		// Copy remaining elements in the left and right arrays
		while (li < left.length) {
			pairList[mi++] = left[li++];
		}

		while (ri < right.length) {
			pairList[mi++] = right[ri++];
		}
	}

	private static int[] pair2Int(Pair[] pairList) {
		int counter = 0;
		for (Pair p : pairList) {
			if (p.freq > 0) {
				counter++;
			}
		}

		int[] intList = new int[counter];
		int index = 0;
		for (Pair p : pairList) {
			if (p.freq > 0) {
				intList[index] = p.value;
				index++;
			}
		}
		return intList;
	}

	// Debugger to print out the value/freq pairs
	private static void printPairList(Pair[] pairList) {
		System.out.println("Start Print!");
		for (Pair p : pairList) {
			System.out.println("Value: " + p.value + " Freq: " + p.freq);
		}
		System.out.println("End Print!");
	}

}
