package employee.controller.button;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

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
		try {
			Class.forName(embe.classPath).getConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException 
				| SecurityException e1) {
			e1.printStackTrace();
		}
		((CardLayout) container.getLayout()).show(container, embe.pageName);
	}

}
