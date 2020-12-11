package employee.component.combobox;

import javax.swing.JComboBox;

public class EmpRankComboBox extends JComboBox<String> {
	
	private static String[] comboBoxNames;
	
	static {
		comboBoxNames = new String[EmpRankEnum.values().length];
		for (int i = 0; i < comboBoxNames.length; i++) {
			comboBoxNames[i] = EmpRankEnum.values()[i].korName;
		}
	}
	
	public EmpRankComboBox() {
		super(comboBoxNames);
	}
}
