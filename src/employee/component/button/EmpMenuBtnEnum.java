package employee.component.button;

public enum EmpMenuBtnEnum {
	
	INSERT("register", "resources/img/employee/menu/register.png", "employee.view.EmpRegView"),
	SELECTALL("search", "resources/img/employee/menu/search.png", "employee.view.EmpSearchView");
	
	public String pageName;
	public String imgPath;
	public String classPath;
	
	private EmpMenuBtnEnum(String pageName, String imgPath, String classPath) {
		this.pageName = pageName;
		this.imgPath = imgPath;
		this.classPath = classPath;
	}
}
