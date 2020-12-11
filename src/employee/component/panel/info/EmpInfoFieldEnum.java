package employee.component.panel.info;

public enum EmpInfoFieldEnum {
	
	EMP_ID("사번"),
	NAME("이름"),
	NICK("닉네임"),
	BIRTH("생년월일"),
	CERTIF("보건증 만료일자"),
	RANK("직급"),
	JOIN_DATE("입사일"),
	STORE_ID("매장번호");
	
	public String korName;
	
	private EmpInfoFieldEnum(String korName) {
		this.korName = korName;
	}
}
