package employee.component.button;

public enum EmpMenuBtnEnum {
	
	INSERT("register", "resources/img/employee/menu/register.png"),
	SELECTALL("search", "resources/img/employee/menu/search.png");
	
	public String pageName;
	public String imgPath;
	
	private EmpMenuBtnEnum(String pageName, String imgPath) {
		this.pageName = pageName;
		this.imgPath = imgPath;
	}
}
