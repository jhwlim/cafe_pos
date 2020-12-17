package main.controller.btn;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
import main.component.panel.FramePanelEnum;
import main.view.ContentView;
import main.view.MainView;

public class MenuBtnClickListener implements ActionListener {

	static Container container;
	static Container contentContainer;
	MenuBtnEnum mbe;
	
	static {
		container = MainView.getMainFrame().getContentPane();
		contentContainer = ContentPanel.getInstance();
	}
	public MenuBtnClickListener(MenuBtnEnum mbe) {
		this.mbe = mbe;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		new ContentView(mbe);
		
		try {
			Class.forName(mbe.classpath).getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		((CardLayout) container.getLayout()).show(container, FramePanelEnum.CONTENT.toString());
		((CardLayout) contentContainer.getLayout()).show(contentContainer, mbe.toString());
		
		
	}

}
