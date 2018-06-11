package org.fx.engine.strategy;

import org.fx.utils.CommonUtils;

public class Inverted implements Strategy {

	@Override
	public double doOperation(String base, String term, double amount) {
		double value = Double.valueOf(CommonUtils.getCurrencyRate(term + base));
		return (1 / value) * amount;
	}

}
