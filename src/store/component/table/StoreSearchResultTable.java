package store.component.table;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import common.model.EmployeeVO;
import common.model.StoreVO;
import store.component.panel.save.info.StoreInfoFieldEnum;

public class StoreSearchResultTable extends AbstractTableModel {

	static String[] fieldNames;

	static {
		fieldNames = new String[StoreInfoFieldEnum.values().length];
		for (StoreInfoFieldEnum field : StoreInfoFieldEnum.values()) {
			fieldNames[field.ordinal()] = field.toString(); 
		}
	}

	List<StoreVO> list;

	public StoreSearchResultTable(List<StoreVO> list) {
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
		StoreInfoFieldEnum field = StoreInfoFieldEnum.values()[columnIndex];

		switch (field) {
		case STORE_ID :
			return list.get(rowIndex).getStoreId();
		case NAME :
			return list.get(rowIndex).getStoreName();
		case ADDR :
			return list.get(rowIndex).getStoreAddr();
		case SIZE :
			return list.get(rowIndex).getStoreSize();
		case TYPE :
			return list.get(rowIndex).getStoreType();
		}
		
		return null;
	}
}