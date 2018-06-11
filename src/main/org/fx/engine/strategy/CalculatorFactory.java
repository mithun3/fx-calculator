package org.fx.engine.strategy;

import org.fx.constants.Constants;
/**
 * This is a factory class that will generate object of concrete class based on given information.
 * @author 617150
 *
 */
public class CalculatorFactory {
	private Context context;
	/**
	 * This method takes crossViaMatrixValue as one of its input and based on the value creates a context type.
	 * The context type is a Strategy pattern. Based on the Implementation required the respective calculation is performed.
	 * ex: if the crossViaMatrixValue is DIRECT, then a new DirectFeed is instantiated - this is the context.
	 * Using this context we can execute the strategy.
	 * @param crossViaMatrixValue	the currency to be converted is looked up in the cross via matrix, 
	 * 								these values are stored in the properties file, 
	 * 								the returned value could be CCY, INVERTED, DIRECT etc,.
	 * @param base					the source currency to be converted.
	 * @param term					the destination currency.
	 * @param amount				the amount that needs to be converted.
	 * @return						the return is the calculated value of type double.
	 */
	public double getValue(String crossViaMatrixValue, String base, String term, double amount) {
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
