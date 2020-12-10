package employee.component.table;

public enum EmpTableFieldEnum {
	EMP_ID("사번"),
	EMP_NAME("이름"),
	EMP_NICK("닉네임"),
	EMP_BIRTH("생년월일"),
	CERIF_EXPIRED_DATE("보건증 만료일자"),
	EMP_RANK("직원 등급"),
	JOIN_DATE("입사일자"),
	STORE_ID("소속 매장");
	
	String fieldName;
	
	private EmpTableFieldEnum(String fieldName) {
		this.fieldName = fieldName;
	}
}
