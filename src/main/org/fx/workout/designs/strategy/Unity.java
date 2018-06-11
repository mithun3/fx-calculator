package org.fx.workout.designs.strategy;

public class Unity implements Strategy {

	@Override
	public double doOperation(String base, String term, double amount) {
		return amount;
	}
	
}
