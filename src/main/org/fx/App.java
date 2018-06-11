package org.fx;

import java.util.Scanner;

import org.fx.constants.Constants;
import org.fx.engine.service.Engine;
import org.fx.engine.service.impl.EngineImpl;
import org.fx.exception.CurrencyException;
import org.fx.utils.CommonUtils;

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
	 * 
	 * @param args
	 * @throws CurrencyException 
	 */
	public static void main(String[] args) throws CurrencyException {
		System.out.println(Constants.WELCOME_MESSAGE + Constants.WELCOME_EXAMPLE_MESSAGE);
		Scanner scanner = new Scanner(System.in);
		Engine engine = new EngineImpl();
		while(scanner.hasNext()) {
			CommonUtils.calculate(scanner, engine);
		}
	}
}
