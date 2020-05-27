package org.tdd.kata.stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	@Test
	public void shouldReturnZeroOnEmptyInput() {
		assertEquals(0, App.add(""));
	}
}
