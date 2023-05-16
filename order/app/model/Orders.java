package org.order.app.model;

public class Orders {
	private int orderId;
	private String order_name;
	private int orderPrice;
	public Orders() {
		super();
	}
	public Orders(int orderId, String order_name, int orderPrice) {
		super();
		this.orderId = orderId;
		this.order_name = order_name;
		this.orderPrice = orderPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", order_name=" + order_name + ", orderPrice=" + orderPrice + "]";
	}
	
	
}
