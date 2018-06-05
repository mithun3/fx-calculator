package org.fx.constants;

/**
 * All hard coded constants go here.
 * @author 617150
 *
 */
public class Constants {
	
	public static final String WELCOME_MESSAGE = "Enter the currency to be converted : ";
	public static final String FX_EXPRESSION_ENTERED = "FX Expression entered : ";
	public static final String WELCOME_EXAMPLE_MESSAGE = "ex. AUD 100.00 TO USD ";
	
	public static final String IN_CONSTANT = "IN";
	public static final String TO_CONSTANT = "TO";
	public static final String HASH_CONSTANT = "#";
	public static final String PERIOD_CONSTANT = ".";
	
	//Regular expressions
	public static String REG_EX_DECIMAL_NUMBER = "[-+]?\\d*\\.?\\d+";

	//TODO: this is wrong it should be read from classpath
	public static final String CURRENCY_MATRIX_PATH = "C:\\code\\fx-calculator\\src\\resources\\currency-matrix.properties";
	public static final String CURRENCY_RATES_PATH = "C:\\code\\fx-calculator\\src\\resources\\currency-rates.properties";
	public static final String CURRENCY_DECIMALS_PATH = "C:\\code\\fx-calculator\\src\\resources\\currency-decimals.properties";
	
	//Cross via matrix values set
	public static final String DIRECT = "DIRECT";
	public static final String INVERTED = "INVERTED";
	public static final String UNITY = "UNITY";

	public static final String INVALID_CURRENCY = "Invalid Currency. ";
	public static final String RATE_NOT_FOUND = "Unable to find rate for %s/%s";
	public static final String FORMAT_OUTPUT = "%s %s = %s %s";

	//Exception Messages
	public static final String PROPERTIES_FILE_NOT_FOUND_MESSAGE = "Could not find the properties file, please check the file and try again. ";
	public static final String EXCEPTION_WHILE_CLOSING_MESSAGE = "IOException Exception occured while closing the file";
	public static final String EXCEPTION_WITH_INPUT = "Problem with the input. ";
	public static final String EXCEPTION_NOT_A_VALID_NUMBER = "Not a valid decimal, does not seem to be numeric. ";
	public static final String EXCEPTION_UNABLE_TO_FETCH_CURRENCY_RATES = "Unable to get Currency Rates from properties file.";

}
