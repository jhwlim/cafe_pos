package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.model.OrdersDetailVO;

public class JsonSimpleTest {

	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new FileReader("resources/settings/test"));
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj2 = (JSONObject) parser.parse(br.readLine());
			
			System.out.println(obj2.get("STORE_ID"));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter("resources/settings/test"));
	
		JSONArray jsonArr = new JSONArray();
		for (int i = 0; i < 100; i++) {
			JSONObject obj = new JSONObject();
			
			OrdersDetailVO detail = new OrdersDetailVO(i, i, 2*i, i+1);
			
			obj.put("OrderId", detail.getOrderId());
			obj.put("MenuId", detail.getMenuId());
			obj.put("MenuCount", detail.getMenuCount());
			obj.put("DiscountedCost", detail.getDiscountedCost());
			
			jsonArr.add(obj);
		}
		
		bw.write(jsonArr.toString());
		bw.flush();
		bw.close();
//				
//		BufferedReader br = new BufferedReader(new FileReader("resources/settings/test"));
//		
//		JSONParser parser = new JSONParser();
//		try {
//			JSONObject obj2 = (JSONObject) parser.parse(br.readLine());
//			
//			System.out.println(obj2.get("STORE_ID"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		System.out.println("JsonSimpleTest 종료");
	}

}
