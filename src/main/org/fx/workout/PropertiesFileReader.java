package org.fx.workout;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.fx.constants.Constants;
import org.fx.exception.CurrencyException;

public class PropertiesFileReader {

	public static void main(String[] args) {
		Map<String, String> map = null;
		try {
			map = getProperty(Constants.CURRENCY_MATRIX_PATH);
		} catch (CurrencyException e) {
			e.printStackTrace();
		}
		map.forEach((key, value) -> {
			System.out.println("Key : " + key + " Value : " + value);
		});
	}

	@SuppressWarnings("finally")
	public static Map<String, String> getProperty(String filePath) throws CurrencyException {
		FileInputStream inputStream = null;
		Properties properties = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
			for (final Entry<Object, Object> entry : properties.entrySet()) {
				map.put((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(Constants.PROPERTIES_FILE_NOT_FOUND_MESSAGE + e.getMessage());
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException ex) {
				throw new CurrencyException(Constants.EXCEPTION_WHILE_CLOSING_MESSAGE);
			}
			return map;
		}
	}
}
