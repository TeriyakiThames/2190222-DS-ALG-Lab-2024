public class SelectionSort {

	public static void selectionSort(int[] a) {
		int maxindex; // index of the largest value
		for (int unsorted = a.length; unsorted > 1; unsorted--) {
			maxindex = 0;
			for (int index = 1; index < unsorted; index++) {
				if (a[maxindex] < a[index])
					maxindex = index;
			}
			if (a[maxindex] != a[unsorted - 1])
				swap(a, maxindex, unsorted - 1);
		}
	}

	private static void swap(int[] a, int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}

	// a modified selection sort to be put here
	public static void selectionSort(int[] a, int l, int r) {
		int maxIndex;
		// Starts from index r and loop to index l 
		for (int unsorted = r; unsorted > l; unsorted--) {
			// Start max index at l
			maxIndex = l;
			// Starts from l+1 to unsorted instead of 1 to unsorted
			for (int index = l + 1; index <= unsorted; index++) {
				if (a[maxIndex] < a[index]) {
					maxIndex = index;
				}
			}
			if (a[maxIndex] != a[unsorted]) {
				swap(a, maxIndex, unsorted);
			}
		}
	}

}
