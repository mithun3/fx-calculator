package org.fx.engine.service;

import java.io.IOException;

import org.fx.exception.CurrencyException;

public interface Engine {
	
	double evaluate(String[] input) throws IOException, CurrencyException;
	
	double getValueBasedOnCrossMatrix(String base, String term, String amount) throws IOException, CurrencyException;
	
	double calculateCrossCountryLookup(String base, String term, String crossCountryBase, String amount) throws CurrencyException, IOException;
	
	String getValueFromCrossViaMatrix(String base, String term) throws CurrencyException;

}