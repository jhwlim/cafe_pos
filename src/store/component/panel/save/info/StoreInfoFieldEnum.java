package store.component.panel.save.info;

public enum StoreInfoFieldEnum {
	
	STORE_ID("매장 번호 : "),
	NAME("매장명 : "),
	ADDR("매장 주소 : "),
	SIZE("매장 크기 : "),
	TYPE("매장 타입 : ");
	
	public String korName;
	
	private StoreInfoFieldEnum(String korName) {
		this.korName = korName;
	}
}
