package common.config;

public class Configs {
	
	private static String hikariConfigPath;
	
	static {
		hikariConfigPath = "resources/config/hikari.properties";
	}
	
	public static String getHikariConfigPath() {
		return hikariConfigPath;
	}
}
