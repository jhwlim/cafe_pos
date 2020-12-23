
package stock.view;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.content.ContentPanel;

import stock.component.StockPanel;
 
public class StockView {

	public static JPanel panel;
	public static JPanel stockMain;
	static JButton store_btn = new JButton();
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.STOCK);// 카드 레이아웃
		
		panel.setLayout(new CardLayout());// panel에 작업하는게 왼쪽 영역에 표시됨.
	}
	
	public StockView() {
		
		panel.removeAll();
		
		stockMain = new StockPanel();
	    panel.add("stockMain", stockMain);

	    ((CardLayout) stockMain.getLayout()).show(stockMain, "stockMenu"); 
		((CardLayout) panel.getLayout()).show(panel, "stockMain"); 
		
	}
	
}
