package org.fx.engine.strategy;

/**
 * Using Strategy pattern to implement calculation of currency pair through the cross via matrix.
 * Doing this to change class behavior or its algorithm at run time.
 * We create objects which represent various strategies and a context object whose behavior varies as per its strategy object.
 * Strategy interface defines an action, in our case doOperation this could be calculation of DirectFeed, Inverted, Unity.
 * The above calculations are represented as concrete implementation.
 * @author 617150
 *
 */
public interface Strategy {
	
	/**
	 * this method will be implemented by any Operation class which will have its own concrete implementation.
	 * ex: @see org.fx.engine.strategy.DirectFeed class will write its own calculation.
	 * @param base		source currency.
	 * @param term		destination currency
	 * @param amount	the money that needs to be converted.
	 * @return
	 */
	public double doOperation(String base, String term, double amount, String crossViaMatrixValue);

}
