package store.component.button.add;

import java.awt.Color;

import common.component.button.BasicBtn;
import store.controller.button.add.StoreAddCancelBtnClickListener;

public class CancelBtn extends BasicBtn {
	
	static final int COLOR = 0xcc5252;
	
	public CancelBtn() {
		setText("취소");
		super.setForeground(Color.white);
		super.setBackground(new Color(COLOR));
		
		super.addActionListener(new StoreAddCancelBtnClickListener());
	}
	
}
