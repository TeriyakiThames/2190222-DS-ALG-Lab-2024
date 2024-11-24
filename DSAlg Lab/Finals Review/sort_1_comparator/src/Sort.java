import java.util.function.BiFunction;

public class Sort {

	public static void sort(int[] data, BiFunction<Integer, Integer, Integer> comparator) {
		// Choose any sorting algorithm you want:
		bubbleSort(data, comparator);
//		mergeSort(data, comparator);
//		selectionSort(data, comparator);
//		insertionSort(data, comparator);
//		quickSort(data, comparator);
	}

	private static void swap(int[] data, int x, int y) {
		int temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}

	private static void bubbleSort(int[] data, BiFunction<Integer, Integer, Integer> comparator) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (comparator.apply(data[j], data[j + 1]) > 0) {
					swap(data, j, j + 1);
				}
			}
		}
	}

	private static void mergeSort(int[] data, BiFunction<Integer, Integer, Integer> comparator) {
		if (data.length < 2) {
			return;
		}

		int mid = data.length / 2;
		int[] left = new int[mid];
		int[] right = new int[data.length - mid];

		System.arraycopy(data, 0, left, 0, mid);
		System.arraycopy(data, mid, right, 0, data.length - mid);

		mergeSort(left, comparator);
		mergeSort(right, comparator);

		merge(data, left, right, comparator);
	}

	private static void merge(int[] data, int[] left, int[] right, BiFunction<Integer, Integer, Integer> comparator) {
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (comparator.apply(left[i], right[j]) <= 0) {
				data[k++] = left[i++];
			} else {
				data[k++] = right[j++];
			}
		}

		while (i < left.length) {
			data[k++] = left[i++];
		}

		while (j < right.length) {
			data[k++] = right[j++];
		}
	}

	private static void selectionSort(int[] data, BiFunction<Integer, Integer, Integer> comparator) {
		int n = data.length;

		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;

			for (int j = i + 1; j < n; j++) {
				if (comparator.apply(data[j], data[minIdx]) < 0) {
					minIdx = j;
				}
			}

			if (minIdx != i) {
				swap(data, i, minIdx);
			}
		}
	}

	private static void insertionSort(int[] data, BiFunction<Integer, Integer, Integer> comparator) {
		int n = data.length;

		for (int i = 1; i < n; i++) {
			int key = data[i];
			int j = i - 1;

			while (j >= 0 && comparator.apply(data[j], key) > 0) {
				data[j + 1] = data[j];
				j = j - 1;
			}

			data[j + 1] = key;
		}
	}

	private static void quickSort(int[] data, BiFunction<Integer, Integer, Integer> comparator) {
		quickSortHelper(data, 0, data.length - 1, comparator);
	}

	private static void quickSortHelper(int[] data, int low, int high,
			BiFunction<Integer, Integer, Integer> comparator) {
		if (low < high) {
			int pivotIndex = partition(data, low, high, comparator);
			quickSortHelper(data, low, pivotIndex - 1, comparator);
			quickSortHelper(data, pivotIndex + 1, high, comparator);
		}
	}

	private static int partition(int[] data, int low, int high, BiFunction<Integer, Integer, Integer> comparator) {
		int pivot = data[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {
			if (comparator.apply(data[j], pivot) < 0) {
				i++;
				swap(data, i, j);
			}
		}

		swap(data, i + 1, high);

		return i + 1;
	}
}