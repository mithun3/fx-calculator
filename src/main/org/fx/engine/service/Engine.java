package org.fx.engine.service;

import java.io.IOException;

import org.fx.exception.CurrencyException;

public interface Engine {
	
	Double evaluate(String[] input) throws IOException, CurrencyException;
	
	Double getValueBasedOnCrossMatrix(String base, String term, String amount) throws IOException, CurrencyException;
	
	Double calculateCrossCountryLookup(String base, String term, String crossCountryBase, String amount) throws CurrencyException, IOException;
	
	String getValueFromCrossViaMatrix(String base, String term) throws CurrencyException;

}