package org.fx.validation;

import org.fx.constants.Constants;
import org.fx.constants.Currency;
import org.fx.utils.CommonUtils;

/**
 * Simple Validator class.
 * 
 * @author 617150
 *
 */
public class Validator {
	/**
	 * Method to check if the given expression is valid or not.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isExpressionValid(String[] input) {
		try {
			if (isFirstArgumentValid(input[0].toUpperCase()) && isSecondArgumentValid(input[1])
					&& isThirdArgumentValid(input[2].toUpperCase()) && isFourthArgumentValid(input[3].toUpperCase())) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Something wrong with the input parameters");
		}
		return false;
	}

	/**
	 * Method to check if first argument from the input Array is valid or not.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isFirstArgumentValid(String input) {
		if (CommonUtils.isNotNullOrEmpty(input) && isValidCurrency(input))
			return true;
		return false;
	}

	/**
	 * Method to check if second argument from the input Array is valid or not.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isSecondArgumentValid(String input) {
		if (CommonUtils.isNotNullOrEmpty(input) && CommonUtils.isNumeric(input))
			return true;
		return false;
	}

	/**
	 * Method to check if third argument from the input Array is valid or not.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isThirdArgumentValid(String input) {
		if (CommonUtils.isNotNullOrEmpty(input)
				&& (input.contains(Constants.TO_CONSTANT) || input.contains(Constants.IN_CONSTANT)))
			return true;
		return false;
	}

	/**
	 * Method to check if fourth argument from the input Array is valid or not.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isFourthArgumentValid(String input) {
		if (CommonUtils.isNotNullOrEmpty(input) && isValidCurrency(input))
			return true;
		return false;
	}

	/**
	 * Method to check if the Currency is valud or not.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isValidCurrency(String input) {
		boolean isValid = false;
		if (CommonUtils.isNotNullOrEmpty(input) && input.contains(Currency.lookup(input).toString())) {
			isValid = true;
		} else {
			System.out.println(Constants.INVALID_CURRENCY + input);
		}
		return isValid;
	}
}
