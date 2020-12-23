package test;

import common.model.StockVO;
import stock.dao.StockDao;
import stock.dao.StockDaoImpl;
import store.common.config.StoreConfig;

public class StockDaoTest {

	public static void main(String[] args) {
		
		StockDao dao = StockDaoImpl.getInstance();
		
		int menuIdStartIdx = 41;
		int menuIdEndIdx = 86;
		
		for (int i = menuIdStartIdx; i < menuIdEndIdx; i++) {
			StockVO stock = new StockVO();
			stock.setMenuId(i);
			stock.setAmount(10);
			stock.setMaker("제조사A");
			stock.setStoreId(StoreConfig.getStoreId());
			dao.insert(stock);
			
			stock.setMaker("제조사B");
			dao.insert(stock);
		}
		
		System.out.println("완료");
		
	}
}
