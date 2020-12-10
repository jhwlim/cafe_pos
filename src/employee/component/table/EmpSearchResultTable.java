package employee.component.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import common.model.EmployeeVO;

public class EmpSearchResultTable extends AbstractTableModel {

	static String[] fieldNames;
	
	static {
		fieldNames = new String[EmpTableFieldEnum.values().length];
		for (EmpTableFieldEnum field : EmpTableFieldEnum.values()) {
			fieldNames[field.ordinal()] = field.fieldName; 
		}
	}
	
	List<EmployeeVO> list;
	
	public EmpSearchResultTable(List<EmployeeVO> list) {
		this.list = list;
	}
	
	@Override
	public String getColumnName(int column) {
		return fieldNames[column];
	}
	
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return fieldNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EmpTableFieldEnum field = EmpTableFieldEnum.values()[columnIndex];
		
		switch (field) {
		case EMP_ID :
			return list.get(rowIndex).getEmpId();
		case EMP_NAME:
			return list.get(rowIndex).getEmpName();
		case EMP_NICK :
			return list.get(rowIndex).getEmpNick();
		case EMP_BIRTH :
			return list.get(rowIndex).getEmpBirth();
		case CERIF_EXPIRED_DATE :
			return list.get(rowIndex).getCertifExpireDate();
		case EMP_RANK :
			return list.get(rowIndex).getEmpRank();
		case JOIN_DATE :
			return list.get(rowIndex).getJoinDate();
		case STORE_ID :
			return list.get(rowIndex).getStoreId();
		}
		
		return null;
	}

}
