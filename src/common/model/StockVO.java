package common.model;

import java.sql.Date;

public class StockVO {
	
	private int stockId;
	private int menuId;
	private int storeId;
	private int amount;
	private Date inDate;
	private String maker;
	
	public StockVO() {
		// TODO Auto-generated constructor stub
	}

	public StockVO(int stockId, int menuId, int storeId, int amount, Date inDate, String maker) {
		super();
		this.stockId = stockId;
		this.menuId = menuId;
		this.storeId = storeId;
		this.amount = amount;
		this.inDate = inDate;
		this.maker = maker;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "StockVO [stockId=" + stockId + ", menuId=" + menuId + ", storeId=" + storeId + ", amount=" + amount
				+ ", inDate=" + inDate + ", maker=" + maker + "]";
	}
	
	
}
