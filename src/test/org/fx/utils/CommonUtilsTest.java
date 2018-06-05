package org.fx.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.fx.exception.CurrencyException;
import org.junit.Test;

/**
 * 
 * @author 617150
 *
 */
public class CommonUtilsTest {
	
	@Test
	public void testGenerateDecimalsNoDecimals() {
		assertEquals("#", CommonUtils.generateDecimals("0"));
	}
	@Test
	public void testGenerateDecimalsOne() {
		assertEquals("#.#", CommonUtils.generateDecimals("1"));
	}
	@Test
	public void testGenerateDecimalsTwo() {
		assertEquals("#.##", CommonUtils.generateDecimals("2"));
	}

	@Test (expected = AssertionError.class)
	public void testGenerateDecimalsInvalidNumber() {
		try {
			CommonUtils.generateDecimals("One");
		} catch (Exception re) {
			String message = "Not a valid decimal, does not seem to be numeric. ";
			assertEquals(message, re.getMessage());
			assertEquals("#", CommonUtils.generateDecimals("One"));
			throw re;
		}
		fail("Not a valid decimal, does not seem to be numeric. ");
	}
}
