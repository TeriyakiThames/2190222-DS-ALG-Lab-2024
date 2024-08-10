package logic;

public class Station {
    private String name;
    private int number;

    public Station(String name, int number) {
        this.name = name;
        if (number < 1) {
            this.number = 0;
        } else {
            this.number = number;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setNumber(int newNumber) {
    	if (number < 1) {
            this.number = 0;
        } else {
            this.number = newNumber;
        }
    }
}
