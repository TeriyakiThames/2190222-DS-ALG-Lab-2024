import java.util.ArrayList;
import java.util.function.BiFunction;

public class ExamSorter {
	ArrayList<Long>[] buckets;

	public ExamSorter() {
		buckets = (ArrayList<Long>[]) new ArrayList[30];
		for (int i = 0; i < 30; i++) {
			buckets[i] = new ArrayList<Long>();
		}
	}

	// Insert IDs into buckets
	public void insert(long[] data) {
		for (long value : data) {
			String valueString = String.valueOf(value);
			int bucketID = Integer.parseInt(valueString.substring(3, 5));
			buckets[bucketID].add(value);
		}

	}

	// Sort the bucket with selection sort
	public void sort(int bucketNumber) {
		ArrayList<Long> bucket = buckets[bucketNumber];
		int n = bucket.size();

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (bucket.get(j) < bucket.get(minIndex)) {
					minIndex = j;
				}
			}
			// Swap the elements
			if (minIndex != i) {
				long temp = bucket.get(i);
				bucket.set(i, bucket.get(minIndex));
				bucket.set(minIndex, temp);
			}
		}
	}

	// Collects and merges all sorted buckets into a single sorted array
	public long[] collect() {
		ArrayList<Long> sortedList = new ArrayList<>();
		for (ArrayList<Long> bucket : buckets) {
			sortedList.addAll(bucket);
		}

		// Convert ArrayList to array
		long[] result = new long[sortedList.size()];
		for (int i = 0; i < sortedList.size(); i++) {
			result[i] = sortedList.get(i);
		}

		return result;
	}

	// Performs the entire sorting process
	public long[] perform(long[] data) {
		insert(data); // Step 1: Insert data into buckets

		// Step 2: Sort each bucket
		for (int i = 0; i < 30; i++) {
			sort(i);
		}

		// Step 3: Collect all sorted buckets into a single array
		return collect();
	}
}
