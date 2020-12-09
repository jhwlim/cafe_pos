package employee.dao;

import common.model.EmployeeVO;

public interface EmployeeDao {
	
	public void insert(EmployeeVO employee);
	
	public void searchByName(String keyword);
}
