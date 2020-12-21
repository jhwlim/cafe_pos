package employee.controller.button.register;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.model.EmployeeVO;
import employee.component.panel.register.EmpRegFormFieldEnum;
import employee.component.panel.register.EmpRegFormInputPanel;
import employee.component.panel.register.EmpRegFormPanel;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import employee.view.EmployeeView;
import main.component.button.MenuBtnEnum;
import main.component.panel.content.ContentPanel;

// 직원 등록 화면 - 등록 버튼 클릭시 발생하는 이벤트 처리 클래스
public class EmpRegSubmitBtnClickListener implements ActionListener {
	
	static Container container;
	static String menuPageName;
	
	static {
		container = ContentPanel.getPanel(MenuBtnEnum.EMPLOYEE);
		menuPageName = EmployeeView.MENU_PAGE_NAME;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		EmployeeVO employee = new EmployeeVO();
		
		EmpRegFormInputPanel panel = EmpRegFormPanel.getCenterPanel();
		
		boolean nameChk = true;
		boolean nickChk = true;
		boolean birthChk = true;
		boolean certifChk = true;
		boolean storeIdChk = true;
		
		if (panel != null) {
			for (EmpRegFormFieldEnum field : EmpRegFormFieldEnum.values()) {
				JComponent component = panel.getComponentValue(field);
				JLabel errorLabel = panel.getLabel(field);
				
				if (field != EmpRegFormFieldEnum.RANK) {
					String input = ((JTextField) component).getText();
					
					switch (field) {
					case NAME :
						if (input.equals("")) {
							errorLabel.setText("이름을 작성해주세요");
							nameChk = false;
						} else {
							employee.setEmpName(input);
							errorLabel.setText("");
						}
						break;
					case NICK :
						if (input.equals("")) {
							errorLabel.setText("닉네임을 작성해주세요");
							nickChk = false;
						} else {
							employee.setEmpNick(input);
							errorLabel.setText("");
						}
						break;
					case BIRTH :
						if (input.length() == 0) {
							employee.setEmpBirth(input);
							errorLabel.setText("");
						} else if (input.length() == 8) {
							try {
								Integer.parseInt(input);								
								employee.setEmpBirth(input);
								errorLabel.setText("");
							} catch (Exception e2) {
								errorLabel.setText("형식에 맞게 입력해주세요");
								birthChk = false;
							}
						} else {
							errorLabel.setText("형식에 맞게 입력해주세요");
							birthChk = false;
						}
						break;
					case CERTIF :
						if (input.length() == 0) {
							employee.setCertifExpireDate(input);
							errorLabel.setText("");
						} else if (input.length() == 8) {
							try {
								Integer.parseInt(input);								
								employee.setCertifExpireDate(input);
								errorLabel.setText("");
							} catch (Exception e2) {
								errorLabel.setText("형식에 맞게 입력해주세요");
								certifChk = false;
							}
						} else {
							errorLabel.setText("형식에 맞게 입력해주세요");
							certifChk = false;
						}
						break;
					case STORE_ID :
						if (input.length() == 0) {
							employee.setStoreId(-1);
							errorLabel.setText("");
						} else {
							try {
								employee.setStoreId(Integer.parseInt(input));
								errorLabel.setText("");
							} catch (Exception e2) {
								errorLabel.setText("숫자를 입력해주세요");
								storeIdChk = false;
							}
						}
						
						break;
					}
				} else {
					int input = (int) ((JComboBox) component).getSelectedIndex();
					employee.setEmpRank(input);
				}
			}
			
			if (nameChk && nickChk && birthChk && certifChk && storeIdChk) {
				EmployeeDao dao = EmployeeDaoImpl.getInstance();
				dao.insert(employee);
				((CardLayout) container.getLayout()).show(container, menuPageName);
			}
			
		} else {
			System.out.println("회원 등록 실패");
		}
		
		
	}
	
}
