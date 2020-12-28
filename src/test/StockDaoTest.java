package test;

import common.model.StockVO;
import stock.dao.StockDao;
import stock.dao.StockDaoImpl;
import store.common.config.StoreConfig;

public class StockDaoTest {

	public static void main(String[] args) {
		
		StockDao dao = StockDaoImpl.getInstance();
		
//		int menuIdStartIdx = 41;
//		int menuIdEndIdx = 50;
//		
//		for (int i = menuIdStartIdx; i < menuIdEndIdx; i++) {
//			StockVO stock = new StockVO();
//			stock.setMenuId(i);
//			stock.setAmount(10);
//			stock.setMaker("제조사B");
//			stock.setStoreId(StoreConfig.getStoreId());		
//			dao.insert(stock);
//		}
		
		
		StockVO stock = new StockVO();
		stock.setMenuId(41);
		stock.setAmount(5);
		stock.setMaker("제조사B");
		stock.setStoreId(StoreConfig.getStoreId());		
		dao.insert(stock);
		System.out.println("완료");
		
	}
}
