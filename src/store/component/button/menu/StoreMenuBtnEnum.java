package store.component.button.menu;

public enum StoreMenuBtnEnum {
	
	ADD("add", "resources/img/store/menu/add.png", "store.view.StoreAddView"),
	REGISTER("register", "resources/img/store/menu/register.png", "store.view.StoreSaveView");
	
	public String pageName;
	public String imgPath;
	public String classPath;
	
	private StoreMenuBtnEnum(String pageName, String imgPath, String classPath) {
		this.pageName = pageName;
		this.imgPath = imgPath;
		this.classPath = classPath;
	}
}
