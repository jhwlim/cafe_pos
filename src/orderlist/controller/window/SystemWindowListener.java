package orderlist.controller.window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.model.OrdersDetailVO;
import orderlist.common.config.OrderListConfig;

public class SystemWindowListener extends WindowAdapter {

	private static final String prefix = "resources/settings/";
	private static final String fileName = "orderlist.sav"; 

	@Override
	public void windowOpened(WindowEvent e) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(prefix + fileName));
			String str = br.readLine();
			if (str != null) {
				JSONParser parser = new JSONParser();
				JSONArray jsonArr = (JSONArray) parser.parse(str);
				List<OrdersDetailVO> list = new ArrayList<>();
				for (int i = 0; i < jsonArr.size(); i++) {
					JSONObject obj = (JSONObject) jsonArr.get(i);

					OrdersDetailVO detail = new OrdersDetailVO();
					int orderId = Integer.parseInt(obj.get("orderId").toString());
					int menuId = Integer.parseInt(obj.get("menuId").toString());
					String menuName = obj.get("menuName").toString();
					int menuCount = Integer.parseInt(obj.get("menuCount").toString());
					int discountedCost = Integer.parseInt(obj.get("discountedCost").toString());
					Timestamp orderDate = Timestamp.valueOf(obj.get("orderDate").toString());
					
					detail.setOrderId(orderId);
					detail.setMenuId(menuId);
					detail.setMenuName(menuName);
					detail.setMenuCount(menuCount);
					detail.setDiscountedCost(discountedCost);
					detail.setOrderDate(orderDate);
					
					list.add(detail);
					OrderListConfig.setList(list);
				}

			}

		} catch (FileNotFoundException e1) {
			System.out.println(prefix + fileName + " 파일을 찾을 수 없습니다.");
//			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	@Override
	public void windowClosing(WindowEvent e) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(prefix + fileName));

			List<OrdersDetailVO> list = OrderListConfig.getList();
			JSONArray jsonArr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject obj = new JSONObject();

				OrdersDetailVO detail = list.get(i);

				obj.put("orderId", detail.getOrderId());
				obj.put("menuId", detail.getMenuId());
				obj.put("menuName", detail.getMenuName());
				obj.put("menuCount", detail.getMenuCount());
				obj.put("discountedCost", detail.getDiscountedCost());
				obj.put("orderDate", detail.getOrderDate().toString());

				jsonArr.add(obj);
			}


			bw.write(jsonArr.toString());
			bw.flush();
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


	}
}
