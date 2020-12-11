package stock.component;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockPanel extends JPanel{
	
	public StockPanel() {
		this.setLayout(new CardLayout());
		
		JPanel storeMenuPanel = new JPanel();
		
		storeMenuPanel.setLayout(null);
		
		JButton btn1 = new JButton("Store Info");
		btn1.setBounds(200, 400, 100, 100);
		storeMenuPanel.add(btn1);
		
		JButton btn2 = new JButton("재고 확인");
		btn2.setBounds(400, 400, 100, 100);
		storeMenuPanel.add(btn2);
		
		JButton btn3 = new JButton("발주");
    	btn3.setBounds(600, 400, 100, 100);
    	storeMenuPanel.add(btn3);
		
    	this.add("storeMenu", storeMenuPanel);

    	JPanel thisPanel = this;
    	
		JPanel btn1Panel = new JPanel();
		this.add("1", btn1Panel);
		
		btn1Panel.add(new JLabel("Store Info"));
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "1");
			}
		});
		
		JButton backBtn1 = new JButton("뒤로가기");
		btn1Panel.add(backBtn1);
		backBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
		
		////////
		JPanel btn2Panel = new JPanel();
		this.add("2", btn2Panel);
		
		btn2Panel.add(new JLabel("재고 확인"));
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "2");
			}
		});
		
		JButton backBtn2 = new JButton("뒤로가기");
		btn2Panel.add(backBtn2);
		backBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
		
		/////////
		JPanel btn3Panel = new JPanel();
		this.add("3", btn3Panel);
		
		btn3Panel.add(new JLabel("발주"));
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "3");
			}
		});
    	
		JButton backBtn3 = new JButton("뒤로가기");
		btn3Panel.add(backBtn3);
		backBtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
	}

}
