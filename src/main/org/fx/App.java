package org.fx;

import java.util.Scanner;

import org.fx.constants.Constants;
import org.fx.engine.service.Engine;
import org.fx.engine.service.impl.EngineImpl;
import org.fx.exception.CurrencyException;
import org.fx.utils.CommonUtils;
import org.fx.validation.Validator;

/**
 * This is the main class.
 * 
 * @author 617150
 *
 */
public class App {
	/**
	 * This is the main method.
	 * All requests come in through here.
	 * @param args
	 * @throws CurrencyException 
	 */
	public static void main(String[] args) throws CurrencyException {
		System.out.println(Constants.WELCOME_MESSAGE + Constants.WELCOME_EXAMPLE_MESSAGE);
		Scanner scanner = new Scanner(System.in);
		Engine engine = new EngineImpl();
		while(scanner.hasNext()) {
			calculate(scanner, engine);
		}
	}

	/**
	 * 
	 * @param scanner
	 * @param engine
	 * @throws CurrencyException
	 */
	private static void calculate(Scanner scanner, Engine engine) throws CurrencyException {
		String[] input = scanner.nextLine().trim().split(Constants.SPLIT_BY_SPACE);
		double convertedValue = 0;
		try {
			if(Validator.isExpressionValid(input)){
				input = Validator.updateInput(input);
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
	 * 
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
					CommonUtils.displayBasedOnprecision(convertedValue, input[3])));
		}
	}
}
