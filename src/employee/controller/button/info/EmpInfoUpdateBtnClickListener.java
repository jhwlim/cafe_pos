package employee.controller.button.info;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import common.model.EmployeeVO;
import employee.component.panel.info.EmpInfoBtnPanel;
import employee.component.panel.info.EmpInfoCenterPanel;
import employee.component.panel.info.EmpInfoShowPanel;
import employee.component.panel.register.EmpRegFormFieldEnum;
import employee.component.panel.register.EmpRegFormInputPanel;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;

public class EmpInfoUpdateBtnClickListener implements ActionListener {

	public EmpInfoUpdateBtnClickListener() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		EmpRegFormInputPanel panel = EmpInfoCenterPanel.getCurrentPanel().getFormPanel();
		
		EmployeeVO employee = new EmployeeVO();
		int empId = panel.getEmployee().getEmpId();
		Date joinDate = panel.getEmployee().getJoinDate();
		employee.setEmpId(empId);
		employee.setJoinDate(joinDate);
		
		boolean nameChk = true;
		boolean nickChk = true;
		boolean birthChk = true;
		boolean certifChk = true;
		boolean storeIdChk = true;
		
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
			dao.update(employee);
			
			((JFrame) panel.getParent().getParent().getParent().getParent().getParent().getParent().getParent()).dispose();
			
		}
		
		
	}
	
}
