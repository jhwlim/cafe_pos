package orderlist.controller.window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < jsonArr.size(); i++) {
					JSONObject obj = (JSONObject) jsonArr.get(i);

					int orderId = Integer.parseInt(obj.get("orderId").toString());
					list.add(orderId);
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
			File folder = new File(prefix);
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			bw = new BufferedWriter(new FileWriter(prefix + fileName));

			List<Integer> list = OrderListConfig.getList();
			JSONArray jsonArr = new JSONArray();

			for (int i = 0; i < list.size(); i++) {
				JSONObject obj = new JSONObject();
				
				int orderId = list.get(i);
				obj.put("orderId", orderId);
			
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
