package org.tdd.kata.stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
	
	@Test
	public void shouldReturnSumOfAllOnMultipleCommaSeparatedNumbers() {
		assertEquals(23, App.add("12,8,3"));
	}
	
	@Test
	public void shouldReturnSumOnNewLineAndCommaSeparatedNumbers() {
		assertEquals(23, App.add("12\n8,3"));
	}
	
	@Test
	public void shouldReturnSumOnCustomDelimeter() {
		assertEquals(23, App.add("//;\n12;8;3"));
	}
	
	@Test
	public void shouldReturnSumIfCustomDelimeterIsSpeacialChar() {
		assertEquals(23, App.add("//.\n12.8.3"));
	}
	
	@Test
	public void shouldRaiseExceptionOnNegativeNumbers() {
		try {
			App.add("-1,2,3");
			fail("Exeception expected");
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void exceptionMessageShouldContainNegativeNumber() {
		try {
			App.add("-1,2,3");
			fail("Exeception expected");
		} catch (Exception e) {
			assertEquals("Negatives not allowed : -1", e.getMessage());
		}
	}
	
	@Test
	public void exceptionMessageShouldContainMultipleNegativeNumbers() {
		try {
			App.add("-1,-22,3");
			fail("Exeception expected");
		} catch (Exception e) {
			assertEquals("Negatives not allowed : -1,-22", e.getMessage());
		}
	}
	
	@Test
	public void shouldIgnoreNumberGreaterThanOneThousand() {
		assertEquals(23, App.add("12,1004,11"));
	}
	
	@Test
	public void shouldAllowDelimeterWithLengthMoreThanOne() {
		assertEquals(23, App.add("//***\n12***8***3"));
	}
	
	@Test
	public void shouldAllowMultipleDelimeters() {
		assertEquals(6, App.add("//[*][%]\n1*2%3"));
	}
	
	@Test 
	public void shouldAllowMultipleDeliemetersWithLengthMoreThanOne() {
		assertEquals(6, App.add("//[***][%%%]\n1***2%%%3"));
	}
 }
