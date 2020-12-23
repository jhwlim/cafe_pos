package store.controller.button.add;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import employee.view.EmployeeView;
import main.component.button.MenuBtnEnum;
import main.component.panel.content.ContentPanel;
import store.view.StoreView;

public class StoreAddCancelBtnClickListener implements ActionListener {

	static Container container;
	static String menuPageName;
	static {
		container = StoreView.getContentPanel();
		menuPageName = StoreView.MENU_PAGE_NAME;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) container.getLayout()).show(container, menuPageName);
	}

}
