package org.fx.engine;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.fx.exception.CurrencyException;
import org.junit.Test;

public class EngineTest {
	private String[] input;
	
	@Test
	public void testEvaluate() throws CurrencyException, IOException {
		input = new String[]{"AUD", "100", "IN", "AUD"};
		double result = Engine.evaluate(input);
		assertEquals(100, result, 0);
	}
	
}
