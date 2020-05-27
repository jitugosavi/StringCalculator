package org.tdd.kata.stringCalculator;

public class App 
{
    public static int add(String number) {
    	if (number == null || number.length() <= 0) {
    		return 0;
    	} else if (number.contains(",")) {
    		String[] numbers = number.split(",");
    		return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]); 
    	}
    	else {
    		return Integer.parseInt(number);
    	}
    }
}
