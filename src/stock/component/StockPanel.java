package stock.component;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import stock.component.StockCheck;
import stock.component.StoreOrder;

public class StockPanel extends JPanel{
	
	public StockPanel() {
		this.setLayout(new CardLayout());
		
		JPanel stockMenuPanel = new JPanel();
		stockMenuPanel.setLayout(null);
		
		JLabel label1 = new JLabel("재고관리 페이지");
	    label1.setBounds(425, 100, 200, 200); 
	    stockMenuPanel.add(label1);
		
		JButton btn1 = new JButton("재고 확인");
		btn1.setBounds(300, 400, 100, 100);
		stockMenuPanel.add(btn1);
		
		JButton btn2 = new JButton("발주");
		btn2.setBounds(550, 400, 100, 100);
		stockMenuPanel.add(btn2);
		
		this.add("stockMenu", stockMenuPanel);
		
		JPanel thisPanel = this;	
		
		//--------------------------- 재고 페이지 --------------------------
		JPanel btn1Panel = new StockCheck();
		this.add("1", btn1Panel);

		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "1");
			}
		});
	
		
		//------------------- 발주 페이지 --------------------------------
		JPanel btn2Panel = new StoreOrder();
		this.add("2", btn2Panel);
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "2");
			}
		});
		
	}
	
	

}
