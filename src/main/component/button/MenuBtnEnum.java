package main.component.button;

public enum MenuBtnEnum {
	
	ORDER("주문", "order.view.OrderView"),
	STOCK("재고관리", "stock.view.Stockview"),
	EMPLOYEE("직원관리", "employee.view.EmployeeView");
	
	public String btnName;
	public String classpath;
	
	private MenuBtnEnum(String btnName, String classpath) {
		this.btnName = btnName;
		this.classpath = classpath;
	}
}
