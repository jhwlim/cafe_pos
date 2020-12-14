package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleTest {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("resources/settings/store.sav"));
	
		JSONObject obj = new JSONObject();
		
		obj.put("STORE_ID", 1);
//		obj.put("ob2", "테스트");
		
		bw.write(obj.toString());
		bw.flush();
		bw.close();
				
		BufferedReader br = new BufferedReader(new FileReader("resources/settings/store.sav"));
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj2 = (JSONObject) parser.parse(br.readLine());
			
			System.out.println(obj2.get("STORE_ID"));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
