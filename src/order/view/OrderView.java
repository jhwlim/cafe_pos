package order.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class OrderView {

	public static JPanel panel;
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.ORDER);
		
	}
	
	public OrderView() {
		
		// 패널 초기화
		panel.removeAll();
		
		// ↓↓↓↓↓↓↓↓↓↓↓↓ 코드 작성 영역 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		panel.add(new JLabel("주문하기 페이지"));
	}
}
