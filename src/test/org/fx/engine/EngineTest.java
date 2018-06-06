package org.fx.engine;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.fx.engine.service.Engine;
import org.fx.engine.service.impl.EngineImpl;
import org.fx.exception.CurrencyException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EngineTest {
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
	public void testEvaluate() throws CurrencyException, IOException {
		input = new String[]{"AUD", "100", "IN", "AUD"};
		double result = engine.evaluate(input);
		assertEquals(100, result, 0);
	}
	
}
