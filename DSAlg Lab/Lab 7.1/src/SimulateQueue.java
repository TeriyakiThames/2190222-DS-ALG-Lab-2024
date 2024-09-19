
public class SimulateQueue {
	CustomerInfo[][] allEvents; // events in each and every queue
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		int allQueueIndex = 0;

		// Loop into allEvents
		for (CustomerInfo[] events : allEvents) {
			// Inside each event, loop through it
			for (int i = 0; i < events.length; i++) {
				MyQueue currentQueue = allQueues[allQueueIndex];
				CustomerInfo currentEvent = events[i];

				// If the time >= t then just break
				// We want (time < t)
				if (currentEvent.time >= t) {
					break;
				}

				// If the event is 1, add a person (1)
				if (currentEvent.event == 1) {
					currentQueue.insertLast(1);

					// If the event is -1, remove first
				} else if (currentEvent.event == -1 && !currentQueue.isEmpty()) {
					currentQueue.removeFirst();
				}
			}
			allQueueIndex++;
		}

	}

}
