package org.fx.workout.designs;

public class Inverted implements Value{

	@Override
	public double value(Double amount, Double baseTermAndRates) {
		return (1 / amount) * amount;
	}

}
