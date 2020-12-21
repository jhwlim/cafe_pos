package orderlist.component.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import orderlist.common.config.OrderListConfig;
import orderlist.view.OrderListView;

public class OrderListBtnPanel extends JPanel {
	
	public OrderListBtnPanel(int index) {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton btn = new JButton("완료");
		btn.setPreferredSize(new Dimension(80, 50));
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderListConfig.getList().remove(index);
				new OrderListView();
			}
		});
	}
}
