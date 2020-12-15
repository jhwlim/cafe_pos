package common.model;

public class OrdersDetailVO {
	
	private int orderId;
	private int menuId;
	private int menuCount;
	private int discountedCost;
	
	public OrdersDetailVO() {
		// TODO Auto-generated constructor stub
	}

	public OrdersDetailVO(int orderId, int menuId, int menuCount, int discountedCost) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.menuCount = menuCount;
		this.discountedCost = discountedCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getMenuCount() {
		return menuCount;
	}

	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}

	public int getDiscountedCost() {
		return discountedCost;
	}

	public void setDiscountedCost(int discountedCost) {
		this.discountedCost = discountedCost;
	}

	@Override
	public String toString() {
		return "OrdersDetailVO [orderId=" + orderId + ", menuId=" + menuId + ", menuCount=" + menuCount
				+ ", discountedCost=" + discountedCost + "]";
	}
	
	
}
