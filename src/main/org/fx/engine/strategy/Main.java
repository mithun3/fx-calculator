package org.fx.engine.strategy;

import org.fx.constants.Constants;

public class Main {

	public static void main(String[] args) {
		CalculatorFactory calculatorFactory = new CalculatorFactory();
		System.out.println(calculatorFactory.getValue(Constants.INVERTED, "AUD", "NZD", 100));
	}

}
