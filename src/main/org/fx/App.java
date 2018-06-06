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
		System.out.println(Constants.WELCOME_MESSAGE);
		System.out.print(Constants.WELCOME_EXAMPLE_MESSAGE);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//Scan the input and wait for next input
		while(scanner.hasNext()) {
			String[] input = scanner.nextLine().trim().split("\\s+");
			double convertedValue = 0;
			//System.out.println(Constants.FX_EXPRESSION_ENTERED + Arrays.toString(input));
			try {
				if(Validator.isExpressionValid(input)){
					input = Validator.updateInput(input);
					Engine engine = new EngineImpl();
					convertedValue = engine.evaluate(input);
				} else {
					throw new CurrencyException(Constants.EXCEPTION_WITH_INPUT);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			if (convertedValue == 0 && input.length == 4) {
				System.out.println(String.format(Constants.RATE_NOT_FOUND, input[0], input[3]));
			} else if (input.length == 4){
				System.out.println(String.format(Constants.FORMAT_OUTPUT, input[0], input[1], input[3], 
						CommonUtils.displayBasedOnprecision(convertedValue, input[3])));
			}
		}
	}
}
