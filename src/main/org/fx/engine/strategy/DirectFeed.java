package org.fx.engine.strategy;

import org.fx.utils.CommonUtils;

/**
 * This class is the concrete implementation implementing from Strategy interface.
 * We can write a logic which will work in an isolated manner.
 * 
 * @author 617150
 *
 */
public class DirectFeed implements Strategy {

	@Override
	public double doOperation(String base, String term, double amount, String crossViaMatrixValue) {
		double value = Double.valueOf(CommonUtils.getCurrencyRate(base + term));
		return amount * value;
	}
}
