package org.fx.engine.strategy;

/**
 * Context is a class which uses a Strategy.
 * @author 617150
 *
 */
public class Context {
	
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public double executeStrategy(String base, String term, double amount, String crossViaMatrixValue) {
		return strategy.doOperation(base, term, amount, crossViaMatrixValue);
	}
}