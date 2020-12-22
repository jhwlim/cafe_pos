package stock.component;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import common.model.StockVO;
import stock.dao.StockDao;
import stock.dao.StockDaoImpl;
import stock.view.Stockview;

public class StockCheck extends JPanel{
	
	public StockCheck() {
		this.setLayout(new CardLayout());
		this.setLayout(null);
		
		
		JLabel stockCheck = new JLabel("재고 확인");
		this.add(stockCheck);
		stockCheck.setBounds(450, 0, 100, 100);
		
		
		//////////// 기본 재고 테이블
		DefaultTableModel model;
		String header[] = {"재고번호","메뉴번호","매장번호","재고 수량","입고 일자","제조사","메뉴 이름"};
		Object ob[][] = {};
		model = new DefaultTableModel(ob,header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		this.add(scrollpane);
		scrollpane.setBounds(50, 200,900,400);
		
		// 테이블을 수정할 수 없도록 추가
		table.setDefaultEditor(Object.class, null);
		
		StockDao dao = StockDaoImpl.getInstance();
		
		List<StockVO> list = dao.selectAll("");
		
		for (int i = 0; i < list.size(); i++) {
			StockVO stock = list.get(i);
			Object data[] = {stock.getStockId(),
						     stock.getMenuId(),
						     stock.getStoreId(),
						     stock.getAmount(),
						     stock.getDate(),
						     stock.getMaker(),
						     stock.getMenuName()};
			model.addRow(data);
		}
		
		//여기까지
		
		////////검색 눌렀을때 해당 결과만 보여줄 테이블
		JTextField search1 = new JTextField(20);
		this.add(search1);
		search1.setBounds(650, 100,200,40);
		
		JButton searchBtn1 = new JButton("검색");
		this.add(searchBtn1);
		searchBtn1.setBounds(850, 100, 60, 40);
		searchBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);// 기존 테이블의 행을 모두 삭제
				
				String name = search1.getText();
				
				List<StockVO> list = dao.selectAll(name);
				
				for (int i = 0; i < list.size(); i++) {
					StockVO stock = list.get(i);
					Object data[] = {stock.getStockId(),
								     stock.getMenuId(),
								     stock.getStoreId(),
								     stock.getAmount(),
								     stock.getDate(),
								     stock.getMaker(),
								     stock.getMenuName()};
					model.addRow(data);
				}
				
			}
		});
		//여기까지
		
		JButton backBtn1 = new JButton("뒤로가기");
		this.add(backBtn1);
		backBtn1.setBounds(800, 700, 100, 100);
		backBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel thisPanel = Stockview.stockMain;
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "stockMenu");
			}
		});
		
	}
}
