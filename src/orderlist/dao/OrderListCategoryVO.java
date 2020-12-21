package orderlist.dao;

public class OrderListCategoryVO {
	
	private String menuCategory;
	private int count;
	
	public OrderListCategoryVO() {
		// TODO Auto-generated constructor stub
	}

	public OrderListCategoryVO(String menuCategory, int count) {
		super();
		this.menuCategory = menuCategory;
		this.count = count;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderListCategoryDto [menuCategory=" + menuCategory + ", count=" + count + "]";
	}
	
	
}
