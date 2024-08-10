package logic;

public class OrderItem {
	private Item item;
	private int itemAmount;
	
	public OrderItem(Item item, int itemAmount) {
		this.item = item;
		increaseItemAmount(itemAmount);
	}
	
	public void increaseItemAmount (int amount) {
		if (amount >= 0) {
			itemAmount += amount;
		}
		else {
			itemAmount += 0;
		}
	}
	
	public int calculateTotalPrice() {
		if (itemAmount > 0) {
			return itemAmount*item.getPricePerPiece();
		}
		else {
			return 0;
		}
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int addItemAmount) {
		if (addItemAmount >= 0) {
			itemAmount = addItemAmount;			
		}
		else {
			itemAmount = 0;
		}
	}
	
}
