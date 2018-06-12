package org.fx.engine.strategy;

import java.io.IOException;

import org.fx.engine.service.Engine;
import org.fx.engine.service.impl.EngineImpl;
import org.fx.exception.CurrencyException;

public class CrossCountryLookup implements Strategy {

	private Engine engine;
	
	@Override
	public double doOperation(String base, String term, double amount, String crossViaMatrixValue) {
		engine = new EngineImpl();
		double calculatedValue = 0;
		try {
			calculatedValue = engine.calculateCrossCountryLookup(base, term, crossViaMatrixValue, String.valueOf(amount));
		} catch (CurrencyException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return calculatedValue;
	}

}
