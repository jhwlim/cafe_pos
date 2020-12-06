package common.font;

import java.awt.Font;

public class MenuBtnFont extends Font {
	
	static final String FONT_TYPE = "맑은 고딕";
	static final int FONT_STYLE = Font.PLAIN;
	static final int FONT_SIZE = 25;
	
	public MenuBtnFont() {
		super(FONT_TYPE, FONT_STYLE, FONT_SIZE);
	}
}
