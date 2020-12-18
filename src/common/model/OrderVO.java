package common.model;

import java.sql.Date;

public class OrderVO {
	
	private int orderId;
	private int storeId;
	private Date orderDate;
	
	public OrderVO() {
	}

	public OrderVO(int orderId, int storeId, Date orderDate) {
		super();
		this.orderId = orderId;
		this.storeId = storeId;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", storeId=" + storeId + ", orderDate=" + orderDate + "]";
	}
	
	
	
}
