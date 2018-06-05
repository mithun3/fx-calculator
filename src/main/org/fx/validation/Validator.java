package org.fx.validation;

import org.fx.constants.Constants;
import org.fx.constants.Currency;
import org.fx.utils.CommonUtils;
/**
 * Simple Validator class.
 * @author 617150
 *
 */
public class Validator {
	/**
	 * Method to check if the given expression is valid or not.
	 * @param input
	 * @return
	 */
	public static boolean isExpressionValid(String[] input){
		try {
			if(isFirstArgumentValid(input[0].toUpperCase())
					&& isSecondArgumentValid(input[1])
					&& isThirdArgumentValid(input[2].toUpperCase())
					&& isFourthArgumentValid(input[3].toUpperCase()))
				return true;
		} catch (Exception e) {
			System.out.println("Something wrong with the input parameters");
		}
		return false;
	}
	
	/**
	 * Method to check if first argument from the input Array is valid or not.
	 * @param input
	 * @return
	 */
	public static boolean isFirstArgumentValid(String input){
		if(CommonUtils.isNullOrEmpty(input) && isValidCurrecy(input))
			return true;
		return false;
	}

	/**
	 * Method to check if second argument from the input Array is valid or not.
	 * @param input
	 * @return
	 */
	public static boolean isSecondArgumentValid(String input){
		if(CommonUtils.isNullOrEmpty(input) && CommonUtils.isNumeric(input))
			return true;
		return false;
	}

	/**
	 * Method to check if third argument from the input Array is valid or not.
	 * @param input
	 * @return
	 */
	public static boolean isThirdArgumentValid(String input){
		if(CommonUtils.isNullOrEmpty(input) && (input.contains(Constants.TO_CONSTANT) || input.contains(Constants.IN_CONSTANT)))
			return true;
		return false;
	}

	/**
	 * Method to check if fourth argument from the input Array is valid or not.
	 * @param input
	 * @return
	 */
	public static boolean isFourthArgumentValid(String input){
		if(CommonUtils.isNullOrEmpty(input) && isValidCurrecy(input))
			return true;
		return false;
	}
	
	/**
	 * Method to check if the Currency is valud or not.
	 * @param input
	 * @return
	 */
	public static boolean isValidCurrecy(String input){
		boolean isValid = false;
		if(CommonUtils.isNullOrEmpty(input) && input.contains(Currency.lookup(input).toString()))
			isValid = true;
		if(!isValid)
			System.out.println(Constants.INVALID_CURRENCY + input);
		return isValid;
	}
	
	/**
	 * Method to update input by trimming and converting it to upper case.
	 * @param input
	 * @return
	 */
	public static String[] updateInput(String[] input) {
		input[0] = input[0].trim().toUpperCase();
		input[1] = input[1].trim().toUpperCase();
		input[2] = input[2].trim().toUpperCase();
		input[3] = input[3].trim().toUpperCase();
		return input;
	}

}
