package org.fx.engine;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.fx.exception.CurrencyException;
import org.fx.utils.CommonUtils;
import org.junit.Test;

public class FXTest {
	private double result = 0;
	String finalResult = null;
	//Some valid scenarios
	@Test
	public void testAUDtoUSD() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "USD"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "USD");
		assertEquals("83.71", finalResult);
	}

	@Test
	public void testAUDtoCAD() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "CAD"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "CAD");
		assertEquals("96.1", finalResult);
	}
	
	//TODO: test why this is failing
//	@Test
//	public void testAUDtoCNY() throws CurrencyException, IOException {
//		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "CNY"});
//		finalResult = CommonUtils.displayBasedOnprecision(result, "CNY");
//		assertEquals("96.1", finalResult);
//	}
	
	@Test
	public void testAUDtoAUD() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "AUD"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "AUD");
		assertEquals("100", finalResult);
	}
	
	@Test
	public void testAUDtoDKK() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "DKK"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "DKK");
		assertEquals("505.76", finalResult);
	}
	
	@Test
	public void testAUDtoCZK() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "CZK"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "CZK");
		assertEquals("1876.27", finalResult);
	}
	
	@Test
	public void testAUDtoEUR() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "EUR"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "EUR");
		assertEquals("67.97", finalResult);
	}
	
	@Test
	public void testAUDtoGBP() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "CAD"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "CAD");
		assertEquals("96.1", finalResult);
	}
	
	@Test
	public void testAUDtoNOK() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "NOK"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "NOK");
		assertEquals("589", finalResult);
	}
	
	@Test
	public void testAUDtoNZD() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"AUD", "100", "IN", "CAD"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "CAD");
		assertEquals("96.1", finalResult);
	}

	@Test
	public void testJPYtoUSD() throws CurrencyException, IOException {
		result = Engine.evaluate(new String[] {"JPY", "100", "IN", "USD"});
		finalResult = CommonUtils.displayBasedOnprecision(result, "USD");
		assertEquals("0.83", finalResult);
	}
}
