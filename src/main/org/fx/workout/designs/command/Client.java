package org.fx.workout.designs.command;

import org.fx.constants.Constants;

public class Client {
	
	public static void main(String[] args) {
		CalculatorFactory calculatorFactory = new CalculatorFactory();
		calculatorFactory.process(Constants.INVERTED, "AUD", "USD", 0);
		System.out.println();
	}

}
