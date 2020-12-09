package employee.controller.button;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import employee.view.EmployeeView;
import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class EmpRegCancelBtnClickListener implements ActionListener {

	static Container container;
	static String menuPageName;
	static {
		container = ContentPanel.getPanel(MenuBtnEnum.EMPLOYEE);
		menuPageName = EmployeeView.MENU_PAGE_NAME;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) container.getLayout()).show(container, menuPageName);
	}

}
