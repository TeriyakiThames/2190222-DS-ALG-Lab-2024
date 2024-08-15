package logic;

public class Item {
	private String name;
	private int pricePerPiece;
	
	public Item (String name, int pricePerPiece) {
		this.name = name;
		setPricePerPiece (pricePerPiece);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerPiece() {
		return pricePerPiece;
	}
	
	public void setPricePerPiece (int pricePerPiece) {
		if (pricePerPiece >= 1) {
			this.pricePerPiece = pricePerPiece;
		}
		else {
			this.pricePerPiece = 1;
		}
	}
}