package employee.controller.button;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import employee.component.button.EmpMenuBtnEnum;
import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class EmpMenuClickListener implements ActionListener{

	static Container container;
	
	static {
		container = ContentPanel.getPanel(MenuBtnEnum.EMPLOYEE);
	}
	
	EmpMenuBtnEnum embe;
	
	public EmpMenuClickListener(EmpMenuBtnEnum embe) {
		this.embe = embe;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) container.getLayout()).show(container, embe.pageName);
	}

}
