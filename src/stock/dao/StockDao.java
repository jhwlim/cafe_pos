package stock.dao;

import java.util.List;

import common.model.StockVO;

public interface StockDao {
	
	public List<StockVO> selectAll(String name);
	
	public void insert(StockVO stock);

}
