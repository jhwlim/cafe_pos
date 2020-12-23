package order.controller.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import order.dao.StockDao;
import order.dao.StockDaoImpl;

public class MenuMouseClickListener extends MouseAdapter {

	int menuId;
	
	public MenuMouseClickListener(int menuId) {
		this.menuId = menuId;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {
			StockDao stockDao = StockDaoImpl.getInstance();
			int totalAmount = stockDao.selectAmountOfMenu(menuId);
			
			JOptionPane.showMessageDialog(null, "현재 재고 : " + totalAmount, "재고 현황", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
