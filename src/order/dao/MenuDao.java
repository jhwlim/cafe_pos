package order.dao;

import java.util.List;

import common.model.MenuVO;

public interface MenuDao {
	
	public List<MenuVO> selectAll();
	
	public List<String> selectByCategory(String category); 
	 
}
