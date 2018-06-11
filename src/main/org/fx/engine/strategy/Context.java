package org.fx.engine.strategy;

public class Context {
	
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public double executeStrategy(String base, String term, double amount) {
		return strategy.doOperation(base, term, amount);
	}
}