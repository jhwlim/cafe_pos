package store.component.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONObject;

import common.model.EmployeeVO;
import common.model.StoreVO;
import employee.component.panel.info.EmpInfoPanel;
import employee.component.panel.register.EmpRegCenterPanel;
import main.view.MainView;
import store.common.config.StoreConfig;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;
import store.view.StoreView;

public class StoreSaveChkFrame extends JFrame {
	
	static final int FRAME_WIDTH = 200;
	static final int FRAME_HEIGHT = 150;
	
	private static final int X_MARGIN = 5;
	private static final int Y_MARGIN = 5;
	
	private static final Color BG_COLOR = Color.gray;
	
	private static StoreSaveChkFrame frame;
	
	public StoreSaveChkFrame(int storeId) {
		frame = this;
		setDefaultConfig();
		setComponents(storeId);
	}
	
	private void setDefaultConfig() {
		setTitle("Check");
		
		setLayout(new BorderLayout()); 
		
		getContentPane().setBackground(BG_COLOR); 
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		
		setLocationRelativeTo(null); 
		
		setVisible(true);
	}
	
	private void setComponents(int storeId) {
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new CardLayout());
		JLabel text = new JLabel("매장 정보를 저장하시겠습니까?");
		text.setHorizontalAlignment(JLabel.CENTER);
		centerPanel.add(text);
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton cancelBtn = new JButton("취소");
		JFrame thisFrame = this;
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thisFrame.dispose();
			}
			
		});
		bottomPanel.add(cancelBtn);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(StoreConfig.getFilePath()));
					
					JSONObject obj = new JSONObject();
					
					obj.put("STORE_ID", storeId);
					
					bw.write(obj.toString());
					bw.flush();
					bw.close();
					
					thisFrame.dispose();
					
					Container container = StoreView.getContentPanel();
					((CardLayout) container.getLayout()).show(container, "MENU");
					MainView.getMainFrame().dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		bottomPanel.add(saveBtn);
		add(bottomPanel, BorderLayout.SOUTH);
		
	}
	
}
