package org.fx.engine.value;

public class Unity implements Value {

	@Override
	public double value(Double amount, String base, String term) {
		return amount;
	}

}
