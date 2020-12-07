package employee.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.btn.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class EmployeeView {

	public static JPanel panel;
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.EMPLOYEE);
		
	}
	
	public EmployeeView() {
		
		// 패널 초기화
		panel.removeAll();
		
		// ↓↓↓↓↓↓↓↓↓↓↓↓ 코드 작성 영역 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		panel.add(new JLabel("직원관리 페이지"));
		
		
	}
}
