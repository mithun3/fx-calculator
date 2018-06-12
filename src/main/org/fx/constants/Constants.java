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
	public static final String SPLIT_BY_SPACE = "\\s+";
	
	//Regular expressions
	public static String REG_EX_DECIMAL_NUMBER = "[-+]?\\d*\\.?\\d+";

	public static final String CURRENCY_MATRIX_PATH = "currency-matrix.properties";
	public static final String CURRENCY_RATES_PATH = "currency-rates.properties";
	public static final String CURRENCY_DECIMALS_PATH = "currency-decimals.properties";
	
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
	
	public static final String USD = "USD";
	public static final String CAD = "CAD";
	public static final String CNY = "CNY";
	public static final String CZK = "CZK";
	public static final String DKK = "DKK";
	public static final String EUR = "EUR";
	public static final String GBP = "GBP";
	public static final String JPY = "JPY";
	public static final String NOK = "NOK";
	public static final String NZD = "NZD";
	public static final String AUD = "AUD";
	
	public static final String XYZ = "XYZ";
	
	//Lookup Combinations
	public static final String AUDUSD = "AUDUSD";
	public static final String CADUSD = "CADUSD";
	public static final String USDCNY = "USDCNY";
	public static final String EURUSD = "EURUSD";
	public static final String GBPUSD = "GBPUSD";
	public static final String NZDUSD = "NZDUSD";
	public static final String USDJPY = "USDJPY";
	public static final String EURCZK = "EURCZK";
	public static final String EURDKK = "EURDKK";
	public static final String EURNOK = "EURNOK";
	
	//Rates
	public static final String AUDUSD_RATE = "0.8371";
	public static final String CADUSD_RATE = "0.8711";
	public static final String USDCNY_RATE = "6.1715";
	public static final String EURUSD_RATE = "1.2315";
	public static final String GBPUSD_RATE = "1.5683";
	public static final String NZDUSD_RATE = "0.7750";
	public static final String USDJPY_RATE = "119.95";
	public static final String EURCZK_RATE = "27.6028";
	public static final String EURDKK_RATE = "7.4405";
	public static final String EURNOK_RATE = "8.6651";

}
