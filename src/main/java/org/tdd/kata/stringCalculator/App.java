package org.tdd.kata.stringCalculator;

public class App 
{
    public static int add(String number) {
    	if (number == null || number.length() <= 0) {
    		return 0;
    	} else if (number.contains(",")) {
    		String[] numbers = number.split(",");
    		int sum = 0;
    		
    		for (int i = 0; i < numbers.length; i++) {
    			sum += Integer.parseInt(numbers[i]);
    		}
    		
    		return sum; 
    	}
    	else {
    		return Integer.parseInt(number);
    	}
    }
}
