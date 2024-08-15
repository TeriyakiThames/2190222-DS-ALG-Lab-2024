package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;

	public Order() {
		this.orderNumber = totalOrderCount;
		totalOrderCount++;
		this.orderItemList = new ArrayList<>();
	}

	public OrderItem addItem(Item item, int amount) {
	    for (OrderItem orderItem : orderItemList) {
	    	if (amount < 0) {
		        return orderItem;
		    }
	        if (orderItem.getItem().equals(item)) {
	            orderItem.setItemAmount(orderItem.getItemAmount() + amount);
	            return orderItem;
	        }
	    }

	    OrderItem newOrderItem = new OrderItem(item, amount);
	    orderItemList.add(newOrderItem);
	    return newOrderItem;
	}


	public int calculateOrderTotalPrice() {
		int sumAmount = 0;
		for (OrderItem orderItem : orderItemList) {
			sumAmount += orderItem.calculateTotalPrice();
		}
		return (int) sumAmount;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}

	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}

}
