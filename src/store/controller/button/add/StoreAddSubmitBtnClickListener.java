package store.controller.button.add;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.model.EmployeeVO;
import common.model.StoreVO;
import employee.component.panel.register.EmpRegFormFieldEnum;
import employee.component.panel.register.EmpRegFormInputPanel;
import employee.component.panel.register.EmpRegFormPanel;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import employee.view.EmployeeView;
import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
import store.component.panel.add.center.form.StoreAddFormFieldEnum;
import store.component.panel.add.center.form.StoreAddFormInputPanel;
import store.component.panel.add.center.form.StoreAddFormPanel;
import store.controller.mouse.add.StoreAddTextClickActionListener;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;
import store.view.StoreView;

public class StoreAddSubmitBtnClickListener implements ActionListener {
	
	static Container container;
	static String menuPageName;
	
	static {
		container = StoreView.getContentPanel();
		menuPageName = EmployeeView.MENU_PAGE_NAME;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		StoreVO store = new StoreVO();
		
		StoreAddFormInputPanel panel = StoreAddFormPanel.getCenterPanel();
		
		boolean nameChk = true;
		boolean sizeChk = true;
		
		if (panel != null) {
			for (StoreAddFormFieldEnum field : StoreAddFormFieldEnum.values()) {
				JComponent component = panel.getComponentValue(field);
				
				if (field != StoreAddFormFieldEnum.TYPE) {
					String input = ((JTextField) component).getText();
					
					switch (field) {
					case NAME :
						if (input.length() == 0) {
							JTextField text = (JTextField) component;
							text.setText("매장명을 입력해주세요");
							text.setForeground(Color.red);
							text.addMouseListener(new StoreAddTextClickActionListener(text));
							nameChk = false;
						} else {
							store.setStoreName(input);							
						}
						break;
					case ADDR :
						store.setStoreAddr(input);
						break;
					case SIZE :
						if (input.length() != 0) {
							try {
								store.setStoreSize(Integer.parseInt(input));
							} catch (Exception e2) {
								sizeChk = false;
							}
						}
						break;
					}
					
				} else {
					int input = (int) ((JComboBox) component).getSelectedIndex();
					store.setStoreType(input);
				}
			}
			
			if (nameChk && sizeChk) {
				System.out.println(store);
				StoreDao dao = StoreDaoImpl.getInstance();
				dao.insert(store);
				((CardLayout) container.getLayout()).show(container, menuPageName);
			} else {
				System.out.println("매장 추가 실패");
			}	
		} 
		
		
	}
	
}
