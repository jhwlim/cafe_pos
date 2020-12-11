package employee.common.font;

import java.awt.Font;

public class EmpRegRemarkFont extends Font {
	
	static final String FONT_TYPE = "맑은 고딕";
	static final int FONT_STYLE = Font.ITALIC;
	static final int FONT_SIZE = 14;
	
	public EmpRegRemarkFont() {
		super(FONT_TYPE, FONT_STYLE, FONT_SIZE);
	}
}
