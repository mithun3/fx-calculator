package org.fx.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.fx.constants.Constants;
import org.fx.exception.CurrencyException;
import org.junit.After;
import org.junit.Test;

/**
 * 
 * @author 617150
 *
 */
public class CommonUtilsTest {
	
	double convertedValue;
	
	@After
	public void after() {
		convertedValue = 0;
	}
	
	@Test
	public void testDisplayBasedOnprecisionAUD() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.AUD);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionCAD() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.CAD);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionCNY() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.CNY);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionCZK() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.CZK);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionDKK() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.DKK);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionEUR() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.EUR);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionGBP() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.GBP);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionJPY() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.JPY);
		assertEquals(result, "1");
	}
	
	@Test
	public void testDisplayBasedOnprecisionNOK() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.NOK);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionNZD() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.NZD);
		assertEquals(result, "1.23");
	}
	
	@Test
	public void testDisplayBasedOnprecisionUSD() throws CurrencyException {
		convertedValue = 1.2345;
		String result = CommonUtils.displayBasedOnprecision(convertedValue, Constants.USD);
		assertEquals(result, "1.23");
	}
	
	@Test (expected = AssertionError.class)
	public void testDisplayBasedOnprecisionNegative() throws CurrencyException {
		convertedValue = 1.234;
		try {
			CommonUtils.displayBasedOnprecision(convertedValue, Constants.XYZ);
		} catch (NullPointerException npe) {
			String message = "Unable to get Currency Rates from properties file.";
			assertEquals(message, npe.getMessage());
			throw npe;
		}
		fail("Unable to get Currency Rates from properties file.");
	}
	
	@Test
	public void testIsNumeric() {
		String testString = "1.234";
		boolean result = CommonUtils.isNumeric(testString);
		assertEquals(result, true);
	}
	
	@Test
	public void testIsNotNumeric() {
		String testString = "1.234zbc";
		boolean result = CommonUtils.isNumeric(testString);
		assertEquals(result, false);
	}
	
	
	@Test
	public void testIsNull() {
		String testString = null;
		boolean result = CommonUtils.isNotNullOrEmpty(testString);
		assertEquals(result, false);
	}
	
	@Test
	public void testIsEmpty() {
		String testString = "";
		boolean result = CommonUtils.isNotNullOrEmpty(testString);
		assertEquals(result, false);
	}
	
	@Test
	public void testIsNotNullOrEmpty() {
		String testString = "abc";
		boolean result = CommonUtils.isNotNullOrEmpty(testString);
		assertEquals(result, true);
	}
	
	@Test
	public void testGetCurrencyRates() {
		assertEquals(CommonUtils.getCurrencyRate(Constants.AUDUSD), Constants.AUDUSD_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.CADUSD), Constants.CADUSD_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.USDCNY), Constants.USDCNY_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.EURUSD), Constants.EURUSD_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.GBPUSD), Constants.GBPUSD_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.NZDUSD), Constants.NZDUSD_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.USDJPY), Constants.USDJPY_RATE);		
		assertEquals(CommonUtils.getCurrencyRate(Constants.EURCZK), Constants.EURCZK_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.EURDKK), Constants.EURDKK_RATE);
		assertEquals(CommonUtils.getCurrencyRate(Constants.EURNOK), Constants.EURNOK_RATE);
	}
	
}
