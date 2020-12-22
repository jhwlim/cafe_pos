package test;

import common.model.StockVO;
import stock.dao.StockDao;
import stock.dao.StockDaoImpl;

public class StockDaoTest {

	public static void main(String[] args) {
		
		StockDao dao = StockDaoImpl.getInstance();
		
		StockVO stock = new StockVO();
		stock.setMenuId(42);
		stock.setAmount(20);
		stock.setMaker("제조사A");
		dao.insert(stock);
		
		System.out.println("완료");
		
	}
}
