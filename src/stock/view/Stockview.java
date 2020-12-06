package stock.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.btn.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class Stockview {

	public static JPanel panel;
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.STOCK);
	}
	
	public Stockview() {
		// 패널 초기화
		panel.removeAll();

		// ↓↓↓↓↓↓↓↓↓↓↓↓ 코드 작성 영역 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		panel.add(new JLabel("재고관리 페이지"));
	}
}
