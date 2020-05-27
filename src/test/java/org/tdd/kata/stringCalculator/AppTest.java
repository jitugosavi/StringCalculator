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
	
	@Test
	public void shouldReturnSameNumberOnOneNumberInString() {
		assertEquals(5, App.add("5"));
	}
	
	@Test
	public void shouldReturnSumOnCommaSeparatedTwoNumbers() {
		assertEquals(12, App.add("7,5"));
	}
}
