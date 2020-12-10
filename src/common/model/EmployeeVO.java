package common.model;

import java.sql.Date;

public class EmployeeVO {
	
	private int empId;
	private String empName;
	private String empBirth;
	private int empRank;
	private String empNick;
	private Date joinDate;
	private String CertifExpireDate;
	private int storeId;
	
	public EmployeeVO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeVO(int empId, String empName, String empBirth, int empRank, String empNick, Date joinDate,
			String certifExpireDate, int storeId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empBirth = empBirth;
		this.empRank = empRank;
		this.empNick = empNick;
		this.joinDate = joinDate;
		CertifExpireDate = certifExpireDate;
		this.storeId = storeId;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpBirth() {
		return empBirth;
	}
	public void setEmpBirth(String empBirth) {
		this.empBirth = empBirth;
	}
	public int getEmpRank() {
		return empRank;
	}
	public void setEmpRank(int empRank) {
		this.empRank = empRank;
	}
	public String getEmpNick() {
		return empNick;
	}
	public void setEmpNick(String empNick) {
		this.empNick = empNick;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getCertifExpireDate() {
		return CertifExpireDate;
	}
	public void setCertifExpireDate(String certifExpireDate) {
		CertifExpireDate = certifExpireDate;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	@Override
	public String toString() {
		return "EmployeeVO [empId=" + empId + ", empName=" + empName + ", empBirth=" + empBirth + ", empRank=" + empRank
				+ ", empNick=" + empNick + ", joinDate=" + joinDate + ", CertifExpireDate=" + CertifExpireDate
				+ ", storeId=" + storeId + "]";
	}
	
	
	
}
