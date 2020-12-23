package stock.component;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.font.SidePanelTitleLabelFont;
import employee.component.button.menu.EmpMenuBtn;
import employee.component.panel.menu.EmpMenuTitlePanel;

public class StockPanel extends JPanel{
	
	public static JPanel btn1Panel;
		
	public StockPanel() {
		this.setLayout(new CardLayout());
		
		JPanel stockMenuPanel = new JPanel();
		stockMenuPanel.setLayout(new CardLayout(320, 70));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new CardLayout(70, 50));
		centerPanel.setBackground(Color.white);
		stockMenuPanel.add(centerPanel);
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BorderLayout(0, 20));
		innerPanel.setBackground(Color.white);
		centerPanel.add(innerPanel);
		
		JPanel titlePanel = StockMenuTitlePanel.getInstance();
		innerPanel.add(titlePanel, BorderLayout.NORTH);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setBackground(Color.white);
		innerPanel.add(btnPanel, BorderLayout.CENTER);
		
		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelPanel.setPreferredSize(new Dimension(200, EmpMenuBtn.BTN_HEIGHT + 30));
		labelPanel.setBackground(Color.white);
		btnPanel.add(labelPanel);
		
		JLabel label = new JLabel("재고 관리");
		label.setFont(new SidePanelTitleLabelFont()); 
		labelPanel.add(label);
		
//		JLabel label1 = new JLabel("재고관리 페이지");
//	    label1.setBounds(425, 100, 200, 200); 
//	    innerPanel.add(label1);
		
		JPanel btnPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPanel1.setBackground(Color.white);
		btnPanel1.setPreferredSize(new Dimension(200, EmpMenuBtn.BTN_HEIGHT + 10));
		btnPanel.add(btnPanel1);
		
		JButton btn1 = new JButton("재고확인");
		btn1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn1.setBackground(new Color(0x006600));
		btn1.setForeground(Color.white);
		btn1.setPreferredSize(new Dimension(130, 60));
		btnPanel1.add(btn1);
		
		JPanel btnPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPanel2.setBackground(Color.white);
		btnPanel2.setPreferredSize(new Dimension(200, EmpMenuBtn.BTN_HEIGHT + 10));
		btnPanel.add(btnPanel2);
		
		JButton btn2 = new JButton("발주");
		btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn2.setBackground(new Color(0x006600));
		btn2.setForeground(Color.white);
		btn2.setPreferredSize(new Dimension(130, 60));
		btnPanel2.add(btn2);
		
		JPanel imgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		imgPanel.setBackground(Color.white);
		btnPanel.add(imgPanel);
		
		try {
			JLabel imglabel = new JLabel(new ImageIcon(ImageIO.read(new File("resources/img/design/img1.jpg")).getScaledInstance(220, 220, Image.SCALE_SMOOTH)));
			imgPanel.add(imglabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
