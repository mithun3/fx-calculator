package org.fx.engine.value;

import org.fx.utils.CommonUtils;

public class Inverted implements Value{

	@Override
	public double value(Double amount, String base, String term) {
		double value = Double.valueOf(CommonUtils.getCurrencyRate(term + base));
		return (1 / value) * amount;
	}

}
