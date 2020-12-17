package store.dao;

import java.util.List;

import common.model.StoreVO;

public interface StoreDao {
	
	public void insert(StoreVO store);
	
	public StoreVO selectOne(int storeId);
	
	public List<StoreVO> searchByAddr(String keyword);
	
}
