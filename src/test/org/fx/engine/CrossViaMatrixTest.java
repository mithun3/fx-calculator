package org.fx.engine;

import static org.junit.Assert.assertEquals;

import org.fx.exception.CurrencyException;
import org.junit.Test;

public class CrossViaMatrixTest {
	
	String crossViaMatrixValue = null;
	private String[] input;
	
	@Test
	public void testValueForAUDUSA() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "AUD"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("UNITY", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCAD() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "CAD"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCNY() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "CNY"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDCZK() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "CZK"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDDKK() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "DKK"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDEUR() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "EUR"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDGBP() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "GBP"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDJPY() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "JPY"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDNOK() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "NOK"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDNZD() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "NZD"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("USD", crossMatrixValue);
	}
	
	@Test
	public void testValueForAUDUSD() throws CurrencyException {
		input = new String[]{"AUD", "100", "IN", "USD"};
		String crossMatrixValue = Engine.getValueFromCrossViaMatrix(input);
		assertEquals("DIRECT", crossMatrixValue);
	}
	

}
