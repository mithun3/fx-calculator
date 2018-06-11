package org.fx.workout.designs.strategy;

import org.fx.utils.CommonUtils;

public class DirectFeed implements Strategy {

	@Override
	public double doOperation(String base, String term, double amount) {
		double value = Double.valueOf(CommonUtils.getCurrencyRate(base + term));
		return amount * value;
	}

}
