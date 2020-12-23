package main.component.button;

public enum MenuBtnEnum {
	
	ORDER("주문", "order.view.OrderView"),
	ORDERLIST("대기주문확인", "orderlist.view.OrderListView"),
	STOCK("재고관리", "stock.view.StockView"),
	EMPLOYEE("직원관리", "employee.view.EmployeeView"),
	STORE("매장정보관리", "store.view.StoreView");
	
	public String btnName;
	public String classpath;
	
	private MenuBtnEnum(String btnName, String classpath) {
		this.btnName = btnName;
		this.classpath = classpath;
	
	}
}
