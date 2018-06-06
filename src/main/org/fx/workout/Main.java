package org.fx.workout;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.fx.constants.Constants;

public class Main {
	
	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream stream = loader.getResourceAsStream(Constants.CURRENCY_MATRIX_PATH);
			properties.load(stream);
			for (final Entry<Object, Object> entry : properties.entrySet()) {
				map.put((String) entry.getKey(), (String) entry.getValue());
			}
			
			map.forEach((key, value) -> {
				System.out.println("Key : " + key + " Value : " + value);
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
