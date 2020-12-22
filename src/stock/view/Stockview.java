
package stock.view;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.content.ContentPanel;

import stock.component.StockPanel;
 
public class Stockview {

	public static JPanel panel;
	public static JPanel stockMain;
	static JButton store_btn = new JButton();
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.STOCK);// 카드 레이아웃
		
		panel.setLayout(new CardLayout());// panel에 작업하는게 왼쪽 영역에 표시됨.
		
	    stockMain = new StockPanel();
	    panel.add("stockMain", stockMain);


	}
	
	public Stockview() {
		((CardLayout) stockMain.getLayout()).show(stockMain, "stockMenu"); 
		((CardLayout) panel.getLayout()).show(panel, "stockMain"); 
		
	}
	
}
