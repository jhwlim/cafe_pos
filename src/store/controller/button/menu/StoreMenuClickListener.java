package store.controller.button.menu;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import employee.component.button.menu.EmpMenuBtnEnum;
import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
import store.component.button.menu.StoreMenuBtnEnum;

public class StoreMenuClickListener implements ActionListener{

	static Container container;
	
	static {
		container = ContentPanel.getPanel(MenuBtnEnum.STORE);
	}
	
	StoreMenuBtnEnum smb;
	
	public StoreMenuClickListener(StoreMenuBtnEnum smb) {
		this.smb = smb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Class.forName(smb.classPath).getConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException 
				| SecurityException e1) {
			e1.printStackTrace();
		}
		((CardLayout) container.getLayout()).show(container, smb.pageName);
	}

}
