package org.fx.workout.designs.strategy;

import org.fx.constants.Constants;

public class CalculatorFactory {
	private Context context;
	public Double getValue(String crossViaMatrixValue, String base, String term, double amount) {
		if (crossViaMatrixValue.equalsIgnoreCase(Constants.DIRECT)) {
			context = new Context(new DirectFeed());
		} else if (crossViaMatrixValue.equalsIgnoreCase(Constants.INVERTED)) {
			context = new Context(new Inverted());
		} else if (crossViaMatrixValue.equalsIgnoreCase(Constants.UNITY)) {
			context = new Context(new Unity());
		}
		return context.executeStrategy(base, term, amount);
	}

}
