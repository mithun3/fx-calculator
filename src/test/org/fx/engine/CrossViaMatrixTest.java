package org.fx.engine;

import static org.junit.Assert.assertEquals;

import org.fx.constants.Constants;
import org.fx.engine.service.Engine;
import org.fx.engine.service.impl.EngineImpl;
import org.fx.exception.CurrencyException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CrossViaMatrixTest {
	
	String crossViaMatrixValue = null;
	private Engine engine;
	String base = null;
	String term = null;
	
	@Before
	public void before() {
		engine = new EngineImpl();
	}
	
	@After
	public void after() {
		engine = null;
		base = null;
		term = null;
	}
	
	@Test
	public void testValueForAUDUSA() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.AUD);
		assertEquals("UNITY", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCAD() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.CAD);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCNY() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.CNY);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCZK() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.CZK);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDDKK() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.DKK);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDEUR() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.EUR);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDGBP() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.GBP);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDJPY() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.JPY);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDNOK() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.NOK);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDNZD() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.NZD);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDUSD() throws CurrencyException {
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(Constants.AUD, Constants.USD);
		assertEquals("DIRECT", crossMatrixValue);
	}
}
