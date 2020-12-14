package order.dao;

public class MenuVO {
	private int menuId;
	private String menuName;
	private int menuCost;
	private String menuCategory;
	private String menuImg;
	
	public MenuVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuVO(int menuId, String menuName, int menuCost, String menuCategory, String menuImg) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuCost = menuCost;
		this.menuCategory = menuCategory;
		this.menuImg = menuImg;
	}



	public int getMenuId() {
		return menuId;
	}



	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}



	public String getMenuName() {
		return menuName;
	}



	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}



	public int getMenuCost() {
		return menuCost;
	}



	public void setMenuCost(int menuCost) {
		this.menuCost = menuCost;
	}



	public String getMenuCategory() {
		return menuCategory;
	}



	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}



	public String getMenuImg() {
		return menuImg;
	}



	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}



	@Override
	public String toString() {
		return "MenuVO [menuId=" + menuId + ", menuName=" + menuName + ", menuCost=" + menuCost + ", menuCategory="
				+ menuCategory + ", menuImg=" + menuImg + "]";
	} 
	
	
}
