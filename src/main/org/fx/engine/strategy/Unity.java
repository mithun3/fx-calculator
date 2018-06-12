package org.fx.engine.strategy;

/**
 * This class is the concrete implementation implementing from Strategy interface.
 * We can write a logic which will work in an isolated manner.
 * 
 * @author 617150
 *
 */
public class Unity implements Strategy {

	@Override
	public double doOperation(String base, String term, double amount, String crossViaMatrixValue) {
		return amount;
	}
	
}
