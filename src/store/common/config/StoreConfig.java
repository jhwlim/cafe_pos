package store.common.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class StoreConfig {

	public static int storeId;
	
	private static final String prefix = "resources/settings/";
	private static final String fileName = "store.sav"; 
	
	private static final String STORE_ID = "STORE_ID";
	
	private static final int DEFAULT_STORE_ID = 0;
	
	
	static {
		try {
			BufferedReader br = new BufferedReader(new FileReader(prefix + fileName));
			
			JSONParser parser = new JSONParser();
			JSONObject ob = (JSONObject) parser.parse(br.readLine());
			
			storeId = Integer.parseInt(ob.get(STORE_ID).toString());
			
		} catch (FileNotFoundException e) {	
			storeId = DEFAULT_STORE_ID;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
