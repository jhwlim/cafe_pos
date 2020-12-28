package test;

import common.model.EmployeeVO;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import store.common.config.StoreConfig;

public class EmployeeDaoTest {
	
	public static void main(String[] args) {
		
		EmployeeDao dao = EmployeeDaoImpl.getInstance();
		
		for (int i = 0; i < 10; i++) {
			EmployeeVO employee = new EmployeeVO();
			employee.setEmpName("테스트" + i);
			employee.setEmpNick("테스트 별명" + i);
			employee.setStoreId(StoreConfig.getStoreId());
			dao.insert(employee);
		}
		System.out.println("테스트 데이터 삽입 성공");
	}
}
