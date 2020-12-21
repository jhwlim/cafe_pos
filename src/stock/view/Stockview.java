
package stock.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtn;
import main.component.button.MenuBtnEnum;
import main.component.panel.content.ContentPanel;
import main.controller.btn.MenuBtnClickListener;
import stock.component.StockPanel;
 
public class Stockview {

	public static JPanel panel;
	static JButton[] store_btns = new JButton[3];
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.STOCK);// 카드 레이아웃
		
		// panel에 작업하는게 왼쪽 영역에 표시됨.
		panel.setLayout(new CardLayout());
	
//		JPanel stackbtnView = new JPanel();
//		panel.add("stack page", stackbtnView);
//		
//		stackbtnView.setLayout(null);
//		JLabel label1 = new JLabel("재고관리 페이지");
//	    label1.setBounds(400, 100, 200, 200);
//	    stackbtnView.add(label1);
//	    
//	  
//	    for (int i = 0; i < 3; i++) {store_btns[i] = new JButton("store"+(i+1));}
//	    	
//    	store_btns[0].setBounds(400, 300, 100, 100);
//    	store_btns[1].setBounds(400, 450, 100, 100);
//    	store_btns[2].setBounds(400, 600, 100, 100);
//	    
//    	
//	    for (int j = 0; j < store_btns.length; j++) {stackbtnView.add(store_btns[j]);}
//			
	    
	    //----------------store1의 버튼들---------------------
	    JPanel store1 = new StockPanel();
	    
	    panel.add("store1", store1);
		
//		if(store_btns[0] != null) {
//			store_btns[0].addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					((CardLayout) panel.getLayout()).show(panel, "store1");
//					
//				}
//			});
//		}
//		//----------------store2의 버튼들---------------------
//		JPanel store2 = new StockPanel();
//		panel.add("store2", store2);
//		
//		if(store_btns[1] != null) {
//			store_btns[1].addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					((CardLayout) panel.getLayout()).show(panel, "store2"); 
//				}
//			});
//		}
//		
//		//----------------store3의 버튼들---------------------
//		JPanel store3 = new StockPanel();
//		panel.add("store3", store3);
//		
//		if(store_btns[2] != null) {
//			store_btns[2].addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					((CardLayout) panel.getLayout()).show(panel, "store3"); 
//				}
//			});
//		}
//		
//		
	}
	
	public Stockview() {
		
		((CardLayout) panel.getLayout()).show(panel, "stack page"); 
		
	}
	
}
