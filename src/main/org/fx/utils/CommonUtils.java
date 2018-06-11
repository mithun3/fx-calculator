package org.fx.utils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;

import org.fx.constants.Constants;
import org.fx.exception.CurrencyException;

/**
 * A common utility class.
 * @author 617150
 *
 */
public class CommonUtils {
	
	/**
	 * Used to dynamically generate Decimal value to be displayed.
	 * ex. if the precission is 3 this will generate #.###
	 * Which will be substituted in the DecimalFormat constructor.
	 * @param decimals	the number of decimal points a currency is entitled to.
	 * @return			in case of 2 #.## will be returned.
	 */
	//TODO: Change this method
	public static String generateDecimals(String decimals) {
		StringBuilder decimal = new StringBuilder(Constants.HASH_CONSTANT);
		if (isNumeric(decimals)) {
			if (Integer.valueOf(decimals) > 0)
				decimal.append(Constants.PERIOD_CONSTANT);
			for(int i = 0; i < Integer.valueOf(decimals); i++) {
				decimal.append(Constants.HASH_CONSTANT);
			}
		} else {
			try {
				throw new CurrencyException(Constants.EXCEPTION_NOT_A_VALID_NUMBER);
			} catch (CurrencyException e) {
				System.err.println(e.getMessage());
			}
		}
		return decimal.toString();
	}
	
	/**
	 * Used to fetch the precision from the currency decimal properties file
	 * @param convertedValue		the final converted value along with its precision.
	 * @param term					the destination currency.
	 * @return						the final converted value along with its precision.
	 * @throws CurrencyException	in case of an exception.
	 */
	public static String displayBasedOnprecision(double convertedValue, String term) throws CurrencyException {
		DecimalFormat format = null;
		try {
			Map<String, String> map = PropertiesUtil.getInstance().getProperty(Constants.CURRENCY_DECIMALS_PATH);
			format = new DecimalFormat(CommonUtils.generateDecimals(map.get(term)));
		} catch (IOException e) {
			System.err.println(Constants.EXCEPTION_UNABLE_TO_FETCH_CURRENCY_RATES + e.getMessage());
		}
		return format.format(convertedValue);
	}
	
	/**
	 * Simple utility method to construct a String Array.
	 * @param base				Source currency.
	 * @param crossCountryBase	in case the cross via matrix return a currency this will be it.
	 * @param amount			the amount that needs to be converted.
	 * @return					String array of an input argument / expression.
	 */
	public static String[] prepareArray(String base, String crossCountryBase, String amount) {
		return new String[] {base, amount, Constants.TO_CONSTANT, crossCountryBase};
	}

	/**
	 * Simple method to check if a given string is numeric or not.
	 * This method uses regular expression to determine if a given string is numeric.
	 * @param input input is a String array of console input. ex: AUD 10 IN AUD (these params are split into an array)
	 * @return 		return true or false based on the input string.
	 */
	public static boolean isNumeric(String input) {  
	    return input != null && input.matches(Constants.REG_EX_DECIMAL_NUMBER);  
	}  
	
	/**
	 * Simple method to check if a given string is null or empty.
	 * @param input input is a String array of console input. ex: AUD 10 IN AUD (these params are split into an array)
	 * @return		return true if null or empty.
	 */
	public static boolean isNullOrEmpty(String input){
		return input != null && !input.trim().isEmpty();
	}
	
	public static String getCurrencyRate(String baseTermAndRates) {
		Map<String, String> map = null;
		try {
			map = PropertiesUtil.getProperties(Constants.CURRENCY_RATES_PATH);
		} catch (CurrencyException e) {
			System.err.println("Unable to get Currency Rates from properties file." + e);
		}
		return map.get(baseTermAndRates);
	}

}
