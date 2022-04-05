package jogoforca.core;

import java.io.IOException;
import java.util.Properties;

public class config {

	private static Properties props = new Properties();
	
	static {
		try {
			props.load(config.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static String get(String name) {
		return props.getProperty(name);
	}
}
