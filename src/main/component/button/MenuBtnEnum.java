package main.component.button;

public enum MenuBtnEnum {
	
	ORDER("주문", "order.view.OrderView", 0xDDE120),
	STOCK("재고관리", "stock.view.Stockview", 0x20E124),
	EMPLOYEE("직원관리", "employee.view.EmployeeView", 0x207CE1),
	STORE("매장정보관리", "store.view.StoreView", 0x7CE120),
	ORDERLIST("대기주문확인", "orderlist.view.OrderListView", 0xE17C20);
	
	public String btnName;
	public String classpath;
	public int colorNum;
	
	private MenuBtnEnum(String btnName, String classpath, int colorNum) {
		this.btnName = btnName;
		this.classpath = classpath;
		this.colorNum = colorNum;
	}
}
