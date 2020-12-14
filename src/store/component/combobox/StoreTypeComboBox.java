package store.component.combobox;

import javax.swing.JComboBox;

public class StoreTypeComboBox extends JComboBox<String> {
	
	private static String[] comboBoxNames;
	
	static {
		comboBoxNames = new String[StoreTypeEnum.values().length];
		for (int i = 0; i < comboBoxNames.length; i++) {
			comboBoxNames[i] = StoreTypeEnum.values()[i].korName;
		}
	}
	
	public StoreTypeComboBox() {
		super(comboBoxNames);
	}
}
