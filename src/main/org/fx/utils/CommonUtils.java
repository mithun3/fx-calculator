package org.fx.utils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

import org.fx.constants.Constants;
import org.fx.engine.service.Engine;
import org.fx.exception.CurrencyException;
import org.fx.validation.Validator;

/**
 * A common utility class.
 * @author 617150
 *
 */
public class CommonUtils {
	
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
			format = new DecimalFormat(map.get(term));
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
	public static boolean isNotNullOrEmpty(String input){
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
	
	/**
	 * A display utility that will display the result in the expected format.
	 * @param input
	 * @param convertedValue
	 * @throws CurrencyException
	 */
	//TODO: aud 0 to aud >> Unable to find rate for AUD/AUD
	private static void display(String[] input, double convertedValue) throws CurrencyException {
		if (convertedValue == 0 && input.length == 4) {
			System.out.println(String.format(Constants.RATE_NOT_FOUND, input[0], input[3]));
		} else if (input.length == 4){
			System.out.println(String.format(Constants.FORMAT_OUTPUT, input[0], input[1], input[3], 
					displayBasedOnprecision(convertedValue, input[3])));
		}
	}
	
	/**
	 * This method takes the scanner input and splits it into a String array.
	 * This string array is then updated by trimming the input, also, it is converted to uppercase as a precaution.
	 * Finally, the expression is validated and then evaluated.
	 * @param scanner				contains the nextLine to be processed.
	 * @param engine				this is an instance of the Engine class which will be used to evaluate the given expression / input.
	 * @throws CurrencyException
	 */
	public static void calculate(Scanner scanner, Engine engine) throws CurrencyException {
		String[] input = scanner.nextLine().trim().split(Constants.SPLIT_BY_SPACE);
		double convertedValue = 0;
		try {
			if(Validator.isExpressionValid(input)){
				input = updateInput(input);
				convertedValue = engine.evaluate(input);
			} else {
				System.err.println(Constants.EXCEPTION_WITH_INPUT);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		display(input, convertedValue);
	}
	
	/**
	 * Method to update input by trimming and converting it to upper case.
	 * @param input
	 * @return
	 */
	private static String[] updateInput(String[] input) {
		input[0] = input[0].trim().toUpperCase();
		input[1] = input[1].trim().toUpperCase();
		input[2] = input[2].trim().toUpperCase();
		input[3] = input[3].trim().toUpperCase();
		return input;
	}

}
