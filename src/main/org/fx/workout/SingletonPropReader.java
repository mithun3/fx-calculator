package org.fx.workout;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

public class SingletonPropReader {

	private static SingletonPropReader instance = null;
	private Properties properties;
	private FileInputStream inputStream = null;

	private SingletonPropReader() throws IOException {
		properties = new Properties();
	}

	public static SingletonPropReader getInstance() {
		if (instance == null) {
			try {
				instance = new SingletonPropReader();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return instance;
	}

	public Map<String, String> getKeyValues(String path) throws IOException {
		inputStream = new FileInputStream(path);
		properties.load(inputStream);
		Map<String, String> map = new HashMap<String, String>();
		for (final Entry<Object, Object> entry : properties.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		return map;
	}

	public static void main(String[] args) throws IOException {
		Map<String, String> map = SingletonPropReader.getInstance().getKeyValues("C:\\code\\fx-calculator\\resources\\currency-matrix.properties");
		map.forEach((key, value) -> {
			System.out.println("Key : " + key + " Value : " + value);
		});
	}
}
