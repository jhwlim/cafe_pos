package store.component.combobox;

public enum StoreTypeEnum {
	
	TYPE1("매장타입1"),
	TYPE2("매장타입2"),
	TYPE3("매장타입3");
	
	public String korName;
	
	private StoreTypeEnum(String korName) {
		this.korName = korName;
	}
}
