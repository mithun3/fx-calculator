package org.fx.engine.value;

import org.fx.utils.CommonUtils;

public class Direct implements Value{

	@Override
	public double value(Double amount, String base, String term) {
		double value = Double.valueOf(CommonUtils.getCurrencyRate(base + term));
		return amount * value;
	}

}
