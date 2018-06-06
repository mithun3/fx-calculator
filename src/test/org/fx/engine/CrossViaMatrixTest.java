package org.fx.engine;

import static org.junit.Assert.assertEquals;

import org.fx.engine.service.Engine;
import org.fx.engine.service.impl.EngineImpl;
import org.fx.exception.CurrencyException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CrossViaMatrixTest {
	
	String crossViaMatrixValue = null;
	private Engine engine;
	private String[] input;
	
	@Before
	public void before() {
		engine = new EngineImpl();
	}
	
	@After
	public void after() {
		engine = null;
		input = null;
	}
	
	@Test
	public void testValueForAUDUSA() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "AUD"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("UNITY", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCAD() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "CAD"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCNY() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "CNY"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCZK() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "CZK"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDDKK() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "DKK"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDEUR() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "EUR"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDGBP() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "GBP"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDJPY() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "JPY"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDNOK() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "NOK"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDNZD() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "NZD"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDUSD() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "USD"};
		String crossMatrixValue = engine.getValueFromCrossViaMatrix(input);
		assertEquals("DIRECT", crossMatrixValue);
	}
	

}
