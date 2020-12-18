package employee.component.combobox;

public enum EmpRankEnum {
	
	RANK1("직급1"),
	RANK2("직급2"),
	RANK3("직급3");
	
	public String korName;
	
	private EmpRankEnum(String korName) {
		this.korName = korName;
	}
}
