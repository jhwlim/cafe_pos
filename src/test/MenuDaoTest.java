package test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import common.model.MenuVO;
import order.dao.MenuDao;
import order.dao.MenuDaoImpl;

public class MenuDaoTest {
	
public static void main(String[] args) {
		
		MenuDao dao = MenuDaoImpl.getInstance();
		
		List<MenuVO> list = dao.selectAll();
		
		for (int i = 0; i < list.size(); i++) {
			MenuVO menu = list.get(i);
//			System.out.println(menu.getMenuImg());
			
			// 이미지 아이콘
			try {
				ImageIO.read(new File(menu.getMenuImg()));
				System.out.println("테스트성공");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
