package orderlist.component.panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import orderlist.component.table.OrderListTableModel;
import orderlist.component.table.OrderListTableCell;

public class OrderListTablePanel extends JPanel {

	public static final Color PANEL_COLOR = OrderListPanel.PANEL_COLOR;
	
	public OrderListTablePanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public void setDefaultConfig() {
		setLayout(new CardLayout());
		setBackground(PANEL_COLOR);
	}
	
	public void setComponents() {
		JTable table = new JTable(new OrderListTableModel());
		
//		OrderListTableCell olstc = new OrderListTableCell(table);
		
		table.getColumn(table.getModel().getColumnName(5)).setCellEditor(new OrderListTableCell(table));
		table.getColumn(table.getModel().getColumnName(5)).setCellRenderer(new OrderListTableCell(table));
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, cellRenderer);
		
		// 테이블 컬럼 사이즈 조절
		for (int i = 0; i < table.getColumnCount(); i++) {
			int width = 20;
			switch (i) {
			case 2 :
				width = 100;
				break;
			case 4 :
				width = 110;
				break;
			case 5 :
				width = 60;
				break;
			}
			TableColumn col = table.getColumnModel().getColumn(i);
			
			if (i != 5) {
				col.setCellRenderer(cellRenderer);
			}
			
			col.setPreferredWidth(width);
		}
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		add(scroll);
		
	}
	
}
