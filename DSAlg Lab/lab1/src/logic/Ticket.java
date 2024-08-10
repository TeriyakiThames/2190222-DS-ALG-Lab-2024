package logic;

public class Ticket {
	private int type;
	private int priceperstation;

	private Station start;
	private Station end;

	public Ticket(int type, Station start, Station end) {
		setType(type);
		setStation(start, end);
	}

	public int getType() {
		return type;
	}

	public int getPricePerStation() {
		return priceperstation;
	}

	public Station getStart() {
		return start;
	}

	public Station getEnd() {
		return end;
	}

	public void setType(int type) {
		/* FILL CODE */
		if (type == 0 || type == 1 || type == 2) {
			this.type = type;
			if (type == 0 || type == 1) {
				priceperstation = 30;
			} else {
				priceperstation = 25;
			}
		} else {
			this.type = 1;
		}
	}

	public void setStation(Station start, Station end) {
		/* FILL CODE */
		this.start = start;
		this.end = end;
	}

	public double calculatePrice() {
		/* FILL CODE */
		int stationDistance = getStationDistance(start, end);
		// Check for invalid station
		if (!isStationValid(start, end)) {
			return -1.0;
		}

		// Calculate Student ticket
		if (type == 0) {
			if (stationDistance > 4) {
				return 0.8 * (priceperstation * stationDistance);
			} else {
				return (priceperstation * stationDistance);
			}
		}

		// Calculate Adult ticket
		if (type == 1) {
			return (priceperstation * stationDistance);
		}

		// Calculate Elderly ticket
		if (type == 2 && stationDistance <= 6) {
			return 0.6 * (priceperstation * stationDistance);
		}
		return -1.0;
	}

	public String getDescription() {
		String typename;

		switch (type) {

			case 0:
				typename = "Student";
				break;
			case 1:
				// FILL CODE
				typename = "Adult";
				break;
			case 2:
				// FILL CODE
				if (getStationDistance(start, end) <= 6) {
					typename = "Elderly";
				} else {
				typename = "Invalid";}
				break;
			default:
				typename = "Invalid";
		}

		return typename + " Ticket, from " + start.getName() + " to " + end.getName();
	}

	public boolean isStationValid(Station start, Station end) {
		// Check for elderly
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		// Check if start and end are the same
		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}

	public int getStationDistance(Station start, Station end) {
		return Math.abs(start.getNumber() - end.getNumber());
	}

}
