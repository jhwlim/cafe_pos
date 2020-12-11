package employee.common.font;

import java.awt.Font;

public class EmpRegErrorFont extends Font {
	static final String FONT_TYPE = "맑은 고딕";
	static final int FONT_STYLE = Font.BOLD;
	static final int FONT_SIZE = 12;
	
	public EmpRegErrorFont() {
		super(FONT_TYPE, FONT_STYLE, FONT_SIZE);
	}
}
