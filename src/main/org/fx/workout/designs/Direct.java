package org.fx.workout.designs;

public class Direct implements Value{

	@Override
	public double value(Double amount, Double baseTermAndRates) {
		return amount * baseTermAndRates;
	}

}
