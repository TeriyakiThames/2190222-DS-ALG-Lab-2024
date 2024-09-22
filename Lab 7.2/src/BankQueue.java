
public class BankQueue {
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	public void distribute() throws Exception {
		int neededSize = getNeededSize();

		for (DeQ queue : counters) {
			DeQ temp = new DeQArray();

			// Reverse the items into the temp queue?
			while (queue.size() > neededSize) {
				temp.insertLast(queue.removeLast());
			}
			
			// If there is something in temp
			while (!temp.isEmpty()) {
				// Add to special if there is space
				if (special.size() < neededSize) {
					special.insertLast(temp.removeLast());
				// Add back to original queue if there isn't
				} else {
					queue.insertLast(temp.removeLast());
				}
			}
		}

		// For when all the queues are <= to neededSize
		// We then add the last one to the queue
		if (special.isEmpty()) {
			special.insertLast(counters[counters.length - 1].removeLast());
		}
	}
	
	// Method for getting the needed size
	private int getNeededSize() {
		int total = 0;
		for (DeQ queue : counters) {
			total += queue.size();
		}
		float neededSize = (float) total / (counters.length + 1);
		return Math.round(neededSize);
	}
}
