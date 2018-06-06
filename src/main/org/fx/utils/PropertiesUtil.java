package org.fx.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.fx.constants.Constants;
import org.fx.exception.CurrencyException;

/**
 * This is a singleton Properties Utility.
 * Since we are calling this class / method from 3 different places under different scenarios, 
 * we need to make sure that only one instance of the class is present.
 * @author 617150
 *
 */
public class PropertiesUtil {
	private static PropertiesUtil instance = null;
	private Properties properties;
	private InputStream inputStream = null;
	private static ClassLoader loader = Thread.currentThread().getContextClassLoader();

	/**
	 * private constructor to make sure no one invokes it from outside here.
	 * @throws IOException
	 */
	private PropertiesUtil() throws IOException {
		properties = new Properties();
	}

	/**
	 * lazy loading utility method to obtain only one instance of the class
	 * @return
	 */
	public static PropertiesUtil getInstance() {
		if (instance == null) {
			try {
				instance = new PropertiesUtil();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.err.println(ioe.getMessage());
			}
		}
		return instance;
	}

	/**
	 * Method to get all the properties and load them in a map so that lookup can be achieved faster.
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public Map<String, String> getProperty(String file) throws IOException {
		inputStream = loader.getResourceAsStream(file);
		properties.load(inputStream);
		Map<String, String> map = new HashMap<String, String>();
		for (final Entry<Object, Object> entry : properties.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		return map;
	}
	
	/**
	 * Converted to singleton class.
	 * Not deleting this as this was the original working code.
	 * hence commenting the code
	 */
	
	@SuppressWarnings("finally")
	public static Map<String, String> getProperties(String file) throws CurrencyException {
		InputStream inputStream = null;
		Properties properties = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			inputStream = loader.getResourceAsStream(file);;
			properties.load(inputStream);
			for (final Entry<Object, Object> entry : properties.entrySet()) {
				map.put((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (IOException e) {
			System.err.println(Constants.PROPERTIES_FILE_NOT_FOUND_MESSAGE + e.getMessage());
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException ex) {
				System.err.println(Constants.EXCEPTION_WHILE_CLOSING_MESSAGE + ex.getMessage());
			}
			return map;
		}
	}
	
}
