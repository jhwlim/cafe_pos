package common.model;


public class StockVO {
	
	private int stockId;
	private int menuId;
	private int storeId;
	private int amount;

	private String date;
	private String maker;
	
	private String menuName;


	public StockVO() {
		// TODO Auto-generated constructor stub
	}


	public StockVO(int stockId, int menuId, int storeId, int amount, String date, String maker, String menuName) {

		super();
		this.stockId = stockId;
		this.menuId = menuId;
		this.storeId = storeId;
		this.amount = amount;

		this.date = date;
		this.maker = maker;
		this.menuName = menuName;

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


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;

	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}


	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "StockVO [stockId=" + stockId + ", menuId=" + menuId + ", storeId=" + storeId + ", amount=" + amount
				+ ", date=" + date + ", maker=" + maker + ", menuName=" + menuName + "]";

	}
	
	
}
