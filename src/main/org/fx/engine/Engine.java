package org.fx.engine;

import java.io.IOException;
import java.util.Map;

import org.fx.constants.Constants;
import org.fx.constants.Currency;
import org.fx.exception.CurrencyException;
import org.fx.utils.CommonUtils;
import org.fx.utils.PropertiesUtil;

/**
 * This is the class that is responsible for forex calculation.
 * @author 617150
 *
 */
public class Engine {

	/**
	 * This method takes all the inputs and calculates the cross-via matrix value from the properties file.
	 * Also, it gets the FX Rate by invoking the appropriate method.
	 * @param input					input is a String array of console input. ex: AUD 10 IN AUD (these params are split into an array)
	 * @return						the return value is an evaluated double value
	 * @throws CurrencyException 	this exception is thrown when something goes wrong. ex: invalid number, currency, input etc,.
	 * @throws IOException 			when there is something wrong with the input file.
	 */
	public static double evaluate(String[] input) throws CurrencyException, IOException {
		String base = input[0];
		String term = input[3];
		String amount = input[1];
		String crossViaMatrixValue = getValueFromCrossViaMatrix(input);
		return getValueBasedOnCrossMatrix(crossViaMatrixValue, base, term, amount);
	}

	/**
	 * This method calculates the final forex rate by looking up the necessary properties file.
	 * This method will give the forex rate based on Direct, Inverted or Unity
	 * If the value is a reverse country look up / then it invokes neccessary method to handle the same. 
	 * @param crossViaMatrixValue	the currency to be converted is looked up in the cross via matrix, these values are stored in the properties file, 
	 * 								the returned value could be CCY, INVERTED, DIRECT etc,.
	 * @param base					source currency.
	 * @param term					destination currency.
	 * @param amount				the amount that need to be converted.
	 * @return						the cross matrix values are returned. ex: AUD to AUD is DIRECT.
	 * @throws CurrencyException 	in case of an exception.
	 */
	private static double getValueBasedOnCrossMatrix(String crossViaMatrixValue, String base, String term, String amount) throws IOException, CurrencyException {
		double convertedValue = 0;
		String baseTermAndRates = base + term;
		Map<String, String> map = null;
		//map = PropertiesUtil.getInstance().getProperty(Constants.CURRENCY_RATES_PATH);
		map = PropertiesUtil.getProperties(Constants.CURRENCY_RATES_PATH);
		//Based on the crossViaMatrixValue we should determine how to calculate DIRECT / INVERTED / UNITY
		if(crossViaMatrixValue.equals(Constants.DIRECT)) {
			convertedValue = Double.valueOf(amount) * Double.valueOf(map.get(baseTermAndRates));
		} else if (crossViaMatrixValue.equals(Constants.INVERTED)) {
			convertedValue = (1 / Double.valueOf(map.get(term + base))) * Double.valueOf(amount);
			//convertedValue = (1 / Double.valueOf(map.get(baseTermAndRates))) * Double.valueOf(amount);
		} else if (crossViaMatrixValue.equals(Constants.UNITY)) {
			convertedValue = Double.valueOf(amount);
		} else if (crossViaMatrixValue.contains(Currency.lookup(crossViaMatrixValue).toString())) {
			convertedValue = calculateCrossCountryLookup(base, term, crossViaMatrixValue, amount);
		}
		return convertedValue;
	}

	/**
	 * This is sort of a recursive call.
	 * ex AUD 100 IN DKK
	 * For the above example there are the country is looked up 3 times.
	 * First, USD, then EURO and finally Danish Krone.
	 * In this scenario this method is recursively called 3 times.
	 * @param base					source currency.
	 * @param term					destination currency.
	 * @param crossCountryBase		in case the Cross Country matrix returns another CCY. ex: CAD to AUD is USD.
	 * @param amount				the amount that need to be converted.
	 * @return						the Cross Country matrix returned.
	 * @throws CurrencyException 	in case something goes wrong / in case of an exception.
	 * @throws IOException 			if there is problem reading the properties file.
	 */
	private static double calculateCrossCountryLookup(String base, String term, String crossCountryBase, String amount) throws CurrencyException, IOException {
		String[] inputOne = CommonUtils.prepareArray(base, crossCountryBase, amount);
		double convertedValueOne = evaluate(inputOne);

		String[] inputTwo = CommonUtils.prepareArray(crossCountryBase, term, String.valueOf(convertedValueOne));
		double convertedValueTwo = evaluate(inputTwo);
		
		return convertedValueTwo;
	}

	/**
	 * Used in getting the value from Cross Via Matrix properties.
	 * @param input	input is a String array of console input. ex: AUD 10 IN AUD (these params are split into an array)
	 * @return		the currency matrix key after reading from the map extracted out of the properties file.
	 */
	protected static String getValueFromCrossViaMatrix(String[] input) throws CurrencyException {
		Map<String, String> map = null;
		try {
			map = PropertiesUtil.getInstance().getProperty(Constants.CURRENCY_MATRIX_PATH);
		} catch (IOException e) {
			System.err.println("Unable to get Currency Matrix from properties file." + e);
			
		}
		String currencyMatrixKey = input[0] + input[3];
		return map.get(currencyMatrixKey);
	}
}
