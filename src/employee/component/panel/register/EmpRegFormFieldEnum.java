package employee.component.panel.register;

public enum EmpRegFormFieldEnum {

	NAME("이름"),
	NICK("닉네임"),
	BIRTH("생년월일"),
	CERTIF("보건증 만료일자"),
	STORE_ID("매장번호"),
	RANK("직급");
	
	public String korName;
	
	private EmpRegFormFieldEnum(String korName) {
		this.korName = korName;
	}
}
