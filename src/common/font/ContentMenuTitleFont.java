package common.font;

import java.awt.Font;

public class ContentMenuTitleFont extends Font {

	static final String FONT_TYPE = "맑은 고딕";
	static final int FONT_STYLE = Font.CENTER_BASELINE;
	static final int FONT_SIZE = 26;
	
	public ContentMenuTitleFont() {
		super(FONT_TYPE, FONT_STYLE, FONT_SIZE);
	}
}
