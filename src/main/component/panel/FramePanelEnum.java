package main.component.panel;

import java.awt.Color;

public enum FramePanelEnum {
	LOGO("main.view.LogoView"),
	MENU("main.view.MenuView"),
	CONTENT("main.view.ContentView");
	
	public String classpath;
	
	private FramePanelEnum(String classpath) {
		this.classpath = classpath;
	}
}
