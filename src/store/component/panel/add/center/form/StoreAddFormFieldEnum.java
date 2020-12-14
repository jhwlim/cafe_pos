package store.component.panel.add.center.form;

public enum StoreAddFormFieldEnum {
	
	ADDR("매장 주소"),
	SIZE("매장 크기"),
	TYPE("매장 타입");
	
	public String korName;
	
	private StoreAddFormFieldEnum(String korName) {
		this.korName = korName;
	}
}
